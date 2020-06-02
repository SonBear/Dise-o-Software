/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.modelo.Estado.CarritoCancelado;
import com.modelo.observer.Observador;
import com.modelo.tiendas.Tienda;

/**
 *
 * @author emman
 */
public class Cliente implements Observador {

    private String nombre;
    private CarritoCompras carritoCompras;
    private Tienda tiendaActual;
    private String notificacion;

    public Cliente(String nombre, CarritoCompras carritoCompras, Tienda tiendaActual) {
        this.nombre = nombre;
        this.carritoCompras = carritoCompras;
        this.tiendaActual = tiendaActual;
    }

    /**
     * Esta es mi propuesta, que cada cliente pueda pagar su carrito
     */
    public String pagarCarrito() {
        //Se cancela el carrito, ya que fue pagado
        carritoCompras.setEstado(new CarritoCancelado());
        return "El cliente ha pagado por sus articulos";
    }

    public String getNombre() {
        return nombre;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public Tienda getTiendaActual() {
        return tiendaActual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public void setTiendaActual(Tienda tiendaActual) {
        this.tiendaActual = tiendaActual;
    }

    @Override
    public String toString() {
        return "Cliente = " + "nombre: " + nombre;
    }

    public String getNotificacion() {
        return notificacion;
    }

    @Override
    public void actualizar() {
        notificacion = "Nuevo articulo en tienda";

    }

}
