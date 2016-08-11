package co.s4n.dron;

import co.s4n.dron.enums.OrientacionEnum;

/**
 * Created by fawkes on 8/11/16.
 */
public class Posicion {
    private int coordenadaX;
    private int coordenadaY;
    private OrientacionEnum orientacionEnum;


    public Posicion(int coordenadaX, int coordenadaY, OrientacionEnum orientacionEnum) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.orientacionEnum = orientacionEnum;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public OrientacionEnum getOrientacionEnum() {
        return orientacionEnum;
    }

    public void setOrientacionEnum(OrientacionEnum orientacionEnum) {
        this.orientacionEnum = orientacionEnum;
    }

    @Override
    public String toString() {
        String result = "("+coordenadaX+", "+coordenadaY+") dirección "+orientacionEnum.toString();
        return result;
    }
}
