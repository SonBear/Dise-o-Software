/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import ficheros.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class Relacion {

    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Maestro> listaMaestro;
    private ArrayList<Asignatura> listaAsignatura;

    public Relacion(ArrayList<Alumno> listaAlumnos, ArrayList<Maestro> listaMaestro, ArrayList<Asignatura> listaAsignatura) {
        this.listaAlumnos = listaAlumnos;
        this.listaMaestro = listaMaestro;
        this.listaAsignatura = listaAsignatura;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public ArrayList<Maestro> getListaMaestro() {
        return listaMaestro;
    }

    public ArrayList<Asignatura> getListaAsignatura() {
        return listaAsignatura;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public void setListaMaestro(ArrayList<Maestro> listaMaestro) {
        this.listaMaestro = listaMaestro;
    }

    public void setListaAsignatura(ArrayList<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    public void insertarDatosAlumnosArrayList(AccesoArchivo archivo) {
        ArrayList<String> datos = archivo.leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Alumno unAlumno = new Alumno(Integer.parseInt(variables[0]), variables[1], variables[2]);
            listaAlumnos.add(unAlumno);
        }
    }

    public void insertarDatosMaestrosArrayList(AccesoArchivo archivo) {
        ArrayList<String> datos = archivo.leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Maestro unMaestro = new Maestro(Integer.parseInt(variables[0]), variables[1], variables[2]);
            listaMaestro.add(unMaestro);
        }
    }

    public void insertarDatosAsignaturasArrayList(AccesoArchivo archivo) {
        ArrayList<String> datos = archivo.leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Asignatura unaAsignatura = new Asignatura(variables[0], variables[1], variables[2]);
            listaAsignatura.add(unaAsignatura);
        }
    }

    public void relacionarMaestroAsignatura(AccesoArchivo archivo) {
        Scanner leer = new Scanner(System.in);
        if (listaMaestro.isEmpty() || listaAsignatura.isEmpty()) {
            System.out.println("Algunos archivos estan vacios");

        } else {
            for (int i = 0; i < listaMaestro.size(); i++) {
                System.out.println("Escriba la clave de la asignatura para el maestro, escriba 0 para saltar");
                System.out.println(listaMaestro.get(i));
                System.out.print("Clave: ");
                String clave = leer.next();
                for (int j = 0; j < listaAsignatura.size(); j++) {
                    if (clave.equals(listaAsignatura.get(j).getClave())) {
                        archivo.agregarContenido(listaMaestro.get(i).getClave() + "," + listaAsignatura.get(j).getClave());

                    }

                }
            }
        }
    }

    public void imprimirRelacionMaestroAsignatura(AccesoArchivo archivo) {
        relacionarMaestroAsignatura(archivo);
        ArrayList<String> maestroAsignatura = archivo.leerArchivo();
        if (listaAsignatura.isEmpty() || listaMaestro.isEmpty()) {
            return;

        } else {

            for (int i = 0; i < maestroAsignatura.size(); i++) {
                String variables[] = maestroAsignatura.get(i).split(",");
                int claveMaestro = Integer.parseInt(variables[0]);
                String claveAsignatura = variables[1];
                for (int j = 0; j < listaMaestro.size(); j++) {
                    if (claveMaestro == listaMaestro.get(j).getClave()) {
                        System.out.print(claveMaestro + " Es la clave del maestro "
                                + listaMaestro.get(j).getNombre() + " " + listaMaestro.get(j).getApellido() + " que imparte ");
                    }
                }
                for (int k = 0; k < listaAsignatura.size(); k++) {
                    if (claveAsignatura.equals(listaAsignatura.get(k).getClave())) {
                        System.out.println(listaAsignatura.get(k).getNombre());
                    }

                }
            }
        }
    }

}
