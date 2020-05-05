package AbstractFactory;

public class Cliente {

    private FactoryAlgoritmos factory;

    public String encriptar(String texto) {

        AlgoritmoEncriptamiento algoritmo = factory.crearAlgoritmo();

        return algoritmo.encriptar(texto);
    }

    public void setFactory(FactoryAlgoritmos factory) {
        this.factory = factory;
    }

    public static void main(String args[]) {
        String cadenaEncriptada;
        Cliente cliente = new Cliente();
        String algo = "ghash";
        if (algo.equals("ghash")) {
            cliente.setFactory(new FactoryGHash());
        } else if (algo.equals("khash")) {
            cliente.setFactory(new FactoryKHash());
        } else {
            System.out.println("No existe ese algoritmo");
        }
        cadenaEncriptada = cliente.encriptar("Hola");
        System.out.println(cadenaEncriptada);

    }

}
