package co.s4n.dron;

import co.s4n.dron.enums.OrientacionEnum;

/**
 * Created by fawkes on 8/11/16.
 */
public class Dron {
    private Posicion posicion;

    public Dron(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void moverAdelante(Posicion posicion){
        switch (posicion.getOrientacionEnum()){
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

    public void girarALaDerecha (Posicion posicion){
        switch (posicion.getOrientacionEnum()){
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

    public void girarALaIzquierda (Posicion posicion){
        switch (posicion.getOrientacionEnum()){
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
}
