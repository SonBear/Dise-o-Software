/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import ficheros.Alumno;
import java.util.ArrayList;

/**
 *
 * @author SonBear
 */
public class AccesoArchivoAlumnos extends AccesoArchivo<Alumno> {

    public AccesoArchivoAlumnos() {
        super("alumnos");
    }

    @Override
    public ArrayList<Alumno> obtenerObjetos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<String> datos = leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            alumnos.add(new Alumno(Integer.parseInt(variables[0]), variables[1], variables[2]));
        }
        return alumnos;
    }

}
