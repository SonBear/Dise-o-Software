/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_Observer.Observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author emman
 */
public class GeneradorCSV implements Observador {

    private int votos_1, votos_2, votos_3;
    private File file;

    public void modificarRuta(String ruta) {
        file = new File(ruta + "\\votos.csv");
    }

    public void actualizarDatos(int votos_1, int votos_2, int votos_3) {
        this.votos_1 = votos_1;
        this.votos_2 = votos_2;
        this.votos_3 = votos_3;
    }

    private void escribirArchivo() throws IOException {
        if (file == null) {
            file = new File("Archivos\\votos.csv");
        }
        FileWriter fw = new FileWriter(file);
        fw.write("Votante1,Votente2,Votante3\n");
        fw.write(votos_1 + "," + votos_2 + "," + votos_3);
        fw.close();
    }

    public void setVotos_1(int votos_1) {
        this.votos_1 = votos_1;
    }

    public void setVotos_2(int votos_2) {
        this.votos_2 = votos_2;
    }

    public void setVotos_3(int votos_3) {
        this.votos_3 = votos_3;
    }

    public int getVotos_1() {
        return votos_1;
    }

    public int getVotos_2() {
        return votos_2;
    }

    public int getVotos_3() {
        return votos_3;
    }

    @Override
    public void actualizar() {
        try {
            escribirArchivo();
        } catch (IOException ex) {
            System.out.println("Error Archivo No Encontrado");
        }
    }

}
