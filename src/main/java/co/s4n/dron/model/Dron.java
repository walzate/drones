package co.s4n.dron.model;

import co.s4n.dron.enums.OrientacionEnum;

/**
 * Clase que representa un Dron.
 *
 * @author Wilson Alzate Calderón
 */
public class Dron {

    /**
     * La posición en la cual se encuentra el Dron
     */
    private Posicion posicion;

    /**
     * Constructor de la clase para inyectar la dependencia de la posiciçón
     *
     * @param posicion La posición inicial del Dron
     */
    public Dron(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * Método que retorna el objeto que representa la posición del Dron
     *
     * @return el objeto Posicion
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Método que modifica el objeto que representa la posición del Dron
     *
     * @param posicion El nuevo objeto Posicion
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * Método que dada la posición del Dron mueve una posición hacia adelante
     *
     * @param posicion La posición inicial del Dron
     */
    public void moverAdelante(Posicion posicion) {
        switch (posicion.getOrientacionEnum()) {
            case NORTE:
                posicion.setCoordenadaY(posicion.getCoordenadaY() + 1);
                break;
            case ORIENTE:
                posicion.setCoordenadaX(posicion.getCoordenadaX() + 1);
                break;
            case OCCIDENTE:
                posicion.setCoordenadaX(posicion.getCoordenadaX() - 1);
                break;
            case SUR:
                posicion.setCoordenadaY(posicion.getCoordenadaY() - 1);
                break;
        }
    }

    /**
     * Método que dada la posición del Dron realiza un giro de 90 grados hacia
     * la derecha
     *
     * @param posicion La posición inicial del Dron
     */
    public void girarALaDerecha(Posicion posicion) {
        switch (posicion.getOrientacionEnum()) {
            case NORTE:
                posicion.setOrientacionEnum(OrientacionEnum.ORIENTE);
                break;
            case ORIENTE:
                posicion.setOrientacionEnum(OrientacionEnum.SUR);
                break;
            case OCCIDENTE:
                posicion.setOrientacionEnum(OrientacionEnum.NORTE);
                break;
            case SUR:
                posicion.setOrientacionEnum(OrientacionEnum.OCCIDENTE);
                break;
        }
    }

    /**
     * Método que dada la posición del Dron realiza un giro de 90 grados hacia
     * la izquierda
     *
     * @param posicion La posición inicial del Dron
     */
    public void girarALaIzquierda(Posicion posicion) {
        switch (posicion.getOrientacionEnum()) {
            case NORTE:
                posicion.setOrientacionEnum(OrientacionEnum.OCCIDENTE);
                break;
            case ORIENTE:
                posicion.setOrientacionEnum(OrientacionEnum.NORTE);
                break;
            case OCCIDENTE:
                posicion.setOrientacionEnum(OrientacionEnum.SUR);
                break;
            case SUR:
                posicion.setOrientacionEnum(OrientacionEnum.ORIENTE);
                break;
        }
    }

    /**
     * Método que sobreescribe la comparación entre drones para ahora comparar
     * por el estado del objeto.
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
        final Dron other = (Dron) obj;
        if (this.posicion != other.posicion && (this.posicion == null || !this.posicion.equals(other.posicion))) {
            return false;
        }
        return true;
    }

}
