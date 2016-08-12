package co.s4n.dron;

import co.s4n.dron.business.OperadorVehiculo;
import co.s4n.dron.model.impl.Posicion;
import co.s4n.dron.model.impl.Dron;
import co.s4n.dron.enums.OrientacionEnum;
import co.s4n.dron.exception.NumeroCuadrasALaRedondaException;
import co.s4n.dron.model.Vehiculo;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase con las pruebas unitarias para el programa.
 *
 * @author Wilson Alzate Calderón
 */
public class OperadorVehiculoTest {

    /**
     * Instancia del Logger para almacenar la bitácora
     */
    final static Logger LOGGER = Logger.getLogger(OperadorVehiculoTest.class);

    /**
     * Constructor de la clase
     */
    public OperadorVehiculoTest() {
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
     * Prueba para el primer domicilio a realizar por el dron, se tienen como
     * partida las instrucciones AAAAIAAD arrancando en la posición (0,0,N) y
     * terminando en (-2, 4) dirección Norte
     */
    @Test
    public void operarPrimerDomicilio() {
        LOGGER.info("operarPrimerDomicilio");
        try {
            Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.operar("AAAAIAAD");
            assertEquals(resultado, "(-2, 4) dirección Norte");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Prueba para el segundo domicilio a realizar por el dron arrancando desde
     * la posición (-2, 4) dirección Norte,es un caso fallido porque no el
     * resultado del segundo domicilio no es (-3, 3) dirección Sur como lo dice
     * el enunciado sino (-1, 3) dirección Sur al seguir las instrucciones
     * DDAIAD propuestas en el enunciado.
     */
    @Test
    public void operarSegundoDomicilioEnunciadoErroneo() {
        LOGGER.info("operarSegundoDomicilioEnunciadoErroneo");
        try {
            Posicion posicion = new Posicion(-2, 4, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.operar("DDAIAD");
            assertEquals(resultado, "(-3, 3) dirección Sur");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Prueba para el segundo domicilio teniendo en cuenta lo que considero es
     * la respuesta correcta arrancando desde la posición (-2, 4) dirección
     * Norte y aplicando las indicaciones DDAIAD para obtener (-1, 3) dirección
     * Sur
     */
    @Test
    public void operarSegundoDomicilio() {
        LOGGER.info("operarSegundoDomicilio");
        try {
            Posicion posicion = new Posicion(-2, 4, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.operar("DDAIAD");
            assertEquals(resultado, "(-1, 3) dirección Sur");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Prueba para el tercer domicilio teniendo como punto de partida (-3, 3)
     * dirección Sur y llegando a (-4, 2) dirección Oriente siguiendo las
     * indicaciones AAIADAD. Esta prueba unitaria falla porque considero que el
     * enunciado está incorrecto y el resultado debería ser (-2, 0) dirección
     * Occidente.
     */
    @Test
    public void operarTercerDomicilioEnunciadoErroneo() {
        LOGGER.info("operarTercerDomicilioEnunciadoErroneo");
        try {
            Posicion posicion = new Posicion(-3, 3, OrientacionEnum.SUR);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.operar("AAIADAD");
            assertEquals(resultado, "(-4, 2) dirección Oriente");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Prueba para el tercer domicilio con la respuesta que considero es la
     * correcta. Se arranca desde (-3, 3) dirección Sur y al seguir las
     * instrucciones AAIADAD se llega a (-2, 0) dirección Occidente.
     */
    @Test
    public void operarTercerDomicilio() {
        LOGGER.info("operarTercerDomicilio");
        try {
            Posicion posicion = new Posicion(-3, 3, OrientacionEnum.SUR);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.operar("AAIADAD");
            assertEquals(resultado, "(-2, 0) dirección Occidente");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Prueba completa de las tres entregas, se lee del archivo inTest.txt y se
     * escribe en el archivo outTest.txt. En este caso se evalúa la concordancia
     * con las entradas y salidas propuestas por el enunciado. Dado que en el
     * caso 2 y 3 se considera que son erradas por eso la prueba falla.
     */
    @Test
    public void testLeerYProcesarIndicacionesEnunciadoErroneo() {
        LOGGER.info("operarTercerDomicilio");
        try {
            Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.leerYProcesarIndicaciones("inTest.txt", "outTest.txt");
            String esperado = "== Reporte de entregas ==\n"
                    + "(-2, 4) dirección Norte\n"
                    + "(-3, 3) dirección Sur\n"
                    + "(-4, 2) dirección Oriente\n";
            assertEquals(resultado, esperado);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Prueba completa con las tres entregas del dron, se lee de archivo
     * inTest.txt y se escribe en el archivo outTest.txt. En este caso se toman
     * las salidas que se consideran correctas en contraposición de lo que el
     * enunciado establece.
     */
    @Test
    public void testLeerYProcesarIndicaciones() {
        LOGGER.info("operarTercerDomicilio");
        try {
            Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            String resultado = operadorDron.leerYProcesarIndicaciones("inTest.txt", "outTest.txt");
            String esperado = "== Reporte de entregas ==\n"
                    + "(-2, 4) dirección Norte\n"
                    + "(-1, 3) dirección Sur\n"
                    + "(0, 0) dirección Occidente\n";
            assertEquals(resultado, esperado);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Prueba unitaria que valida si se está sobrepasando el número de cuadras a
     * la redonda en donde se van a realizar entregas
     */
    @Test
    public void testNumeroDeCuadrasALaRedondaExcedidoNorte() {
        LOGGER.info("testNumeroDeCuadrasALaRedondaExcedido");
        try {
            Posicion posicion = new Posicion(0, 9, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            operadorDron.operar("AAAA");
        } catch (Exception e) {
            assertTrue(e instanceof NumeroCuadrasALaRedondaException);
        }
    }

    /**
     * Prueba unitaria que valida si se está sobrepasando el número de cuadras a
     * la redonda en donde se van a realizar entregas Para la primera entrega
     * del proyecto, “Su corrientazo domicilio”, ha decidido que sólo entregará
     * domicilios a 10 cuadras a la redonda de su barrio, el cual puede ser
     * representado con un plano cartesiano.
     */
    @Test
    public void testNumeroDeCuadrasALaRedondaExcedidoSur() {
        LOGGER.info("testNumeroDeCuadrasALaRedondaExcedido");
        try {
            Posicion posicion = new Posicion(0, 2, OrientacionEnum.NORTE);
            Vehiculo dron = new Dron(posicion);
            OperadorVehiculo operadorDron = new OperadorVehiculo(dron);
            operadorDron.operar("DDAAAAAAAAAAAAAAAAAA");
        } catch (Exception e) {
            assertTrue(e instanceof NumeroCuadrasALaRedondaException);
        }
    }

}
