package co.s4n.dron;

import co.s4n.dron.business.OperadorVehiculo;
import co.s4n.dron.constants.ConstantesDron;
import co.s4n.dron.model.impl.Posicion;
import co.s4n.dron.model.impl.Dron;
import co.s4n.dron.enums.OrientacionEnum;
import co.s4n.dron.model.Vehiculo;
import co.s4n.dron.util.DronesUtil;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
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
            /**
             * Solución para poder ejecutar todos los threads al mismo tiempo
             *
             * @author Enno Shioji
             * @see
             * http://stackoverflow.com/questions/3376586/how-to-start-two-threads-at-exactly-the-same-time
             */
            final CyclicBarrier gate = new CyclicBarrier(ConstantesDron.NUMERO_DE_DRONES + 1);

            for (int i = 1; i <= ConstantesDron.NUMERO_DE_DRONES; i++) {
                //Se establece la posición inicial que es (0,0,N)
                Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
                //Se crea el dron que se va a operar
                Vehiculo dron = new Dron(posicion);
                //Calculando los nombres de los archivos de entrada y salida
                String archivoEntrada = DronesUtil.getInstance().obtenerRutaArchivo(true, i);
                String archivoSalida = DronesUtil.getInstance().obtenerRutaArchivo(false, i);
                //Se crea un objeto de la clase encargada de operar el dron
                OperadorVehiculo operadorDron = new OperadorVehiculo(dron, archivoEntrada, archivoSalida, gate);
                //Llamada al método que lee las instrucciones, las procesa y 
                //escribe el reporte en el archivo de salida
                operadorDron.start();
            }
            //Se ejecutan todos los threads al mismo tiempo
            gate.await();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        } catch (BrokenBarrierException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        }

    }
}
