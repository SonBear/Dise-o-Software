/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

/**
 *
 * @author A18016328
 */
public class Maestro {

    private int clave;
    private String nombre;
    private String apellido;

    public Maestro(int clave, String nombre, String apellido) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Maestro " + "clave :" + clave + ", nombre :" + nombre + ", apellido: " + apellido;
    }

}
