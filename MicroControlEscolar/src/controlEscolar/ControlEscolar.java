package controlEscolar;

import ficheros.Alumno;
import ficheros.Asignatura;
import ficheros.Maestro;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilidades.AccesoArchivoAlumnos;
import utilidades.AccesoArchivoAsignaturas;
import utilidades.AccesoArchivoClases;
import utilidades.AccesoArchivoCursos;
import utilidades.AccesoArchivoMaestros;
import utilidades.GeneradorPdf;
import vista.Interfaz;

/**
 *
 * @author SonBear
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

    public ControlEscolar() {
        this.listaAlumnos = new ArrayList<>();
        this.listaMaestros = new ArrayList<>();
        this.listaAsignaturas = new ArrayList<>();
        this.listaClases = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
        accesoAlumno = new AccesoArchivoAlumnos();
        accesoMaestro = new AccesoArchivoMaestros();
        accesoAsignatura = new AccesoArchivoAsignaturas();
        accesoClase = new AccesoArchivoClases();
        accesoCurso = new AccesoArchivoCursos();

    }

    public void iniciar() {
        Interfaz menu = new Interfaz();
        Scanner leerOP = new Scanner(System.in);
        int op;
        do {
            menu.imprimirInterfaz();
            op = leerOP.nextInt();
            actualizar();
            switch (op) {
                case 1:
                    ingresarAlumno();
                    break;
                case 2:
                    ingresarMaestro();
                    break;
                case 3:
                    ingresarAsignatura();
                    break;
                case 4:
                    crearClase();
                    break;
                case 5:
                    sececionarAlumnoClase();
                    break;
                case 6:
                    imprimirCursosConAlumnos();
                    break;
                case 7:

                    generarPdfCurso();
                    break;
                case 8:
                    eliminarAlumno();
                    break;
                case 9:
                    eliminarMaestro();
                default:
                    System.out.println("No existe esa opcion");
                    ;
            }
            reescribirArchivos();
        } while (op != 0);
    }

    public void eliminarAlumno() {
        Scanner leerOp = new Scanner(System.in);
        imprimirListaAlumnos();
        System.out.print("Ingrese el numero del alumnos a eliminar: ");
        int op = leerOp.nextInt() - 1;
        listaAlumnos.remove(op);
    }

    public void eliminarMaestro() {
        Scanner leerOp = new Scanner(System.in);
        imprimirListaMaestros();
        System.out.println("- Ingrese el numeero del maestro a eliminar: ");
        int op = leerOp.nextInt() - 1;
        listaMaestros.remove(op);
    }

    public void ingresarAlumno() {
        System.out.println("----------Ingrese el nuevo alumno:--------");
        try {
            Scanner leerOp = new Scanner(System.in);
            Scanner leerStr = new Scanner(System.in);
            System.out.print("Matricula: ");
            int matricula = leerOp.nextInt();
            System.out.print("Nombre: ");
            String nombre = leerStr.next();
            System.out.print("Apellido: ");
            String apellido = leerStr.next();
            Alumno unAlumno = new Alumno(matricula, nombre, apellido);
            listaAlumnos.add(unAlumno);
        } catch (InputMismatchException ex) {
            System.out.println("Error al ingresar la matricula");
        }

        System.out.println("---------------------------------------");
    }

    public void ingresarMaestro() {
        try {
            Scanner leerOp = new Scanner(System.in);
            Scanner leerStr = new Scanner(System.in);
            System.out.println("---Ingrese el nuevo Maestro:---");
            System.out.print("Clave: ");
            int clave = leerOp.nextInt();
            System.out.print("Nombre: ");
            String nombreM = leerStr.next();
            System.out.print("Apellido: ");
            String apellidoM = leerStr.next();
            Maestro unMaestro = new Maestro(clave, nombreM, apellidoM);
            listaMaestros.add(unMaestro);
        } catch (InputMismatchException ex) {
            System.out.println("Error al ingresar clave");
        }

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
        listaAsignaturas.add(unaAsignatura);
    }

    public void crearClase() {
        Scanner leerOp = new Scanner(System.in);
        System.out.println("----------Creacion de clases------------");
        try {
            imprimirListaMaestros();
            System.out.print("Elige el numero de maestro: ");
            int maestro = leerOp.nextInt() - 1;
            imprimirListaAsignaturas();
            System.out.print("Elige el numero de asignatura: ");
            int asignatura = leerOp.nextInt() - 1;
            Clase unaClase = new Clase(listaMaestros.get(maestro), listaAsignaturas.get(asignatura));
            listaClases.add(unaClase);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error al seleccionar");
        }
        System.out.println("-----------------------------------------");
    }

    public void sececionarAlumnoClase() {
        Scanner leerOp = new Scanner(System.in);
        System.out.println("------------Alumnos relacion asignaturas------------");
        try {
            imprimirListaAlumnos();
            System.out.print("-Ingrese el numero de alumno: ");
            int alumno = leerOp.nextInt() - 1;
            imprimirClases();
            System.out.println("Ingrese el numero de maestro: ");
            int clase = leerOp.nextInt() - 1;
            Curso unCurso = new Curso(listaClases.get(clase), accesoCurso);
            unCurso.getListaAlumnosInscritos().add(listaAlumnos.get(alumno));
            listaCursos.add(unCurso);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error al seleccionar");
        }

    }

    public void generarPdfCurso() {
        try {
            Scanner leerOp = new Scanner(System.in);
            imprimirCursosDisponibles();
            System.out.print("-Ingrese el numero de curso: ");
            int cursoNo = leerOp.nextInt() - 1;
            GeneradorPdf.generarPDF(listaCursos.get(cursoNo));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Elija un curso Existente");
        }

    }

    public void imprimirCursosConAlumnos() {

        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println("----------" + listaCursos.get(i).getClase() + "---------");
            for (int j = 0; j < listaCursos.get(i).getListaAlumnosInscritos().size(); j++) {
                System.out.println(listaCursos.get(i).getListaAlumnosInscritos().get(j));
            }
        }
    }

    public void imprimirListaAlumnos() {
        System.out.println("---------------Lista   Alumnos--------------------");

        for (int i = 0; i < accesoAlumno.leerArchivo().size(); i++) {
            String variables[] = accesoAlumno.leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

    public void imprimirListaMaestros() {
        System.out.println("---------------Lista   Maestros--------------------");

        for (int i = 0; i < accesoMaestro.leerArchivo().size(); i++) {
            String variables[] = accesoMaestro.leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

    public void imprimirClases() {
        System.out.println("-------------------------Lista clases-------------------");
        for (int i = 0; i < listaClases.size(); i++) {
            int clave = listaClases.get(i).getMaestro().getClave();
            String nombreA = listaClases.get(i).getAsignatura().getNombre();
            System.out.println((i + 1) + " El maestro con clave: " + clave + " Imparte la materia: " + nombreA);
        }
        System.out.println("---------------------------------------------------------");
    }

    public void imprimirCursosDisponibles() {

        System.out.println("------------Cursos Disponibles-------------");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println((i + 1) + ".- Clase: " + listaCursos.get(i).getClase().getAsignatura() + " Maestro: " + listaCursos.get(i).getClase().getMaestro().toString());

        }
        System.out.println("------------------------------------------");
    }

    public void actualizar() {
        listaAlumnos = accesoAlumno.obtenerObjetos();
        listaMaestros = accesoMaestro.obtenerObjetos();
        listaAsignaturas = accesoAsignatura.obtenerObjetos();
        accesoClase.setListaAsignatura(listaAsignaturas);
        accesoClase.setListaMaestro(listaMaestros);
        listaClases = accesoClase.obtenerObjetos();
        accesoCurso.setListaClases(listaClases);
        listaCursos = accesoCurso.obtenerObjetos();
    }

    public void reescribirArchivos() {
        accesoAlumno.reescribirArchivo(listaAlumnos);
        accesoAsignatura.reescribirArchivo(listaAsignaturas);
        accesoMaestro.reescribirArchivo(listaMaestros);
        accesoClase.setListaAsignatura(listaAsignaturas);
        accesoClase.setListaMaestro(listaMaestros);
        listaClases = accesoClase.obtenerObjetos();
        accesoClase.reescribirArchivo(listaClases);
        accesoCurso.reescribirArchivoCursos(listaCursos);
    }

    private void imprimirListaAsignaturas() {
        System.out.println("---------------Lista   Asignatura--------------------");

        for (int i = 0; i < accesoAsignatura.leerArchivo().size(); i++) {
            String variables[] = accesoAsignatura.leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

}
