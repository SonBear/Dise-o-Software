/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import ficheros.Asignatura;
import java.util.ArrayList;

/**
 *
 * @author SonBear
 */
public class AccesoArchivoAsignaturas extends AccesoArchivo<Asignatura> {

    public AccesoArchivoAsignaturas() {
        super("asignaturas");
    }

    @Override
    public ArrayList<Asignatura> obtenerObjetos() {
        ArrayList<String> datos = leerArchivo();
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Asignatura unaAsignatura = new Asignatura(variables[0], variables[1], variables[2]);
            asignaturas.add(unaAsignatura);
        }
        return asignaturas;
    }

}
