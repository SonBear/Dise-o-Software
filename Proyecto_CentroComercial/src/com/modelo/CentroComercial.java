package com.modelo;

import com.modelo.Estado.CarritoCancelado;
import com.modelo.iterator.FactoryEnumeration;
import com.modelo.tiendas.Tienda;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emman
 */
public class CentroComercial {

    private String nombre;
    private List<Tienda> tiendas;
    private List<Cliente> clientes;

    public CentroComercial(String nombre) {
        this.nombre = nombre;
        tiendas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void entrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void salir(Cliente cliente) {
        clientes.remove(cliente);
    }

    public CarritoCompras getCarrito() {
        return new CarritoCompras();
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public Enumeration<Tienda> listarTiendas() {
        Enumeration<Tienda> enumeration = FactoryEnumeration.enumeration(tiendas);
        return enumeration;
    }

    public Enumeration<Cliente> listarClientes() {
        Enumeration<Cliente> enumeration = FactoryEnumeration.enumeration(clientes);
        return enumeration;
    }

    public void addTienda(Tienda tienda) {
        //Cada vez que una tienda se agrega entonces a esa misma tienda le añadimos los observadores
        for (int i = 0; i < clientes.size(); i++) {
            tienda.añadirObservador(clientes.get(i));
        }
        tiendas.add(tienda);

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String pagar(CarritoCompras carritoCompras) {
        carritoCompras.setEstado(new CarritoCancelado());
        return "El carrito ha sido pagado";
    }
}
