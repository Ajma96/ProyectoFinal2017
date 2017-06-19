package modelo.DAO;

public class Ejemplar implements Comparable<Ejemplar>{
	private int idEjemplar;
	private String isbn;
	private String editorial;
	private int edicion;
	
	
	public Ejemplar(int idEjemplar, String isbn, String editorial, int edicion) {
		this.idEjemplar = idEjemplar;
		this.isbn 		= isbn;
		this.editorial 	= editorial;
		this.edicion 	= edicion;
	}


	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}


	@Override
	public String toString() {
		return "Ejemplar [idEjemplar=" + idEjemplar + ", isbn=" + isbn + ", editorial=" + editorial + ", edicion="
				+ edicion + "]";
	}


	@Override
	public int compareTo(Ejemplar o) {
		return idEjemplar + "".compareTo(o.idEjemplar + "");
	}
	
}







