package co.s4n.dron.business;

import co.s4n.dron.constants.ConstantesDron;
import co.s4n.dron.exception.CapacidadAlmuerzosException;
import co.s4n.dron.exception.NumeroCuadrasALaRedondaException;
import co.s4n.dron.model.Vehiculo;
import co.s4n.dron.model.impl.Posicion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 * Clase encargada de operar el Vehiculo
 *
 * @author Wilson Alzate Calderón
 */
public class OperadorVehiculo {

    /**
     * El vehiculo que el operador va a manejar
     */
    private Vehiculo vehiculo;
    /**
     * Instancia del Logger para almacenar la bitácora
     */
    private final static Logger LOGGER = Logger.getLogger(OperadorVehiculo.class);

    /**
     * Método constructor que permite la inyección de dependencias
     *
     * @param vehiculo El vehiculo que se va a operar
     */
    public OperadorVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
            switch (ch) {
                case 'A':
                    vehiculo.moverAdelante(vehiculo.getPosicion());
                    break;
                case 'I':
                    vehiculo.girarALaIzquierda(vehiculo.getPosicion());
                    break;
                case 'D':
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
     */
    public String leerYProcesarIndicaciones(String archivoIndicaciones, String archivoReporte) throws Exception {
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

            int contadorAlmuerzos = 0;
            
            //Lectura línea a línea del archivo
            while ((lineaDeInstrucciones = reader.readLine()) != null) {
                //Es importante aclarar que el dron es sólo capaz de cargar hasta tres almuerzos por vez.
                if (contadorAlmuerzos > ConstantesDron.CAPACIDAD_ALMUERZOS){
                    throw new CapacidadAlmuerzosException();
                }
                LOGGER.debug(lineaDeInstrucciones);
                //Se operan las instrucciones obtenidas en la linea
                String posicionFinal = operar(lineaDeInstrucciones);
                //Se concatena el resultado para posteriores pruebas
                resultado = resultado + posicionFinal + ConstantesDron.SALTO_LINEA;
                //Se escribe el resultado de la operación en el reporte
                writer.println(posicionFinal);
                
                contadorAlmuerzos ++;
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
}