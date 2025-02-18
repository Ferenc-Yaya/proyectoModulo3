package pe.edu.codegym.control;

import static org.mockito.Mockito.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.edu.codegym.modelo.GameModelo;

import java.io.IOException;

public class GameServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;

    private GameServlet gameServlet;

    @BeforeEach
    public void inicializar() {
        MockitoAnnotations.openMocks(this);
        gameServlet = new GameServlet();
    }
    @Test
    void testDoPost_Nombre() throws Exception {
        //Given
        // When
        when(request.getParameter("nombre")).thenReturn("Juan");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(requestDispatcher);

        gameServlet.doPost(request, response);
        // Then
        verify(session).setAttribute("nombre", "Juan");
        verify(request).setAttribute("nombre", "Juan");
        verify(requestDispatcher).forward(request, response);
    }
    @Test
    public void testDoPostRestart() throws ServletException, IOException {
        // Given
        // When
        when(request.getParameter("restart")).thenReturn("true");
        when(request.getSession()).thenReturn(session);
        gameServlet.doPost(request, response);
        // Then
        verify(session).invalidate();
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    public void testDoPostNuevoJuego() throws ServletException, IOException {
        // Given
        // When
        when(request.getParameter("nombre")).thenReturn("Juan");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(null);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(requestDispatcher);
        gameServlet.doPost(request, response);

        // Then
        verify(session).setAttribute(eq("game"), any(GameModelo.class));
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostRespuesta() throws ServletException, IOException {
        // Given
        GameModelo game = new GameModelo();
        // When
        when(request.getParameter("respuesta")).thenReturn("respuesta1");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(game);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(requestDispatcher);
        gameServlet.doPost(request, response);
        // Then
        verify(request).setAttribute("pregunta", game.getPregunta());
        verify(request).setAttribute("opciones", game.getOpciones());
        verify(request).setAttribute("resultado", game.getResultado());
        verify(requestDispatcher).forward(request, response);
    }

}
