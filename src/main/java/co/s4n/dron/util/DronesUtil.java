/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.s4n.dron.util;

import co.s4n.dron.constants.ConstantesDron;
import java.io.File;

/**
 * Clase con utilidades generales
 *
 * @author Wilson Alzate Calderón
 */
public class DronesUtil {

    /**
     * Instancia de la clase
     */
    private static DronesUtil instance = null;

    /**
     * Constructor por defecto cerrado
     */
    protected DronesUtil() {
    }

    /**
     * Implemantación del patron singleton
     *
     * @return La instancia de la clase
     */
    public static DronesUtil getInstance() {
        if (instance == null) {
            instance = new DronesUtil();
        }
        return instance;
    }

    /**
     * Método que retorna el nombre del archivo formateado tanto de entrada como
     * de salida
     *
     * @param entrada si es un archivo de entrada o de salida
     * @param numeroDron el número del dron que se está operando
     * @return El nombre del archivo en formato {in o out}{numero del dron}.txt
     */
    public String obtenerNombreArchivo(boolean entrada, int numeroDron) {
        String nombreArchivo;
        String nombreInicial;
        //Formato del número a dos dígitos
        String numeroFormateado = String.format("%02d", numeroDron);
        if (entrada) {
            nombreInicial = ConstantesDron.RUTA_ARCHIVO_ENTRADA;

        } else {
            nombreInicial = ConstantesDron.RUTA_ARCHIVO_SALIDA;
        }
        //Se toma el nombre hasta la extensión
        String nombre = nombreInicial.substring(0, nombreInicial.indexOf("."));
        // se toma la extension del archivo
        String extension = nombreInicial.substring(nombreInicial.indexOf("."), nombreInicial.length());
        //Se crea el nuevo nombre concatenando el número del dron
        nombreArchivo = nombre + numeroFormateado + extension;
        return nombreArchivo;
    }

    /**
     * Método que retorna la ruta del archivo sea de entrada o de salida
     *
     * @param entrada si es un archivo de entrada o de salida
     * @param numeroDron el número del dron que se está operando
     * @return La ruta dle archivo en formato {directorio}{in o out}{numero del
     * dron}.txt
     */
    public String obtenerRutaArchivo(boolean entrada, int numeroDron) {
        String nombreArchivo = obtenerNombreArchivo(entrada, numeroDron);
        String rutaArchivo = ConstantesDron.RUTA_DIRECTORIO_ARCHIVOS + File.separator + nombreArchivo;
        return rutaArchivo;
    }

}
