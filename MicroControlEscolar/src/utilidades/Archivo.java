/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public interface Archivo {

    void crearArchivo(File archivo);

    void agregarContenido(String data);

    ArrayList<String> leerArchivo();

    <T> ArrayList<T> leerObjetos();

    void imprimirArchivo();

    <T> void reescribirArchivo(ArrayList<T> n);

    void limpiarArchivo();

}
