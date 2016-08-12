package co.s4n.dron.model;

import co.s4n.dron.model.impl.Posicion;

/**
 * Interfaz que define el contrato para cualquier vehiculo
 *
 * @author Wilson Alzate Calderón
 */
public interface Vehiculo {

    /**
     * Método que retorna el objeto que representa la posición del Vehiculo
     *
     * @return el objeto Posicion
     */
    public Posicion getPosicion();

    /**
     * Método que modifica el objeto que representa la posición del Vehiculo
     *
     * @param posicion El nuevo objeto Posicion
     */
    public void setPosicion(Posicion posicion);
    
    /**
     * Método que dada la posición del vehiculo mueve una posición hacia
     * adelante
     *
     * @param posicion La posición inicial del vehiculo
     */
    public void moverAdelante(Posicion posicion);

    /**
     * Método que dada la posición del vehiculo realiza un giro de 90 grados
     * hacia la derecha
     *
     * @param posicion La posición inicial del vehiculo
     */
    public void girarALaDerecha(Posicion posicion);

    /**
     * Método que dada la posición del vehiculo realiza un giro de 90 grados
     * hacia la izquierda
     *
     * @param posicion La posición inicial del vehiculo
     */
    public void girarALaIzquierda(Posicion posicion);
}
