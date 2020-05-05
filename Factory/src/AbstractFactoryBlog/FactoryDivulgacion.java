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
public class FactoryDivulgacion implements FactoryPublicacion {

    @Override
    public Articulo crearArticulo(String autor, String nombre) {
        return new ArticuloDivulgacion(autor, autor);
    }

    @Override
    public Publicacion crearPublicacion(String tituloPublicacion) {
        return new Blog(tituloPublicacion);
    }

}
