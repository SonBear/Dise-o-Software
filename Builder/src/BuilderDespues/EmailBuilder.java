/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderDespues;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author emman
 */
public class EmailBuilder {

    private Set<String> destinatarios;
    private String titulo;
    private String mensaje;

    public EmailBuilder() {
        titulo = "";
        mensaje = "";
        destinatarios = new ConcurrentSkipListSet<>();
    }

    public EmailBuilder addDestinatario(String destinatario) {
        destinatarios.add(destinatario);
        return this;
    }

    public EmailBuilder addTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public EmailBuilder addSaludo(String saludo) {
        mensaje += saludo + "\n";
        return this;
    }

    public EmailBuilder addTexto(String texto) {
        mensaje += texto + "\n";
        return this;
    }

    public EmailBuilder addDespedida(String despedida) {
        mensaje += despedida + "\n";
        return this;
    }

    private String dest() {
        String a = destinatarios.toString();

        return a.substring(1, a.length() - 1);

    }

    public Email crearEmail() {
        String destinatarios = dest();

        return new Email(titulo, destinatarios, mensaje);
    }

}
