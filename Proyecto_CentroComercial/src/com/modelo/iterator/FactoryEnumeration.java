/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.iterator;

import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author emman
 */
public class FactoryEnumeration {

    public static <T> Enumeration<T> enumeration(final List<T> c) {
        return new Enumeration<T>() {
            //Esta es mi implementacion del patron iterator, usando la clase Enumeration de java y mi interfaz Iterator
            //Este funciona solo para objetos List de java
            private final Iterator<T> i = new Iterator<T>() {
                int cont;

                @Override
                public boolean hasNext() {
                    if (cont >= c.size()) {
                        return false;
                    }
                    return true;
                }

                @Override
                public T next() {
                    return c.get(cont++);
                }
            };

            public boolean hasMoreElements() {
                return i.hasNext();
            }

            public T nextElement() {
                return i.next();
            }
        };
    }

}
