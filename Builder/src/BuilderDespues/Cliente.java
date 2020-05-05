package BuilderDespues;

public class Cliente {

    public Cliente() {
        String destinatario = "gortiz@uady.mx";
        String destinatario2 = "jgarcila@yahoo.com";
        String saludo = "Hola Juan";
        String texto = "Favor de calificar las ADA's de Diseño";
        String despedida = "Saludos y Gracias";
        String tituloCorreo = "Seguimiento a Diseño Software";

        EmailBuilder builder = new EmailBuilder();
        Email email = builder.addTitulo(tituloCorreo).addSaludo(saludo)
                .addTexto(texto).addDespedida(despedida).addDestinatario(destinatario)
                .addDestinatario(destinatario2).crearEmail();
        System.out.println(email);
    }

    public static void main(String[] args) {
        new Cliente();
    }

}
