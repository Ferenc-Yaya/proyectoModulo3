package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import modelo.GameModelo;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String restart = request.getParameter("restart");
        if (restart != null) {
            session.invalidate();
            response.sendRedirect("index.jsp");
            return;
        }

        String nombre = request.getParameter("nombre");
        if (nombre != null) {
            session.setAttribute("nombre", nombre);
        }

        GameModelo game = (GameModelo) session.getAttribute("game");
        if (game == null) {
            game = new GameModelo();
            session.setAttribute("game", game);
        }

        String respuesta = request.getParameter("respuesta");
        if (respuesta != null) {
            game.cadenaRespuestas(respuesta);
        }

        request.setAttribute("pregunta", game.getPregunta());
        request.setAttribute("respuestas", game.getRepuestas());
        request.setAttribute("resultado", game.getResultado());
        request.setAttribute("nombre", nombre);

        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
}

