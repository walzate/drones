/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.s4n.dron.constants;

/**
 * Clase con las constantes del sistema de drones
 *
 * @author Wilson Alzate Calderón
 */
public class ConstantesDron {

    /**
     * Encabezado del archivo de reporte
     */
    public static final String ENCABEZADO_REPORTE = "== Reporte de entregas ==";
    /**
     * Caractér con el salto de línea
     */
    public static final String SALTO_LINEA = "\n";
    /**
     * Encoding con el que se escribirá el archivo de salida
     */
    public static final String ENCODING_REPORTE = "UTF-8";
    /**
     * La ruta del archivo en que se encuentran las instrucciones del dron
     */
    public static final String RUTA_ARCHIVO_ENTRADA = "in.txt";
    /**
     * La ruta en donde se encuentra el archivo que funcionará como reporte de
     * salida
     */
    public static final String RUTA_ARCHIVO_SALIDA = "out.txt";
    /**
     * Máximo número de cuadras a la redonda en donde el dron entregará pedidos
     */
    public static final int NUMERO_CUADRAS_A_LA_REDONDA = 10;
    /**
     * Es importante aclarar que el dron es sólo capaz de cargar hasta tres
     * almuerzos por vez.
     */
    public static final int CAPACIDAD_ALMUERZOS = 3;

}
