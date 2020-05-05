/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryBlog;

/**
 *
 * @author emman
 */
public class FactoryCientifico implements FactoryPublicacion {

    @Override
    public Articulo crearArticulo(String autor, String nombre) {
        return new ArticuloCientifico(autor, nombre);
    }

    @Override
    public Publicacion crearPublicacion(String tituloPublicacion) {
        return new RevistaCientifica(tituloPublicacion);
    }

}
