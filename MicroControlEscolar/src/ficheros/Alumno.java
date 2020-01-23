package ficheros;

import controlEscolar.Clase;
import java.util.ArrayList;

public class Alumno {

    private int matricula;
    private String nombre;
    private String apellido;
    private ArrayList<Clase> clases;

    public Alumno(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        clases = new ArrayList();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return matricula + "," + nombre + "," + apellido;
    }

}
