package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Repo.Conexion;

public class EjemplarDAO implements IEjemplaresDAO{

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Ejemplar> getListaEjemplares() {
		List<Ejemplar> listaEjemplares = new ArrayList<>();
		String sql = "SELECT * FROM EJEMPLARES ORDER BY ID_EJEMPLAR;";
		
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				int idEjemplar = resultSet.getInt("ID_EJEMPLAR"); //Autoid
				String isbn = resultSet.getString("ISBN");
				String editorial = resultSet.getString("EDITORIAL");
				int edicion = resultSet.getInt("EDICION");
				
				Ejemplar ejemplar = new Ejemplar(idEjemplar, isbn, editorial, edicion);
				listaEjemplares.add(ejemplar);
			}
		}
		catch (SQLException e) {
			System.out.println("Error en la busqueda de lista de libros");
		}
		
		return listaEjemplares;
	}
	
	@Override
	public boolean existenEjemplares(String ISBN) {
		String sql = "SELECT COUNT(ID_EJEMPLAR) FROM EJEMPLARES WHERE ISBN = ?;";
		boolean existenEjemplares = false;
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, ISBN);
			
			if(pStatement.executeUpdate() > 0)
				existenEjemplares = true;
		}
		catch (SQLException e) {
			System.out.println("Error buscando ejemplares del libro");
		}
		
		return existenEjemplares;
	}

	@Override
	public boolean addEjemplar(Ejemplar ejemplarNuevo) {
		int resultado = 0;
		String sql = "INSERT INTO EJEMPLARES VALUES (?,?,?,?);";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
					
			pStatement.setInt(1, ejemplarNuevo.getIdEjemplar());
			pStatement.setString(2, ejemplarNuevo.getIsbn());
			pStatement.setString(3, ejemplarNuevo.getEditorial());
			pStatement.setInt(4, ejemplarNuevo.getEdicion());
					
			resultado = pStatement.executeUpdate();

		}
		catch (SQLException e) {
			System.out.println("Error en la inserción de ejemplar");
		}
				
		return resultado != 0;
	}

	@Override
	public boolean borrarEjemplar(Ejemplar ejemplarParaBorrar) {
		int resultado = 0;
		String sql = "DELETE FROM EJEMPLARES WHERE ISBN = ? AND ID_EJEMPLAR = ?;";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, ejemplarParaBorrar.getIsbn());
			pStatement.setInt(2, ejemplarParaBorrar.getIdEjemplar());
			
			resultado = pStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Error borrando ejemplar");
		}
		
		return resultado != 0;
	}

}







