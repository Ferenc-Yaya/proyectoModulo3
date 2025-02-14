package pe.edu.codegym.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameModeloTest {

    private GameModelo game;

    @BeforeEach
    public void setUp() {
        game = new GameModelo();
    }

    @Test
    public void testInicializacion() {
        assertEquals("Perdiste la memoria. ¿Aceptas el desafío OVNI?", game.getPregunta());
        assertArrayEquals(new String[]{"Acepta el reto", "Rechaza el desafío"}, game.getOpciones());
        assertEquals("", game.getResultado());
    }

    @Test
    public void testRespuesta_AceptaElReto() {
        game.cadenaRespuestas("Acepta el reto");

        assertEquals("Aceptaste el desafío. ¿Subirás al puente del capitán?", game.getPregunta());
        assertArrayEquals(new String[]{"Sube al puente", "Negarse a subir al puente"}, game.getOpciones());
        assertEquals("", game.getResultado());
    }

    @Test
    public void testRespuesta_RechazaElDesafio() {

        game.cadenaRespuestas("Rechaza el desafío");

        assertEquals("Perdiste la memoria. ¿Aceptas el desafío OVNI?", game.getPregunta());
        assertArrayEquals(new String[]{"Acepta el reto", "Rechaza el desafío"}, game.getOpciones());
        assertEquals("Rechazaste el desafío. Derrota.", game.getResultado());
    }

    @Test
    public void testRespuesta_SubeAlPuente() {
        game.cadenaRespuestas("Acepta el reto");

        game.cadenaRespuestas("Sube al puente");

        assertEquals("Has subido al puente. ¿Quiénes sois?", game.getPregunta());
        assertArrayEquals(new String[]{"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"}, game.getOpciones());
        assertEquals("", game.getResultado());
    }

    @Test
    public void testRespuesta_NegarseASubirAlPuente() {
        game.cadenaRespuestas("Acepta el reto");

        game.cadenaRespuestas("Negarse a subir al puente");

        assertEquals("Aceptaste el desafío. ¿Subirás al puente del capitán?", game.getPregunta());
        assertArrayEquals(new String[]{"Sube al puente", "Negarse a subir al puente"}, game.getOpciones());
        assertEquals("No asististe a las negociaciones. Derrota.", game.getResultado());
    }

    @Test
    public void testRespuesta_DecirLaVerdad() {
        game.cadenaRespuestas("Acepta el reto");

        game.cadenaRespuestas("Sube al puente");

        game.cadenaRespuestas("Decir la verdad sobre tú mismo");

        assertEquals("Has subido al puente. ¿Quiénes sois?", game.getPregunta());
        assertArrayEquals(new String[]{"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"}, game.getOpciones());
        assertEquals("Has vuelto a casa. Victoria.", game.getResultado());
    }

    @Test
    public void testRespuesta_MienteSobreTiMismo() {
        game.cadenaRespuestas("Acepta el reto");

        game.cadenaRespuestas("Sube al puente");

        game.cadenaRespuestas("Miente sobre ti mismo");

        assertEquals("Has subido al puente. ¿Quiénes sois?", game.getPregunta());
        assertArrayEquals(new String[]{"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"}, game.getOpciones());
        assertEquals("Tu vida ha sido revelada. Derrota.", game.getResultado());
    }
}
