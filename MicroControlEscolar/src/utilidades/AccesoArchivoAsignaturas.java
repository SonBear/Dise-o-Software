/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import ficheros.Asignatura;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class AccesoArchivoAsignaturas extends AccesoArchivo {

    public AccesoArchivoAsignaturas(File archivo) {
        super(archivo);
    }

    @Override
    public void imprimirArchivo() {
        System.out.println("---------------Lista   Asignatura--------------------");

        for (int i = 0; i < leerArchivo().size(); i++) {
            String variables[] = leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

    @Override
    public <T> ArrayList<T> obtenerObjectos() {
        ArrayList<String> datos = leerArchivo();
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Asignatura unaAsignatura = new Asignatura(variables[0], variables[1], variables[2]);
            asignaturas.add(unaAsignatura);
        }
        return (ArrayList<T>) asignaturas;
    }

}
