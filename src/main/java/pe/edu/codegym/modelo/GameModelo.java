package pe.edu.codegym.modelo;

public class GameModelo {
    private String pregunta;
    private String[] opciones;
    private String resultado;

    public GameModelo() {
        pregunta = "Perdiste la memoria. ¿Aceptas el desafío OVNI?";
        opciones = new String[]{"Acepta el reto", "Rechaza el desafío"};
        resultado = "";
    }

    public void cadenaRespuestas(String respuesta) {
        if (pregunta.equals("Perdiste la memoria. ¿Aceptas el desafío OVNI?")) {
            if (respuesta.equals("Acepta el reto")) {
                pregunta = "Aceptaste el desafío. ¿Subirás al puente del capitán?";
                opciones = new String[]{"Sube al puente", "Negarse a subir al puente"};
            } else if (respuesta.equals("Rechaza el desafío")) {
                this.resultado = "Rechazaste el desafío. Derrota.";
            }
        } else if (pregunta.equals("Aceptaste el desafío. ¿Subirás al puente del capitán?")) {
            if (respuesta.equals("Sube al puente")) {
                pregunta = "Has subido al puente. ¿Quiénes sois?";
                opciones = new String[]{"Decir la verdad sobre tú mismo", "Miente sobre ti mismo"};
            } else if (respuesta.equals("Negarse a subir al puente")) {
                this.resultado = "No asististe a las negociaciones. Derrota.";
            }
        } else if (pregunta.equals("Has subido al puente. ¿Quiénes sois?")) {
            if (respuesta.equals("Decir la verdad sobre tú mismo")) {
                this.resultado = "Has vuelto a casa. Victoria.";
            } else if (respuesta.equals("Miente sobre ti mismo")) {
                this.resultado = "Tu vida ha sido revelada. Derrota.";
            }
        }
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public String getResultado() {
        return resultado;
    }
}