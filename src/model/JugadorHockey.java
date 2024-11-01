package model;

public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo, IPasarPelota {
    protected String nombre;
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, int numero, Posicion posicion) {
        super(nombre, edad);
        this.posicion = posicion;
        this.numero = numero;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }

    public int getNumero() {
        return numero;
    }

    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    public String anotarGol() {
        return nombre + "entra el disco en la red. ¡Gol!";
    }

    @Override
    public String pasarPelota() {
        return  " pasa la pelota a ";
    }
}