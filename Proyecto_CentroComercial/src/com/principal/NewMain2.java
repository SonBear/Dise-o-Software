/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.modelo.ArticuloSencillo;
import com.modelo.Decorator.Articulo;
import com.modelo.Decorator.Paquete1;
import com.modelo.tiendas.Libreria;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Articulo ar1 = new ArticuloSencillo("asdsa", "sadasda", new Libreria(), 1200);
        Articulo ar2 = new ArticuloSencillo("asdsa", "sadasda", new Libreria(), 1200);
        Articulo ar3 = new ArticuloSencillo("asdsa", "sadasda", new Libreria(), 1200);
        Articulo ar4 = new ArticuloSencillo("asdsa", "sadasda", new Libreria(), 1200);
        Articulo ar5 = new ArticuloSencillo("asdsa", "sadasda", new Libreria(), 1200);
        ArrayList<Articulo> art = new ArrayList<>();
        art.add(ar1);
        art.add(ar2);
        art.add(ar5);

        Articulo paq1 = new Paquete1(art);
        System.out.println(paq1.descripcion());
        System.out.println(paq1.precio());

    }

}
