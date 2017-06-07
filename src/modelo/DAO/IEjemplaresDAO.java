package modelo.DAO;

import java.util.List;

public interface IEjemplaresDAO {

	List<Ejemplar> getListaEjemplares();
	
	boolean existenEjemplares(String ISBN);
	
	boolean getEjemplar(String ISBN);
	
	void addEjemplar(Ejemplar ejemplarNuevo);
	
	boolean borrarEjemplar(Ejemplar ejemplarParaBorrar);
}
