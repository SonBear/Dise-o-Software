package FactoryDespues;

public class Cliente {

    public Cliente() {

    }

    public String encriptar(String texto, String algo) {
        AlgoritmoEncriptamiento algoritmo = FactoryAlgoritmosEncrip.generarAlgoritmo(algo);
        return algoritmo.encriptar(texto);
    }

    public static void main(String args[]) {
        String cadenaEncriptada;
        cadenaEncriptada = new Cliente().encriptar("Hola", "khash");
        System.out.println(cadenaEncriptada);
    }

}
