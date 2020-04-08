package PROPOSAL;

public class Logger {
    /*This class now cumplies with a singly responsability
     and the OpenClose Principle with help of Courrier Class, Hayes Class, Ernie Class*/

    public static void logOn(TipoModem m, String pno, String user, String pw) {
        m.dial(m, pno);
    }
}
