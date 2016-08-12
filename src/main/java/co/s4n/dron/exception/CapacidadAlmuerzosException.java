/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.s4n.dron.exception;

import co.s4n.dron.constants.ConstantesDron;

/**
 * Excepción para la validación de la capacidad de almuerzos que el vehiculo puede cargar
 *
 * @author Wilson Alzate Calderón
 */
public class CapacidadAlmuerzosException extends Exception {

    /**
     * Mensaje por defecto de excepción
     */
    public static final String MENSAJE = "Se ha excedido la capacidad de almuerzos que el dron puede cargar: "
            + ConstantesDron.CAPACIDAD_ALMUERZOS;

    /**
     * Constructor que permite el cambio del mensaje
     *
     * @param message El nuevo mensaje
     */
    public CapacidadAlmuerzosException(String message) {
        super(message);
    }

    /**
     * Constructor por defecto
     */
    public CapacidadAlmuerzosException() {
        super(MENSAJE);
    }
}
