package ficheros;

public class Alumno implements Comparable<Alumno> {

    private int matricula;
    private String nombre;
    private String apellido;

    public Alumno(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public int compareTo(Alumno o) {
        return getApellido().compareTo(o.getApellido());
    }

}
