/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emman
 */
public abstract class AccesoArchivo {

    private File archivo;

    public AccesoArchivo(File archivo) {
        this.archivo = archivo;
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void agregarContenido(String data) {
        try {
            FileWriter escribirArchivo = new FileWriter(getArchivo().getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(escribirArchivo);
            Scanner leerArchivo = new Scanner(getArchivo());
            while (leerArchivo.hasNext()) {

                if (leerArchivo.nextLine().equals(data)) {
                    return;
                }
            }

            bw.write(data + "\n");
            bw.close();
            escribirArchivo.close();

        } catch (IOException ex) {
            Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<String> leerArchivo() {
        ArrayList<String> lista = new ArrayList<>();
        Scanner leerArchivo;

        try {
            leerArchivo = new Scanner(archivo);
            while (leerArchivo.hasNext()) {
                lista.add(leerArchivo.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error Archivo no encontrado");
        }
        return lista;
    }

    public abstract void imprimirArchivo();

    public abstract <T> ArrayList<T> obtenerObjectos();

    public void limpiarArchivo() {
        try {
            FileWriter escribirArchivo = new FileWriter(getArchivo().getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(escribirArchivo);
            Scanner leerArchivo = new Scanner(getArchivo());
            bw.write("");
            bw.close();
            escribirArchivo.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public <T> void reescribirArchivo(ArrayList<T> array) {

        limpiarArchivo();
        for (int i = 0; i < array.size(); i++) {
            agregarContenido(array.get(i).toString());
        }

    }
}
