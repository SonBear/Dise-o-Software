package PROPOSAL;

public class Courrier implements TipoModem {
    /*The classes Courrier, Ernie and Hayes have the same behavior */

    @Override
    public void dial(TipoModem m, String pno) {
        System.out.println("Dialing original." + this.getClass().getName());
    }

}
