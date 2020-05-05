package AbstractFactoryBlog;

public class Cliente {

    private Articulo art;
    private Publicacion pub;
    private FactoryPublicacion factory;

    public Cliente(String tipoArticulo, String autor, String tituloArticulo, String tituloRevista, FactoryPublicacion fac) {
        setFactory(fac);
        art = factory.crearArticulo(autor, autor);
        pub = factory.crearPublicacion(tituloArticulo);

    }

    public void setFactory(FactoryPublicacion factory) {
        this.factory = factory;
    }

    public Articulo getArt() {
        return art;
    }

    public Publicacion getPub() {
        return pub;
    }

    public static void main(String args[]) {
        Cliente cliente = new Cliente("Cientifico", "woods", "Foreign Forever", "Journal Migration", new FactoryCientifico());
        System.out.println(cliente.getArt().getClass().getName());
        System.out.println(cliente.getPub().getClass().getName());
    }

}
