/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelo.Candidato;
import modelo.Observador;

/**
 *
 * @author emman
 */
public class GeneradorCSV implements Observador {

    private List<Candidato> candidatos;
    private File file;

    public GeneradorCSV(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void modificarRuta(String ruta) {
        file = new File(ruta + "\\votos.csv");
    }

    public void actualizarDatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    private void escribirArchivo() throws IOException {
        if (file == null) {
            file = new File("Archivos\\votos.csv");
        }
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < candidatos.size(); i++) {

            if (i == (candidatos.size() - 1)) {
                fw.write(candidatos.get(i).getNombre() + "\n");
            } else {
                fw.write(candidatos.get(i).getNombre() + ",");
            }
        }

        for (int i = 0; i < candidatos.size(); i++) {

            if (i == (candidatos.size() - 1)) {
                fw.write(candidatos.get(i).getVotos() + "\n");
            } else {
                fw.write(candidatos.get(i).getVotos() + ",");
            }
        }
        fw.close();
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
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
