package co.s4n.dron.util;

import co.s4n.dron.constants.ConstantesDron;
import java.io.File;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase de utilidades
 *
 * @author Wilson Alzate Calderón
 */
public class DronesUtilTest {

    /**
     * Instancia del Logger para almacenar la bitácora
     */
    final static Logger LOGGER = Logger.getLogger(DronesUtilTest.class);

    /**
     * Constructor de la clase
     */
    public DronesUtilTest() {
    }

    /**
     * Método para establecimiento inicial de variables a nivel de clase
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Método para cerrado de variables al finalizar la ejecución
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Método para establecimiento inicial de variables a nivel de caso de
     * prueba
     */
    @Before
    public void setUp() {
    }

    /**
     * Método para cerrado de variables a nivel de caso de prueba
     */
    @After
    public void tearDown() {
    }

    /**
     * Prueba para obtener el nombre del archivo de salida para el dron número 1
     */
    @Test
    public void testObtenerNombreArchivoSalida() {
        System.out.println("testObtenerNombreArchivoSalida");
        boolean entrada = false;
        int numeroDron = 1;
        DronesUtil instance = DronesUtil.getInstance();
        String expResult = "out01.txt";
        String result = instance.obtenerNombreArchivo(entrada, numeroDron);
        assertEquals(expResult, result);
    }

    /**
     * Prueba para obtener el nombre del archivo de entrada para el dron número 1
     */
    @Test
    public void testObtenerNombreArchivoEntrada() {
        System.out.println("testObtenerNombreArchivoEntrada");
        boolean entrada = true;
        int numeroDron = 1;
        DronesUtil instance = DronesUtil.getInstance();
        String expResult = "in01.txt";
        String result = instance.obtenerNombreArchivo(entrada, numeroDron);
        assertEquals(expResult, result);
    }

    /**
     * Prueba para obtener la ruta del archivo de salida para el dron número 1
     */
    @Test
    public void testObtenerRutaArchivoSalida() {
        System.out.println("testObtenerRutaArchivoSalida");
        boolean entrada = false;
        int numeroDron = 1;
        DronesUtil instance = DronesUtil.getInstance();
        String expResult = ConstantesDron.RUTA_DIRECTORIO_ARCHIVOS + File.separator + "out01.txt";
        String result = instance.obtenerRutaArchivo(entrada, numeroDron);
        assertEquals(expResult, result);
    }

    /**
     * Prueba para obtener la ruta del archivo de entrada para el dron número 1
     */
    @Test
    public void testObtenerRutaArchivoEntrada() {
        System.out.println("testObtenerRutaArchivoEntrada");
        boolean entrada = true;
        int numeroDron = 1;
        DronesUtil instance = DronesUtil.getInstance();
        String expResult = ConstantesDron.RUTA_DIRECTORIO_ARCHIVOS + File.separator + "in01.txt";
        String result = instance.obtenerRutaArchivo(entrada, numeroDron);
        assertEquals(expResult, result);
    }

}
