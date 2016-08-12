package co.s4n.dron.enums;

import org.apache.commons.lang.WordUtils;

/**
 * Enumeración que contiene la orientación del dron (Norte, Sur, Oriente,
 * Occidente)
 *
 * @author Wilson Alzate Calderón
 */
public enum OrientacionEnum {
    NORTE, SUR, ORIENTE, OCCIDENTE;

    /**
     * Método que retorna el valor de enumeración con la primera letra en
     * mayúscula y el resto en minúscula
     *
     * @return El valor de la orientación en el formato del reporte
     */
    @Override
    public String toString() {
        String enumeracionEnMinusculas = super.toString().toLowerCase();
        String enumeracionFormateada = WordUtils.capitalize(enumeracionEnMinusculas);
        return enumeracionFormateada;
    }
}
