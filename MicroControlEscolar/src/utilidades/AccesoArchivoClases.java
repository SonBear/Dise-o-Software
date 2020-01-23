/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import controlEscolar.Clase;
import ficheros.Asignatura;
import ficheros.Maestro;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class AccesoArchivoClases extends AccesoArchivo {

    private ArrayList<Maestro> listaMaestro;
    private ArrayList<Asignatura> listaAsignatura;

    public AccesoArchivoClases(ArrayList<Maestro> listaMaestro, ArrayList<Asignatura> listaAsignatura, File archivo) {
        super(archivo);
        this.listaMaestro = listaMaestro;
        this.listaAsignatura = listaAsignatura;
    }

    public void setListaMaestro(ArrayList<Maestro> listaMaestro) {
        this.listaMaestro = listaMaestro;
    }

    public void setListaAsignatura(ArrayList<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    public void imprimirClases() {
        ArrayList<Clase> listaClases = obtenerObjectos();
        System.out.println("-------------------------Lista clases-------------------");
        for (int i = 0; i < listaClases.size(); i++) {
            int clave = listaClases.get(i).getMaestro().getClave();
            String nombreA = listaClases.get(i).getAsignatura().getNombre();
            System.out.println((i + 1) + " El maestro con clave: " + clave + " Imparte la materia: " + nombreA);
        }
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public void imprimirArchivo() {
        imprimirClases();
    }

    @Override
    public <T> ArrayList<T> obtenerObjectos() {
        ArrayList<String> datos = leerArchivo();
        ArrayList<Clase> listaClases = new ArrayList<>();
        Maestro maestro = null;
        Asignatura asignatura = null;

        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            for (int j = 0; j < listaMaestro.size(); j++) {
                if (variables[0].equals(listaMaestro.get(j).getClave() + "")) {
                    maestro = listaMaestro.get(j);
                }
            }
            for (int j = 0; j < listaAsignatura.size(); j++) {
                if (variables[1].equals(listaAsignatura.get(j).getClave())) {
                    asignatura = listaAsignatura.get(j);
                }
            }
            if (maestro != null && asignatura != null) {
                listaClases.add(new Clase(maestro, asignatura));
            }
        }
        return (ArrayList<T>) listaClases;
    }

}
