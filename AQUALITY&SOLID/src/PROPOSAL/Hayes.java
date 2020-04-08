package PROPOSAL;

public class Hayes implements TipoModem {
    /*The classes Courrier, Ernie and Hayes have the same behavior */

    @Override
    public void dial(TipoModem m, String pno) {
        System.out.println("Dialing original.Hayes");
    }

}
