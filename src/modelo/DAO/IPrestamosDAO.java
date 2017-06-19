package modelo.DAO;

import java.util.List;

public interface IPrestamosDAO {

	List<Prestamo> getListaPrestamos();
	
	boolean existenPrestamos(String dni, String isbn, String id_ejemplar);
	
	boolean addPrestamo(Prestamo nuevoPrestamo);
	
	boolean actualizarPrestamo(Prestamo prestamo);
	
}







