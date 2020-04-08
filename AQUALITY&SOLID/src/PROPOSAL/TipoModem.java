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
public interface TipoModem {
    /*This class help to accomplish the segregation interface principle, and the Liskov Subtitution principle
     and Open/Close principle*/

    void dial(TipoModem m, String pno);

}
