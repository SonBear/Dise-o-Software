/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtroladores;

import com.modelo.Cliente;
import com.modelo.Decorator.Articulo;
import com.vista.MenuPago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author emman
 */
public class ControllerPago implements ActionListener {

    private final MenuPago menu = new MenuPago();
    private Cliente cliente;

    public ControllerPago(Cliente cliente) {
        this.cliente = cliente;
        initComponenets();
        iniciarLista();
        setTotal();
    }

    public void iniciar() {
        menu.getLabelCliente().setText("Cliente: " + cliente.getNombre());
        menu.setLocationRelativeTo(null);
        menu.setAlwaysOnTop(true);
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Realizar compra":
                menu.mensaje(cliente.pagarCarrito());
                break;
            default:
                throw new AssertionError();
        }
    }

    private void setTotal() {
        double total = 0;
        List<Articulo> listaArticulos = cliente.getCarritoCompras().getArticulos();
        for (int i = 0; i < listaArticulos.size(); i++) {
            total += listaArticulos.get(i).precio();
        }
        menu.getLabelTotal().setText("$ " + total);

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

    private void initComponenets() {
        menu.getBtnRealizar().addActionListener(this);

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        iniciarLista();
        setTotal();
    }

}
