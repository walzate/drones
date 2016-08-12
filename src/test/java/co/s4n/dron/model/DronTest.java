/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.s4n.dron.model;

import co.s4n.dron.enums.OrientacionEnum;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase con las pruebas unitarias para el dron.
 *
 * @author Wilson Alzate Calderón
 */
public class DronTest {

    /**
     * Instancia del Logger para almacenar la bitácora
     */
    final static Logger LOGGER = Logger.getLogger(DronTest.class);

    /**
     * Constructor de la clase
     */
    public DronTest() {
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
     * Test of moverAdelante method, of class Dron.
     */
    @Test
    public void testMoverAdelante() {
        System.out.println("moverAdelante");
        Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
        Posicion posicionEsperada = new Posicion(0, 1, OrientacionEnum.NORTE);
        Dron dron = new Dron(posicion);
        dron.moverAdelante(posicion);
        assertEquals(posicion, posicionEsperada);
    }

    /**
     * Test of girarALaDerecha method, of class Dron.
     */
    @Test
    public void testGirarALaDerecha() {
        System.out.println("girarALaDerecha");
        Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
        Posicion posicionEsperada = new Posicion(0, 0, OrientacionEnum.ORIENTE);
        Dron dron = new Dron(posicion);
        dron.girarALaDerecha(posicion);
        assertEquals(posicion, posicionEsperada);
    }

    /**
     * Test of girarALaIzquierda method, of class Dron.
     */
    @Test
    public void testGirarALaIzquierda() {
        System.out.println("girarALaIzquierda");
        Posicion posicion = new Posicion(0, 0, OrientacionEnum.NORTE);
        Posicion posicionEsperada = new Posicion(0, 0, OrientacionEnum.OCCIDENTE);
        Dron dron = new Dron(posicion);
        dron.girarALaIzquierda(posicion);
        assertEquals(posicion, posicionEsperada);
    }

}
