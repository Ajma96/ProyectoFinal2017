package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import modelo.Repo.Conexion;

public class PrestamoDAO implements IPrestamosDAO {

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Prestamo> getListaPrestamos() {
		List<Prestamo> listaPrestamos = new ArrayList<>();
		String sql = "SELECT * FROM PRESTAMOS;";
		
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				String dni = resultSet.getString("DNI");
				String isbn = resultSet.getString("ISBN");
				String idEjemplar = resultSet.getString("ID_EJEMPLAR");
				LocalDate fechaPrestamo = pasarDeCadenaAFecha(resultSet.getString("FECHA_PRESTAMO"));
				
				Prestamo prestamo = new Prestamo(dni, isbn, idEjemplar, fechaPrestamo);
				listaPrestamos.add(prestamo);
			}
		}
		catch (SQLException e) {
			System.out.println("Error en la lectura de la DB");
		}
		
		return listaPrestamos;
	}

	@Override
	public boolean existenPrestamos(String dni, String isbn, String id_ejemplar) {
		String sql = "SELECT COUNT(DNI) FROM PRESTAMOS WHERE DNI = ? AND ISBN = ? AND ID_EJEMPLAR = ?;";
		boolean existenPrestamos = false;
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, dni);
			pStatement.setString(2, isbn);
			pStatement.setString(3, id_ejemplar);
			
			if(pStatement.executeUpdate() == 1)
				existenPrestamos = true;
		}
		catch (SQLException e) {
			System.out.println("Error buscando préstamo en la BD");
		}
		
		return existenPrestamos;
	}

	@Override
	public boolean addPrestamo(Prestamo nuevoPrestamo) {
		int resultado = 0;
		String sql = "INSERT INTO PRESTAMOS VALUES (?,?,?,?);";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			
			pStatement.setString(1, nuevoPrestamo.getDni());
			pStatement.setString(2, nuevoPrestamo.getIsbn());
			pStatement.setString(3, nuevoPrestamo.getIdEjemplar());
			pStatement.setString(4, nuevoPrestamo.getFechaPrestamo().toString());
			
			resultado = pStatement.executeUpdate();

		}
		catch (SQLException e) {
			System.out.println("Error en la inserción del prestamo");
		}
		
		return resultado != 0;
	}

	@Override
	public boolean actualizarPrestamo(Prestamo prestamo) {
		int resultado = 0;
		String sql = "ALTER TABLE PRESTAMOS SET FECHA_DEVUELTO = " +
				     "STRFTIME('%d/%m/%Y', (SUBSTR(DATETIME(CURRENT_TIMESTAMP, 'localtime'), 1, 10))) " + 
				     "WHERE DNI = ? AND ISBN = ? AND ID_EJEMPLAR = ? AND FECHA_DEVUELTO = NULL;";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			
			pStatement.setString(1, prestamo.getDni());
			pStatement.setString(2, prestamo.getIsbn());
			pStatement.setString(3, prestamo.getIdEjemplar());
			
			resultado = pStatement.executeUpdate();

		}
		catch (SQLException e) {
			System.out.println("Error actualizando prestamo");
		}
		
		return resultado == 0;
	}

	public static LocalDate pasarDeCadenaAFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}














