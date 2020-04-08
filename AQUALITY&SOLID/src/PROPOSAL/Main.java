/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROPOSAL;

/**
 *
 * @author emman
 */
public class Main {

    public Main() {
        Logger.logOn(new Hayes(), "hola", "juan", "admin123");
        Logger.logOn(new Courrier(), "hola", "juan", "admin123");
        Logger.logOn(new Ernie(), "hola", "juan", "admin123");
    }

    public static void main(String[] args) {
        new Main();
    }

}
