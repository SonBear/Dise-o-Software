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
public interface FactoryPublicacion {

    public Articulo crearArticulo(String autor, String nombre);

    public Publicacion crearPublicacion(String tituloPublicacion);
}
