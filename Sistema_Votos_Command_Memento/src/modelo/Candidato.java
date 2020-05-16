/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author emman
 */
public class Candidato {

    private ImageIcon foto = new ImageIcon();
    private String nombre;
    private int votos;

    public Candidato(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        final Candidato other = (Candidato) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        String nombre = this.nombre;
        int votos = this.votos;
        return new Candidato(nombre, votos);
    }

    @Override
    public String toString() {
        return nombre + " ";
    }

}
