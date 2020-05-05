package AbstractFactoryBlog;

public class Articulo {
	String autor;
	String titulo;
	
	public Articulo(String _autor, String _titulo) {
		this.autor = _autor;
		this.titulo = _titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
