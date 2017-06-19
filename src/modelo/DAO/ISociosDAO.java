package modelo.DAO;

import java.util.List;

public interface ISociosDAO {
	
	List<Socio> getListaSocios();
	
	boolean existeSocio(String DNI);
	
	boolean addSocio(Socio nuevoSocio);
	
	boolean borrarSocio(Socio socioABorrar);
	
}







