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
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gameServlet = new GameServlet();
    }

    @Test
    public void testDoPost_Restart() throws ServletException, IOException {
        when(request.getParameter("restart")).thenReturn("true");
        when(request.getSession()).thenReturn(session);
        gameServlet.doPost(request, response);

        verify(session).invalidate();
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    public void testDoPost_NewGame() throws ServletException, IOException {
        when(request.getParameter("nombre")).thenReturn("Juan");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(null);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(requestDispatcher);

        gameServlet.doPost(request, response);

        verify(session).setAttribute(eq("game"), any(GameModelo.class));
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_WithAnswer() throws ServletException, IOException {

        GameModelo game = new GameModelo();
        when(request.getParameter("respuesta")).thenReturn("respuesta1");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(game);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(requestDispatcher);

        gameServlet.doPost(request, response);

        verify(request).setAttribute("pregunta", game.getPregunta());
        verify(request).setAttribute("respuestas", game.getOpciones());
        verify(request).setAttribute("resultado", game.getResultado());
        verify(requestDispatcher).forward(request, response);
    }
}
