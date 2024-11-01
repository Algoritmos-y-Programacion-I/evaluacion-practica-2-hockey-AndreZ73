package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public Equipo crearEquipoYGuardarEnArreglo(String name) {
        Equipo equipo = new Equipo(name);

        equipos[0]=equipo;

        return equipo;
    }

    public JugadorHockey crearJugador(String nombre, int edad, int numero, Posicion posicion) {
        JugadorHockey jugador = new JugadorHockey(nombre, edad, numero, posicion);
        return jugador;
    }

    public ArbitroPrincipal crearArbitro(String nombre, int edad) {
        ArbitroPrincipal arbitro = new ArbitroPrincipal(nombre, edad);
        return arbitro;
    }

    public JuezDeLinea crearJuez(String nombre, int edad) {
        JuezDeLinea juez = new JuezDeLinea(nombre, edad);
        return juez;
    }

    public String precargarInformacion() {
        Equipo team1 = null;
       
        team1 = crearEquipoYGuardarEnArreglo("Colombia");

        team1.agregarJugador(crearJugador("Player1", 21, 1, Posicion.PORTERO));
        team1.agregarJugador(crearJugador("Player2", 21, 2, Posicion.DEFENSA));
        team1.agregarJugador(crearJugador("Player3", 21, 3, Posicion.DEFENSA));
        team1.agregarJugador(crearJugador("Player4", 21, 4, Posicion.ALA));
        team1.agregarJugador(crearJugador("Player5", 21, 5, Posicion.ALA));
        team1.agregarJugador(crearJugador("Player6", 21, 6, Posicion.CENTRO));

        arbitros[0]=crearArbitro("Arbitro1",21);
        arbitros[1]=crearArbitro("Arbitro2",21);

        arbitros[2]=crearJuez("JuezDeLinea1",21);
        arbitros[3]=crearJuez("JuezDeLinea2",21);

        return "Informacion precargada exitosamente!";

    }

    public String realizarPartido() {
        JugadorHockey[] jugadores = new JugadorHockey[6];

        for(int i = 0; i < jugadores.length; i++) {
            jugadores[i] = equipos[0].getJugador(i);
        }
        
        JugadorHockey jugador1 = jugadores[0];
        JugadorHockey jugador2 = jugadores[1];
        JugadorHockey jugador3 = jugadores[2];
        JugadorHockey jugador4 = jugadores[3];
        JugadorHockey jugador5 = jugadores[4];
        JugadorHockey jugador6 = jugadores[5];

        Arbitro arbitro1 = arbitros[0];
        Arbitro arbitro2 = arbitros[1];
        Arbitro arbitro3 = arbitros[2];
        Arbitro arbitro4 = arbitros[3];

        return jugador1.getNombre() + jugador1.pasarPelota() + jugador2.getNombre() +"\n" +
        arbitro1.desplazarse() +"\n" +
        jugador2.getNombre() + jugador2.pasarPelota() + jugador3.getNombre() +"\n" +
        arbitro2.desplazarse() +"\n" +
        jugador3.getNombre() + jugador3.pasarPelota() + jugador4.getNombre() +"\n" +
        arbitro3.desplazarse() +"\n" +
        jugador4.getNombre() + jugador4.pasarPelota() + jugador5.getNombre() +"\n" +
        arbitro4.desplazarse() +"\n" +
        jugador5.getNombre() + jugador5.pasarPelota() + jugador6.getNombre() +"\n" +
        arbitro1.desplazarse() + "\n" +
        jugador6.anotarGol();
    }
}