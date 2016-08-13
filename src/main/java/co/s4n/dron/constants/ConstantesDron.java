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
    
    public static final String RUTA_DIRECTORIO_ARCHIVOS = "files";
    /**
     * Máximo número de cuadras a la redonda en donde el dron entregará pedidos
     */
    public static final int NUMERO_CUADRAS_A_LA_REDONDA = 10;
    /**
     * Es importante aclarar que el dron es sólo capaz de cargar hasta tres
     * almuerzos por vez.
     */
    public static final int CAPACIDAD_ALMUERZOS = 10;
    /**
     * Con las utilidades que le está dejando su negocio, “Su corrientazo a
     * domicilio” desea aumentar la capacidad de entregas diarias. Por esta
     * razón, ha solicitado a S4N que ahora el sistema sea capaz de operar 20
     * drones diferentes
     */
    public static final int NUMERO_DE_DRONES = 20;

}
