package co.s4n.dron.business;

import co.s4n.dron.constants.ConstantesDron;
import co.s4n.dron.enums.MovimientoEnum;
import co.s4n.dron.exception.CapacidadAlmuerzosException;
import co.s4n.dron.exception.MovimientoErroneoException;
import co.s4n.dron.exception.NumeroCuadrasALaRedondaException;
import co.s4n.dron.model.Vehiculo;
import co.s4n.dron.model.impl.Posicion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import org.apache.log4j.Logger;

/**
 * Clase encargada de operar el Vehiculo
 *
 * @author Wilson Alzate Calderón
 */
public class OperadorVehiculo extends Thread {

    /**
     * El vehiculo que el operador va a manejar
     */
    private Vehiculo vehiculo;
    /**
     * Instancia del Logger para almacenar la bitácora
     */
    private final static Logger LOGGER = Logger.getLogger(OperadorVehiculo.class);
    /**
     * Ruta del archivo con las indicaciones para el vehiculo
     */
    private String archivoIndicaciones;
    /**
     * Ruta donde con el reporte
     */
    private String archivoReporte;
    /**
     * Controlador para poder ejecutar todos los threads en simultánea
     */
    private CyclicBarrier gate;

    /**
     * Método constructor que permite la inyección de dependencias
     *
     * @param vehiculo El vehiculo que se va a operar
     */
    public OperadorVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    /**
     * Constructor con las rutas de los archivos
     *
     * @param vehiculo El vehiculo a operar
     * @param archivoIndicaciones Ruta del archivo con las indicaciones para el
     * vehiculo
     * @param archivoReporte Ruta donde con el reporte
     */
    public OperadorVehiculo(Vehiculo vehiculo, String archivoIndicaciones, String archivoReporte, CyclicBarrier gate) {
        this.vehiculo = vehiculo;
        this.archivoIndicaciones = archivoIndicaciones;
        this.archivoReporte = archivoReporte;
        this.gate = gate;
    }

    /**
     * Método que retorna el vehiculo que se va a operar
     *
     * @return el vehiculo que se va a operar
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método que modifica el vehiculo que se va a operar
     *
     * @param vehiculo el nuevo vehiculo que se va a operar
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método que dado un String con una serie de indicaciones opera el Vehiculo
     *
     * @param indicacion La cadena de caracteres con las indicaciones para
     * operar el vehiculo
     * @return un String con la posición final del vehiculo en el formato del
     * reporte
     * @throws java.lang.Exception si se supera el número de cuadras para
     * entrega
     */
    public String operar(String indicacion) throws Exception {
        String resultado = null;
        for (char ch : indicacion.toCharArray()) {

            MovimientoEnum movimiento = convertirAMovimientoEnum(ch);

            switch (movimiento) {
                case A:
                    vehiculo.moverAdelante(vehiculo.getPosicion());
                    break;
                case I:
                    vehiculo.girarALaIzquierda(vehiculo.getPosicion());
                    break;
                case D:
                    vehiculo.girarALaDerecha(vehiculo.getPosicion());
                    break;
                default:
                    break;
            }
            if (!validarPosicion(vehiculo.getPosicion())) {
                throw new NumeroCuadrasALaRedondaException();
            }
            resultado = vehiculo.getPosicion().toString();
            LOGGER.debug(resultado);
        }
        return resultado;
    }

    /**
     * Método utilizado para convertir un caracter a un movimiento enum. Se
     * valida si el caracter corresponde a los movimientos permitidos
     *
     * @param ch El caracter con el movimiento
     * @return Un objeto de tipo MovimientoEnum
     * @throws Exception Si no corresponde a los movimientos permitidos
     */
    private MovimientoEnum convertirAMovimientoEnum(char ch) throws Exception {
        MovimientoEnum movimiento;
        try {
            movimiento = MovimientoEnum.valueOf(String.valueOf(ch));
        } catch (Exception e) {
            throw new MovimientoErroneoException();
        }
        return movimiento;
    }

    /**
     * Método para cumplir con la restricción: Para la primera entrega del
     * proyecto, “Su corrientazo domicilio”, ha decidido que sólo entregará
     * domicilios a 10 cuadras a la redonda de su barrio, el cual puede ser
     * representado con un plano cartesiano.
     *
     * @param posicion La posición en la cual se encuentra el Dron
     * @return verdadero si se cumple que el dron se encuentre a 10 cuadras a la
     * redonda false en caso contrario
     */
    private boolean validarPosicion(Posicion posicion) {
        boolean resultado = true;
        if (posicion.getCoordenadaX() > ConstantesDron.NUMERO_CUADRAS_A_LA_REDONDA
                || posicion.getCoordenadaX() < -ConstantesDron.NUMERO_CUADRAS_A_LA_REDONDA) {
            resultado = false;
        } else if (posicion.getCoordenadaY() > ConstantesDron.NUMERO_CUADRAS_A_LA_REDONDA
                || posicion.getCoordenadaY() < -ConstantesDron.NUMERO_CUADRAS_A_LA_REDONDA) {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Método que lee un archivo de entrada con las indicaciones del vehiculo y
     * escribe las posiciones finales de cada entrega en el formato del reporte
     *
     * @param archivoIndicaciones la ruta del archivo de entrada
     * @param archivoReporte la ruta del archivo de salida
     * @return Un String con el contenido del reporte de salida
     * @throws java.lang.Exception
     */
    public synchronized String leerYProcesarIndicaciones(String archivoIndicaciones, String archivoReporte) throws Exception {
        //Inicialización de variables
        String resultado = "";
        BufferedReader reader = null;
        PrintWriter writer = null;
        String lineaDeInstrucciones;
        try {
            // Apertura del archivo de entrada
            reader = new BufferedReader(new FileReader(archivoIndicaciones));
            //Apertura del archivo de salida
            writer = new PrintWriter(archivoReporte, ConstantesDron.ENCODING_REPORTE);
            //Concatenación del encabezado del archivo de salida, esto para hacer
            //las pruebas del método en JUnit
            resultado = resultado + ConstantesDron.ENCABEZADO_REPORTE + ConstantesDron.SALTO_LINEA;
            //Se escribe en el archivo el encabezado del reporte
            writer.println(ConstantesDron.ENCABEZADO_REPORTE);

            int contadorAlmuerzos = 1;

            //Lectura línea a línea del archivo
            while ((lineaDeInstrucciones = reader.readLine()) != null) {
                //Es importante aclarar que el dron es sólo capaz de cargar hasta tres almuerzos por vez.
                if (contadorAlmuerzos > ConstantesDron.CAPACIDAD_ALMUERZOS) {
                    throw new CapacidadAlmuerzosException();
                }
                LOGGER.debug(lineaDeInstrucciones);
                //Se operan las instrucciones obtenidas en la linea
                String posicionFinal = operar(lineaDeInstrucciones);
                //Se concatena el resultado para posteriores pruebas
                resultado = resultado + posicionFinal + ConstantesDron.SALTO_LINEA;
                //Se escribe el resultado de la operación en el reporte
                writer.println(posicionFinal);

                contadorAlmuerzos++;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            //Cierre de los archivos de entrada y salida
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Método que sobreescribe la ejecución del thread
     */
    @Override
    public void run() {        
        try {
            //Permite que cada thread espere a los demás
            gate.await();
            //Monitoreo para revisar que todos los threads se ejecuten al tiempo
            LOGGER.debug(getName()+": "+(new Date()));
            //Ejecución de los procesos
            leerYProcesarIndicaciones(archivoIndicaciones, archivoReporte);
        } catch (Exception ex) {
            LOGGER.error(ex);
        }        
    }
}
