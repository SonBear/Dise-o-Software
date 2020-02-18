/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author emman
 */
public interface DAOFicheros<T> {

    void agregar(T e);

    void modificar(T e);

    void eliminar(T e);

    ArrayList<T> listar();
}
