package co.s4n.dron.model;

import co.s4n.dron.enums.OrientacionEnum;

/**
 * Clase que almacena la posición del Dron, incluyendo coordenadas y orientación
 *
 * @author Wilson Alzate Calderón
 */
public class Posicion {

    /**
     * Coordenada en el eje X del dron
     */
    private int coordenadaX;
    /**
     * Coordenada en el eje Y del dron
     */
    private int coordenadaY;
    /**
     * Enumeración que contiene la orientación del dron (Norte, Sur, Oriente,
     * Occidente)
     */
    private OrientacionEnum orientacionEnum;

    /**
     * Constructor que permite la inyección de dependencias del Dron
     *
     * @param coordenadaX La coordenada X inicial
     * @param coordenadaY La coordenada Y inicial
     * @param orientacionEnum La orientación inicial
     */
    public Posicion(int coordenadaX, int coordenadaY, OrientacionEnum orientacionEnum) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.orientacionEnum = orientacionEnum;
    }

    /**
     * Método que retorna la coordenada X de la posición del dron
     *
     * @return la coordenada X de la posición del dron
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Método que modifica la coordenada X de la posición del dron
     *
     * @param coordenadaX la nueva coordenada X de la posición del dron
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * Método que retorna la coordenada Y de la posición del dron
     *
     * @return la coordenada Y de la posición del dron
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Método que modifica la coordenada Y de la posición del dron
     *
     * @param coordenadaY la nueva coordenada Y de la posición del dron
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * Método que retorna la orientación del dron
     *
     * @return la orientación del dron
     */
    public OrientacionEnum getOrientacionEnum() {
        return orientacionEnum;
    }

    /**
     * Método que modifica la orientación del dron
     *
     * @param orientacionEnum la nueva orientación del dron
     */
    public void setOrientacionEnum(OrientacionEnum orientacionEnum) {
        this.orientacionEnum = orientacionEnum;
    }

    /**
     * Método que retorna un String con la posición del Dron en el formato
     * requerido por el reporte.
     *
     * @return Retorna un String en formato: (${coordenadaX}, ${coordenadaY})
     * dirección ${orientación}
     */
    @Override
    public String toString() {
        String result = "(" + coordenadaX + ", " + coordenadaY + ") dirección " + orientacionEnum.toString();
        return result;
    }

    /**
     * Método que sobreescribe la comparación entre posiciones para ahora
     * comparar por el estado del objeto.
     *
     * @param obj El objeto con el cual se va a comparar
     * @return true si los objetos tienen el mismo estado, false en caso
     * contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posicion other = (Posicion) obj;
        if (this.coordenadaX != other.coordenadaX) {
            return false;
        }
        if (this.coordenadaY != other.coordenadaY) {
            return false;
        }
        if (this.orientacionEnum != other.orientacionEnum) {
            return false;
        }
        return true;
    }

}
