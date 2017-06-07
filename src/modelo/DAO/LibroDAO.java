package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Repo.Conexion;

public class LibroDAO implements ILibrosDAO {

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Libro> getListaLibros() {
		List<Libro> listaLibros = new ArrayList<>();
		String sql = "SELECT * FROM SOCIOS ORDER BY DNI;";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				String isbn = resultSet.getString("ISBN");
				String titulo = resultSet.getString("TITULO");
				String autores = resultSet.getString("AUTORES");
				String tematicas = resultSet.getString("TEMATICAS");
				Libro libro = new Libro(isbn, titulo, autores, tematicas);
				listaLibros.add(libro);
			}
		}
		catch (SQLException e) {
			System.out.println("Error en la busqueda de lista de libros");
		}
		return listaLibros;
	}

	@Override
	public boolean addLibro(Libro libroNuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarLibro(Libro libroParaBorrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaLibroDisponible(String isbn) {
		
		return false;
	}

}
