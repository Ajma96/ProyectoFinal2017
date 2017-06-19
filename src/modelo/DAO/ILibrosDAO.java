package modelo.DAO;

import java.util.List;

public interface ILibrosDAO {
	
	List<Libro> getListaLibros();
	
	boolean addLibro(Libro libroNuevo);
	
	boolean borrarLibro(Libro libroParaBorrar);
	
	boolean estaLibroDisponible(String isbn);
	
}







