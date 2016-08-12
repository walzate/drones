/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.s4n.dron.exception;

import co.s4n.dron.constants.ConstantesDron;

/**
 * Excepción para la validación del número de cuadras
 *
 * @author Wilson Alzate Calderón
 */
public class NumeroCuadrasALaRedondaException extends Exception {

    /**
     * Mensaje por defecto de excepción
     */
    public static final String MENSAJE = "Se han excedido el número de cuadras establecido para entrega: "
            + ConstantesDron.NUMERO_CUADRAS_A_LA_REDONDA;

    /**
     * Constructor que permite el cambio del mensaje
     *
     * @param message El nuevo mensaje
     */
    public NumeroCuadrasALaRedondaException(String message) {
        super(message);
    }

    /**
     * Constructor por defecto
     */
    public NumeroCuadrasALaRedondaException() {
        super(MENSAJE);
    }
}
