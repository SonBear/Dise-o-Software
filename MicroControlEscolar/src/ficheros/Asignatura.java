/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

/**
 *
 * @author SonBear
 */
public class Asignatura {

    private String clave;
    private String licenciatura;
    private String nombre;

    public Asignatura(String clave, String licenciatura, String nombre) {
        this.clave = clave;
        this.licenciatura = licenciatura;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return clave + "," + licenciatura + "," + nombre;
    }

}
