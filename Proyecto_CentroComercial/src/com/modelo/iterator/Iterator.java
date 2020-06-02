/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.iterator;

/**
 *
 * @author emman
 */
public interface Iterator<T> {

    public boolean hasNext();

    public T next();
}
