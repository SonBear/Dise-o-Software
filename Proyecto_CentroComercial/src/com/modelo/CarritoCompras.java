/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.modelo.Decorator.Articulo;
import com.modelo.Estado.CarritoCancelado;
import com.modelo.Estado.CarritoEstado;
import com.modelo.Estado.CarritoLleno;
import com.modelo.Estado.CarritoUsado;
import com.modelo.Estado.CarritoVacio;
import com.modelo.iterator.FactoryEnumeration;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author emman
 */
public class CarritoCompras {

    private List<Articulo> articulos;
    private final int capacidad = 20;
    //Este es el contexto deonde utilizaremos los estados
    private CarritoEstado estado;

    public CarritoCompras() {

        articulos = new ArrayList<>();
        setEstado(new CarritoVacio());
    }

    public void addArticulo(Articulo articulo) {
        if (articulos.size() > capacidad) {
            setEstado(new CarritoLleno());

        } else {
            articulos.add(articulo);
            setEstado(new CarritoUsado());
        }
    }

    public void eliminarArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public Enumeration listarArticulos() {
        Enumeration<Articulo> enumeration = FactoryEnumeration.enumeration(articulos);

        return enumeration;

    }

    public void cancelarCarrito() {
        setEstado(new CarritoCancelado());
    }

    public void setEstado(CarritoEstado estado) {
        this.estado = estado;

    }

    public String getEstado() {
        return estado.manejar();
    }

}
