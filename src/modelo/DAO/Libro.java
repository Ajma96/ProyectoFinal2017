package modelo.DAO;

public class Libro implements Comparable<Libro>{
	
	private String isbn;
	private String titulo;
	private String autores;
	private String tematicas;
	
	
	public Libro(String isbn, String titulo, String autores, String tematicas) {
		this.isbn 		= isbn;
		this.titulo 	= titulo;
		this.autores 	= autores;
		this.tematicas 	= tematicas;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutores() {
		return autores;
	}


	public void setAutores(String autores) {
		this.autores = autores;
	}


	public String getTematicas() {
		return tematicas;
	}


	public void setTematicas(String tematicas) {
		this.tematicas = tematicas;
	}


	@Override
	public int compareTo(Libro o) {
		return isbn.compareTo(o.isbn);
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", tematicas=" + tematicas + "]";
	}
	
	
}







