/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlEscolar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ficheros.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.*;

/**
 *
 * @author emman
 */
public class ControlEscolar {

    private AccesoArchivoAlumnos accesoAlumno;
    private AccesoArchivoMaestros accesoMaestro;
    private AccesoArchivoAsignaturas accesoAsignatura;
    private AccesoArchivoClases accesoClase;
    private AccesoArchivoCursos accesoCurso;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Maestro> listaMaestros;
    private ArrayList<Asignatura> listaAsignaturas;
    private ArrayList<Clase> listaClases;
    private ArrayList<Curso> listaCursos;

    public ControlEscolar(File alumno, File maestro, File asignatura, File clase, File cursos) {
        this.listaAlumnos = new ArrayList<>();
        this.listaMaestros = new ArrayList<>();
        this.listaAsignaturas = new ArrayList<>();
        this.listaClases = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
        accesoAlumno = new AccesoArchivoAlumnos(alumno);
        accesoMaestro = new AccesoArchivoMaestros(maestro);
        accesoAsignatura = new AccesoArchivoAsignaturas(asignatura);
        accesoClase = new AccesoArchivoClases(listaMaestros, listaAsignaturas, clase);
        accesoCurso = new AccesoArchivoCursos(listaClases, listaAlumnos, cursos);

    }

    public void ingresarAlumno() {
        Scanner leerOp = new Scanner(System.in);
        Scanner leerStr = new Scanner(System.in);
        System.out.println("----------Ingrese el nuevo alumno:--------");
        System.out.print("Matricula: ");
        int matricula = leerOp.nextInt();
        System.out.print("Nombre: ");
        String nombre = leerStr.next();
        System.out.print("Apellido: ");
        String apellido = leerStr.next();
        Alumno unAlumno = new Alumno(matricula, nombre, apellido);
        accesoAlumno.agregarContenido(unAlumno.toString());
        System.out.println("---------------------------------------");
    }

    public void ingresarMaestro() {
        Scanner leerOp = new Scanner(System.in);
        Scanner leerStr = new Scanner(System.in);
        System.out.println("---Ingrese el nuevo Maestro:---");
        System.out.print("Clave: ");
        int clave = leerOp.nextInt();
        System.out.print("Nombre: ");
        String nombreM = leerStr.next();
        System.out.print("Apellido: ");
        String apellidoM = leerStr.next();
        accesoMaestro.agregarContenido(new Maestro(clave, nombreM, apellidoM).toString());
        System.out.println("---------------------------------------");
    }

    public void ingresarAsignatura() {
        Scanner leerStr = new Scanner(System.in);
        System.out.println("---Ingrese la nueva asignatura:---");
        System.out.print("Clave: ");
        String claveA = leerStr.nextLine();
        System.out.print("Licenciatura: ");
        String licenciatura = leerStr.nextLine();
        System.out.print("Nombre: ");
        String nombreA = leerStr.nextLine();
        Asignatura unaAsignatura = new Asignatura(claveA, licenciatura, nombreA);
        accesoAsignatura.agregarContenido(unaAsignatura.toString());
    }

    public void crearClase() {
        Scanner leerOp = new Scanner(System.in);
        System.out.println("----------Creacion de clases------------");
        accesoMaestro.imprimirArchivo();
        System.out.print("Elige el numero de maestro: ");
        int maestro = leerOp.nextInt() - 1;
        accesoAsignatura.imprimirArchivo();
        System.out.print("Elige el numero de asignatura: ");
        int asignatura = leerOp.nextInt() - 1;
        Clase unaClase = new Clase(listaMaestros.get(maestro), listaAsignaturas.get(asignatura));
        accesoClase.agregarContenido(unaClase.toString());
        System.out.println("-----------------------------------------");
    }

    public void sececionarAlumnoClase() {
        Scanner leerOp = new Scanner(System.in);
        System.out.println("------------Alumnos relacion asignaturas------------");
        accesoAlumno.imprimirArchivo();
        System.out.print("-Ingrese el numero de alumno: ");
        int alumno = leerOp.nextInt() - 1;
        accesoClase.imprimirClases();
        System.out.println("Ingrese el numero de maestro: ");
        int clase = leerOp.nextInt() - 1;
        listaAlumnos.get(alumno).getClases().add(listaClases.get(clase));
        accesoCurso.agregarContenido(listaAlumnos.get(alumno).toString() + "," + listaClases.get(clase).toString());
    }

    public void GenerarPdfCurso() throws FileNotFoundException, DocumentException {
        Scanner leerOp = new Scanner(System.in);
        listaAlumnos = accesoAlumno.recuperarDatosArrayAlumno(listaClases, accesoCurso);
        accesoCurso.setListaAlumnos(listaAlumnos);
        listaCursos = accesoCurso.obtenerObjectos();
        accesoCurso.imprimirClases();
        System.out.print("-Ingrese el numero de curso: ");
        int cursoNo = leerOp.nextInt() - 1;
        generarPDF(listaCursos.get(cursoNo));
    }

    public void imprimirCursosConAlumnos() {
        listaAlumnos = accesoAlumno.recuperarDatosArrayAlumno(listaClases, accesoCurso);
        accesoCurso.setListaAlumnos(listaAlumnos);
        accesoCurso.imprimirArchivo();
    }

    public void imprimirAlumnosClases() {
        accesoAlumno.imprimirClasesAlumno(listaClases, accesoCurso);
    }

    public void actualizarArrays() {
        listaAlumnos = accesoAlumno.obtenerObjectos();
        listaMaestros = accesoMaestro.obtenerObjectos();
        listaAsignaturas = accesoAsignatura.obtenerObjectos();
        accesoClase.setListaAsignatura(listaAsignaturas);
        accesoClase.setListaMaestro(listaMaestros);
        listaClases = accesoClase.obtenerObjectos();
        accesoCurso.setListaAlumnos(listaAlumnos);
        accesoCurso.setListaClases(listaClases);
        listaCursos = accesoCurso.obtenerObjectos();
    }

    public void limpiarArrays() {
        listaAlumnos.clear();
        listaMaestros.clear();
        listaAsignaturas.clear();
        listaClases.clear();
        listaCursos.clear();
    }

    public void generarPDF(Curso h) throws FileNotFoundException, DocumentException {

        FileOutputStream archivo = new FileOutputStream("archivos\\lista.pdf");
        Document doc = new Document();
        PdfWriter.getInstance(doc, archivo);
        doc.open();
        String asignatura = h.getClase().getAsignatura().toString();
        String maestro = h.getClase().getMaestro().toString();
        Paragraph p = new Paragraph();
        p.add(asignatura);
        p.setAlignment(1);
        doc.add(p);
        Paragraph p2 = new Paragraph(maestro);
        p2.setAlignment(1);
        doc.add(p2);
        doc.add(new Paragraph(" "));
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("Nombre");
        tabla.addCell("Asistencia");
        tabla.addCell("22/1/2020");

        for (int i = 0; i < h.getListaAlumnosInscritos().size(); i++) {

            tabla.addCell(h.getListaAlumnosInscritos().get(i).toString());
            tabla.addCell(" ok ");
            tabla.addCell(" :) ");
        }
        doc.add(tabla);
        doc.close();
    }
}
