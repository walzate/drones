package co.s4n.dron;

import co.s4n.dron.business.OperadorVehiculo;
import co.s4n.dron.constants.ConstantesDron;
import co.s4n.dron.model.impl.Posicion;
import co.s4n.dron.model.impl.Dron;
import co.s4n.dron.enums.OrientacionEnum;
import co.s4n.dron.model.Vehiculo;
import org.apache.log4j.Logger;

/**
 * Clase que actúa como punto de entrada a la aplicación.
 *
 * @author Wilson Alzate Calderón
 */
public class Main {

    /**
     * Instancia del Logger para almacenar la bitácora
     */
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    /**
     * Método principal que actúa como punto de entrada a la aplicación
     *
     * @param args Argumentos enviados por consola
     */
    public static void main(String args[]) {
        try {
            //Se establece la posición inicial que es (0,0,N)
            Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
            //Se crea el dron que se va a operar
            Vehiculo dron = new Dron(posicion);
            //Se crea un objeto de la clase encargada de operar el dron
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            //Llamada al método que lee las instrucciones, las procesa y 
            //escribe el reporte en el archivo de salida
            operadorDron.leerYProcesarIndicaciones(ConstantesDron.RUTA_ARCHIVO_ENTRADA,
                    ConstantesDron.RUTA_ARCHIVO_SALIDA);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }
}
