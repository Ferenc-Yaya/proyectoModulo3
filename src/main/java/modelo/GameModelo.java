package modelo;

public class GameModelo {
    private String pregunta;
    private String[] respuestas;
    private String resultado;

    public GameModelo() {
        pregunta = "Perdiste la memoria. ¿Aceptas el desafío OVNI?";
        respuestas = new String[]{"Acepta el reto", "Rechaza el desafío"};
        resultado = "";
    }

    public void cadenaRespuestas(String respuesta) {
        if (pregunta.equals("Perdiste la memoria. ¿Aceptas el desafío OVNI?")) {
            if (respuesta.equals("Acepta el reto")) {
                pregunta = "Aceptaste el desafío. ¿Subirás al puente del capitán?";
                respuestas = new String[]{"Sube al puente", "Negarse a subir al puente"};
            } else if (respuesta.equals("Rechaza el desafío")) {
                resultado = "Rechazaste el desafío. Derrota.";
            }
        } else if (pregunta.equals("Aceptaste el desafío. ¿Subirás al puente del capitán?")) {
            if (respuesta.equals("Sube al puente")) {
                pregunta = "Has subido al puente. ¿Quiénes sois?";
                respuestas = new String[]{"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"};
            } else if (respuesta.equals("Negarse a subir al puente")) {
                resultado = "No asististe a las negociaciones. Derrota.";
            }
        } else if (pregunta.equals("Has subido al puente. ¿Quiénes sois?")) {
            if (respuesta.equals("Decir la verdad sobre tú mismo")) {
                resultado = "Has vuelto a casa. Victoria.";
            } else if (respuesta.equals("Miente sobre ti mismo")) {
                resultado = "Tu vida ha sido revelada. Derrota.";
            }
        }
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRepuestas() {
        return respuestas;
    }

    public String getResultado() {
        return resultado;
    }
}