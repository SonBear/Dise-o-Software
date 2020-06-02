/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtroladores;

import com.modelo.Cliente;
import com.modelo.Decorator.Articulo;
import com.modelo.tiendas.Tienda;
import com.vista.MenuTienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author emman
 */
public class ControllerTienda implements ActionListener {

    private MenuTienda menu = new MenuTienda();
    private ControllerCarrito contCarrito;
    private ControllerPago contPago;
    private Tienda tienda;
    private Cliente clienteActual = null;

    public ControllerTienda(Tienda tienda) {
        this.tienda = tienda;
        initComponents();
        iniciarListaArticulos();
        iniciarListaClientes();

    }

    public void iniciar() {
        menu.getLabelTienda().setText("Tienda: " + tienda);
        menu.setAlwaysOnTop(true);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getBtnAgregarCarrito().addActionListener(this);
        menu.getBtnComprar().addActionListener(this);
        menu.getBtnMostrarCarrito().addActionListener(this);
        menu.getBtnSalir().addActionListener(this);
        menu.getBtnSelectCliente().addActionListener(this);

    }

    public void iniciarListaArticulos() {
        JList listaTienda = menu.getListArticulos();
        List<Articulo> listaArticulos = tienda.getArticulos();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < listaArticulos.size(); i++) {
            model.add(i, listaArticulos.get(i));
        }
        listaTienda.setModel(model);
    }

    public void iniciarListaClientes() {
        JList listaTienda = menu.getListClientes();
        List<Cliente> listaCliente = tienda.getClientes();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < listaCliente.size(); i++) {
            model.add(i, listaCliente.get(i));
        }
        listaTienda.setModel(model);
    }

    private void agregarAlCarrito() {
        JList listaTienda = menu.getListArticulos();
        Articulo articulo = (Articulo) listaTienda.getSelectedValue();
        tienda.agregarAlCarrito(clienteActual.getCarritoCompras(), articulo);
    }

    private void cambiarClienteActual() {
        JList listaClientes = menu.getListClientes();
        Cliente cliente = (Cliente) listaClientes.getSelectedValue();
        clienteActual = cliente;
        menu.getLabelCliente().setText("Cliente: \n" + clienteActual.getNombre());
    }

    private void mostrarCarrito() {
        if (contCarrito == null && clienteActual != null) {
            contCarrito = new ControllerCarrito(clienteActual);
            contCarrito.iniciar();
        } else {
            contCarrito.setCliente(clienteActual);
            contCarrito.iniciar();
        }

    }

    private void mostrarPago() {
        if (clienteActual == null) {
            return;
        }
        if (contPago == null && clienteActual != null) {
            contPago = new ControllerPago(clienteActual);
            contPago.iniciar();
        } else {
            contPago.setCliente(clienteActual);
            contPago.iniciar();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Añadir al carrito":
                agregarAlCarrito();

                break;
            case "Mostrar carrito":
                mostrarCarrito();

                break;
            case "Seleccionar cliente":
                cambiarClienteActual();
                break;
            case "Comprar ahora":
                mostrarPago();
                break;
            case "Salir":
                tienda.salir(clienteActual);
                menu.dispose();

                break;
            default:
                throw new AssertionError();
        }

    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
        menu.getLabelCliente().setText("Cliente: \n" + clienteActual.getNombre());

    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
        iniciarListaArticulos();
        iniciarListaClientes();
        clienteActual = null;
        menu.getLabelCliente().setText("Cliente Actual: ");
    }

    public Tienda getTienda() {
        return tienda;
    }

}
