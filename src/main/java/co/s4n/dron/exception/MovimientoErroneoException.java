package co.s4n.dron.exception;

import co.s4n.dron.constants.ConstantesDron;

/**
 * Excepción para la validación de los movimientos
 *
 * @author Wilson Alzate Calderón
 */
public class MovimientoErroneoException extends Exception {

    /**
     * Mensaje por defecto de excepción
     */
    public static final String MENSAJE = "El movimiento ingresado no corresponde a los permitidos";

    /**
     * Constructor que permite el cambio del mensaje
     *
     * @param message El nuevo mensaje
     */
    public MovimientoErroneoException(String message) {
        super(message);
    }

    /**
     * Constructor por defecto
     */
    public MovimientoErroneoException() {
        super(MENSAJE);
    }
}
