package co.s4n.dron.business;

import co.s4n.dron.constants.ConstantesDron;
import co.s4n.dron.model.Dron;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 * Clase encargada de operar el Dron
 *
 * @author Wilson Alzate Calderón
 */
public class OperadorDron {

    /**
     * El dron que el operador va a manejar
     */
    private Dron dron;
    /**
     * Instancia del Logger para almacenar la bitácora
     */
    private final static Logger LOGGER = Logger.getLogger(OperadorDron.class);

    /**
     * Método constructor que permite la inyección de dependencias
     *
     * @param dron El dron que se va a operar
     */
    public OperadorDron(Dron dron) {
        this.dron = dron;
    }

    /**
     * Método que retorna el dron que se va a operar
     *
     * @return el dron que se va a operar
     */
    public Dron getDron() {
        return dron;
    }

    /**
     * Método que modifica el dron que se va a operar
     *
     * @param dron el nuevo dron que se va a operar
     */
    public void setDron(Dron dron) {
        this.dron = dron;
    }

    /**
     * Método que dado un String con una serie de indicaciones opera el Dron
     *
     * @param indicacion La cadena de caracteres con las indicaciones para
     * operar el dron
     * @return un String con la posición final del dron en el formato del
     * reporte
     */
    public String operar(String indicacion) {
        String resultado = null;
        for (char ch : indicacion.toCharArray()) {
            switch (ch) {
                case 'A':
                    dron.moverAdelante(dron.getPosicion());
                    break;
                case 'I':
                    dron.girarALaIzquierda(dron.getPosicion());
                    break;
                case 'D':
                    dron.girarALaDerecha(dron.getPosicion());
                    break;
                default:
                    break;
            }
            resultado = dron.getPosicion().toString();
            LOGGER.debug(resultado);
        }
        return resultado;
    }

    /**
     * Método que lee un archivo de entrada con las indicaciones del dron y
     * escribe las posiciones finales de cada entrega en el formato del reporte
     *
     * @param archivoIndicaciones la ruta del archivo de entrada
     * @param archivoReporte la ruta del archivo de salida
     * @return Un String con el contenido del reporte de salida
     */
    public String leerYProcesarIndicaciones(String archivoIndicaciones, String archivoReporte) {
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

            //Lectura línea a línea del archivo
            while ((lineaDeInstrucciones = reader.readLine()) != null) {
                LOGGER.debug(lineaDeInstrucciones);
                //Se operan las instrucciones obtenidas en la linea
                String posicionFinal = operar(lineaDeInstrucciones);
                //Se concatena el resultado para posteriores pruebas
                resultado = resultado + posicionFinal + ConstantesDron.SALTO_LINEA;
                //Se escribe el resultado de la operación en el reporte
                writer.println(posicionFinal);
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
