package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String sql = "SELECT * FROM LIBROS;";
		
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				String isbn = resultSet.getString("ISBN");
				String titulo = resultSet.getString("TITULO");
				String autores = resultSet.getString("AUTORES");
				String tematicas = resultSet.getString("TEMATICAS");
				
				Libro libro = new Libro(isbn, titulo, autores, tematicas);
				listaLibros.add(libro);
			}
		}
		catch (SQLException e) {
			System.out.println("Error en la búsqueda de libros");
		}
		
		return listaLibros;
	}
	
	@Override
	public boolean estaLibroDisponible(String isbn) {
		
		String sql = "SELECT COUNT(ISBN) FROM LIBROS WHERE ISBN = ?;";
		boolean libroDisponible = false;
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, isbn);
			
			if(pStatement.executeUpdate() == 1)
				libroDisponible = true;
		}
		catch (SQLException e) {
			System.out.println("Error buscando libro en la BD");
		}
		
		return libroDisponible;
	}

	@Override
	public boolean addLibro(Libro libroNuevo) {
		
		int resultado = 0;
		String sql = "INSERT INTO LIBROS VALUES (?,?,?,?);";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
					
			pStatement.setString(1, libroNuevo.getIsbn());
			pStatement.setString(2, libroNuevo.getTitulo());
			pStatement.setString(3, libroNuevo.getAutores());
			pStatement.setString(4, libroNuevo.getTematicas());
					
			resultado = pStatement.executeUpdate();

		}
		catch (SQLException e) {
			System.out.println("Error en la inserción del libro");
		}
				
		return resultado != 0;
	}

	@Override
	public boolean borrarLibro(Libro libroParaBorrar) {
		
		int resultado = 0;
		String sql = "DELETE FROM LIBROS WHERE ISBN = ?;";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, libroParaBorrar.getIsbn());
			
			resultado = pStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Error borrando libro");
		}
		
		return resultado != 0;
	}

	public static Object [][] listaAMatriz (List<Libro> lista) {
		
		Object [][] matriz = new Object [lista.size()][4];
			
			for (int i=0 ; i < lista.size() ; i++) {
				matriz[i][0] = lista.get(i).getIsbn();
				matriz[i][1] = lista.get(i).getTitulo();
				matriz[i][2] = lista.get(i).getAutores();
				matriz[i][3] = lista.get(i).getTematicas();
			}
		
		return matriz;	
	}
	
}






