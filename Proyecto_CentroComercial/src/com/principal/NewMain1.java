/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.comtroladores.ControllerMenu;
import com.modelo.ArticuloSencillo;
import com.modelo.CentroComercial;
import com.modelo.Cliente;
import com.modelo.Decorator.Articulo;
import com.modelo.Decorator.Paquete1;
import com.modelo.factory.Factory;
import com.modelo.factory.FactoryTienda;
import com.modelo.tiendas.Libreria;
import com.modelo.tiendas.Tienda;
import java.util.ArrayList;

/**
 * Falta el solicitar un carrito Falta el crear paquetes
 *
 * @author emman
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CentroComercial ce = new CentroComercial("MATH.ES");

        Factory fac = new FactoryTienda();
        Tienda ff = fac.crearTienda("Zapateria");
        Tienda f = fac.crearTienda("Libreria");
        Cliente cliente = new Cliente("Emmanuel chable", null, ff);
        Cliente cliente2 = new Cliente("Alvaro Trujeque", null, ff);
        ff.adicionarArticulo(new ArticuloSencillo("Zapato", "ddddd", ff, 103));
        ff.adicionarArticulo(new ArticuloSencillo("Zapato", "dddd1", ff, 1202));
        ff.adicionarArticulo(new ArticuloSencillo("Zapato", "dddd2", ff, 1333));
        ff.adicionarArticulo(new ArticuloSencillo("Zapato", "dddd3", ff, 300));
        ff.adicionarArticulo(new ArticuloSencillo("Zapato", "dddd4", ff, 560));

        f.adicionarArticulo(new ArticuloSencillo("Libro", "aaaaa", f, 103));
        f.adicionarArticulo(new ArticuloSencillo("Libro", "aaaaa", f, 103));

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
        f.adicionarArticulo(paq1);
        ce.entrar(cliente);
        ce.entrar(cliente2);
        ce.addTienda(ff);
        ce.addTienda(f);
        f.adicionarArticulo(new ArticuloSencillo("Libro", "aaaaa", f, 103));
        System.out.println(cliente.getNotificacion());
        ControllerMenu c2 = new ControllerMenu(ce);
        c2.iniciar();
    }

}
