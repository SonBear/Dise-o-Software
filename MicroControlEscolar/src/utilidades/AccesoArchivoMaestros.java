/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import ficheros.Maestro;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class AccesoArchivoMaestros extends AccesoArchivo {

    public AccesoArchivoMaestros(File archivo) {
        super(archivo);
    }

    @Override
    public void imprimirArchivo() {
        System.out.println("---------------Lista   Maestros--------------------");

        for (int i = 0; i < leerArchivo().size(); i++) {
            String variables[] = leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

    @Override
    public <T> ArrayList<T> obtenerObjectos() {
        ArrayList<Maestro> maestros = new ArrayList();
        ArrayList<String> datos = leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Maestro unMaestro = new Maestro(Integer.parseInt(variables[0]), variables[1], variables[2]);
            maestros.add(unMaestro);
        }
        return (ArrayList<T>) maestros;
    }

}
