package modelo.DAO;

import java.util.List;

public interface IEjemplaresDAO {

	List<Ejemplar> getListaEjemplares();
	
	boolean existenEjemplares(String ISBN);
	
	boolean addEjemplar(Ejemplar ejemplarNuevo);
	
	boolean borrarEjemplar(Ejemplar ejemplarParaBorrar);
	
}






