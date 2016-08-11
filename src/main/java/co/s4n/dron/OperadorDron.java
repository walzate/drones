package co.s4n.dron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 * Created by fawkes on 8/11/16.
 */
public class OperadorDron {

    private Dron dron;
    private final static Logger LOGGER = Logger.getLogger(OperadorDron.class);
    private final String ENCABEZADO_REPORTE = "== Reporte de entregas ==";
    private final String SALTO_LINEA = "\n";
    private final String ENCODING_REPORTE = "UTF-8";

    public OperadorDron(Dron dron) {
        this.dron = dron;
    }

    public Dron getDron() {
        return dron;
    }

    public void setDron(Dron dron) {
        this.dron = dron;
    }

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
            LOGGER.info(resultado);
        }
        return resultado;
    }

    public String leerYProcesarIndicaciones(String archivoIndicaciones,String archivoReporte) {
        String resultado = "";
        BufferedReader br = null;
        try {
            PrintWriter writer = new PrintWriter(archivoReporte, ENCODING_REPORTE);
            resultado = resultado + ENCABEZADO_REPORTE+SALTO_LINEA;
            writer.println(ENCABEZADO_REPORTE);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(archivoIndicaciones));

            while ((sCurrentLine = br.readLine()) != null) {
                LOGGER.info(sCurrentLine);
                String posicionFinal = operar(sCurrentLine);
                resultado = resultado + posicionFinal + SALTO_LINEA;
                writer.println(posicionFinal);
            }

            writer.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
        return resultado;
    }
}
