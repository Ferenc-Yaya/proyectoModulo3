package pe.edu.codegym.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameModeloTest {

    private GameModelo game;

    @BeforeEach
    public void inicializar() {
        game = new GameModelo();
    }

    @Test
    public void testInicializacion() {
        //Acomodar
        String pregunta="Perdiste la memoria. ¿Aceptas el desafío OVNI?";
        String[] opciones= {"Acepta el reto", "Rechaza el desafío"};
        String resultadoOpcion ="";
        //Actuar
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //Asegurar
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }

    @Test
    public void testRespuestaAceptaElReto() {
        //A
        String pregunta="Aceptaste el desafío. ¿Subirás al puente del capitán?";
        String[] opciones= {"Sube al puente", "Negarse a subir al puente"};
        String resultadoOpcion ="";
        //A
        game.cadenaRespuestas("Acepta el reto");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }

    @Test
    public void testRespuestaRechazaElDesafio() {
        //A
        String pregunta="Perdiste la memoria. ¿Aceptas el desafío OVNI?";
        String[] opciones= {"Acepta el reto", "Rechaza el desafío"};
        String resultadoOpcion ="Rechazaste el desafío. Derrota.";
        //A
        game.cadenaRespuestas("Rechaza el desafío");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }

    @Test
    public void testRespuestaSubeAlPuente() {
        //A
        String pregunta="Has subido al puente. ¿Quiénes sois?";
        String[] opciones= {"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"};
        String resultadoOpcion ="";
        //A
        game.cadenaRespuestas("Acepta el reto");
        game.cadenaRespuestas("Sube al puente");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta,resultado);
        assertArrayEquals(opciones,resultadoOpciones);
        assertEquals(resultadoOpcion,resultadoO);
    }

    @Test
    public void testRespuestaNegarseASubirAlPuente() {
        //A
        String pregunta="Aceptaste el desafío. ¿Subirás al puente del capitán?";
        String[] opciones= {"Sube al puente", "Negarse a subir al puente"};
        String resultadoOpcion ="No asististe a las negociaciones. Derrota.";
        //A
        game.cadenaRespuestas("Acepta el reto");
        game.cadenaRespuestas("Negarse a subir al puente");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }

    @Test
    public void testRespuestaDecirLaVerdad() {
        //A
        String pregunta="Has subido al puente. ¿Quiénes sois?";
        String[] opciones= {"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"};
        String resultadoOpcion ="Has vuelto a casa. Victoria.";
        //A
        game.cadenaRespuestas("Acepta el reto");
        game.cadenaRespuestas("Sube al puente");
        game.cadenaRespuestas("Decir la verdad sobre tú mismo");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }

    @Test
    public void testRespuestaMienteSobreTiMismo() {
        //A
        String pregunta="Has subido al puente. ¿Quiénes sois?";
        String[] opciones= {"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"};
        String resultadoOpcion ="Tu vida ha sido revelada. Derrota.";
        //A
        game.cadenaRespuestas("Acepta el reto");
        game.cadenaRespuestas("Sube al puente");
        game.cadenaRespuestas("Miente sobre ti mismo");
        String resultado=game.getPregunta();
        String[] resultadoOpciones=game.getOpciones();
        String resultadoO=game.getResultado();
        //A
        assertEquals(pregunta, resultado);
        assertArrayEquals(opciones, resultadoOpciones);
        assertEquals(resultadoOpcion, resultadoO);
    }
}
