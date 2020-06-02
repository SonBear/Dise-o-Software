/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtroladores;

import com.modelo.Cliente;
import com.modelo.Decorator.Articulo;
import com.vista.MenuCarrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author emman
 */
public class ControllerCarrito implements ActionListener {

    private final MenuCarrito menu = new MenuCarrito();
    private Cliente cliente;

    public ControllerCarrito(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        iniciarLista();
    }

    public void iniciar() {
        menu.getLabelCliente().setText("Cliente: " + cliente.getNombre());
        menu.setAlwaysOnTop(true);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void iniciarLista() {
        int i = 0;
        JList listaCarrito = menu.getListaArticulos();
        Enumeration<Articulo> listaArticulos = cliente.getCarritoCompras().listarArticulos();
        DefaultListModel model = new DefaultListModel();
        while (listaArticulos.hasMoreElements()) {
            Articulo nextElement = listaArticulos.nextElement();
            model.add(i++, nextElement);

        }

        listaCarrito.setModel(model);
    }

    private void initComponents() {
        menu.getBtnEliminar().addActionListener(this);
        menu.getBtnInspeccionar().addActionListener(this);
        menu.getBtnSalir().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Inspeccionar articulo":
                inspeccionar();
                break;

            case "Eliminar del carrito":
                eliminar();
                break;
            case "Salir":
                menu.dispose();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void inspeccionar() {
        JList listaCarrito = menu.getListaArticulos();
        Articulo articulo = (Articulo) listaCarrito.getSelectedValue();
        menu.getLabelNombre().setText("Nombre: " + articulo.toString());
        menu.getLabelDesc().setText("Descripcion: " + articulo.descripcion());
    }

    private void eliminar() {
        JList listaCarrito = menu.getListaArticulos();
        Articulo articulo = (Articulo) listaCarrito.getSelectedValue();
        cliente.getCarritoCompras().eliminarArticulo(articulo);
        iniciarLista();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        iniciarLista();
    }

}
