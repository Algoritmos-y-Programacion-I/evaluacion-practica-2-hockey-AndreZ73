package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        jugadores = new JugadorHockey[CANTIDAD_JUGADORES];
    }

    public void agregarJugador(JugadorHockey jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if(jugadores[i]==null) {
                jugadores[i] = jugador;
                break;
            }
        }
    }

    public JugadorHockey getJugador(int index) {
        return jugadores[index];
    }

    public String obtenerNombreJugador(int numero) {
        for(int i = 0; i < jugadores.length; i++) {
            if(jugadores[i].getNumero()==numero) {
                return jugadores[i].getNombre();
            }
        }
        return "";
    }
}