package co.s4n.dron;

import co.s4n.dron.enums.OrientacionEnum;

/**
 * Created by fawkes on 8/11/16.
 */
public class Main {
    public static void main (String args[]){
        Posicion posicion = new Posicion(0,0,OrientacionEnum.NORTE);
        Dron dron = new Dron(posicion);
        OperadorDron operadorDron = new OperadorDron(dron);
        operadorDron.leerYProcesarIndicaciones("in.txt","out.txt");        
    }
}
