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

public class SocioDAO implements ISociosDAO {

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Socio> getListaSocios() {
		
		List<Socio> listaSocios = new ArrayList<>();
		String sql = "SELECT * FROM SOCIOS ORDER BY DNI;";
		
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				String dni = resultSet.getString("DNI");
				String nombre = resultSet.getString("NOMBRE");
				String apellidos = resultSet.getString("APELLIDOS");
				LocalDate fechaAlta = pasarDeCadenaAFecha(resultSet.getString("FECHA_ALTA"));
				
				Socio socio = new Socio(dni, nombre, apellidos, fechaAlta);
				listaSocios.add(socio);
			}
		}
		catch (SQLException e) {
			System.out.println("Error en la lectura de la DB");
		}
		
		return listaSocios;
	}

	@Override
	public boolean existeSocio(String dni) {
		
		String sql = "SELECT COUNT(DNI) FROM SOCIOS WHERE DNI = ?;";
		boolean existeSocio = false;
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, dni);
			
			if(pStatement.executeUpdate() == 1)
				existeSocio = true;
		}
		catch (SQLException e) {
			System.out.println("Error buscando socio en la BD");
		}
		
		return existeSocio;
	}

	@Override
	public boolean addSocio(Socio nuevoSocio) {
		
		int resultado = 0;
		String sql = "INSERT INTO SOCIOS VALUES (?,?,?,?);";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			
			pStatement.setString(1, nuevoSocio.getDni());
			pStatement.setString(2, nuevoSocio.getNombre());
			pStatement.setString(3, nuevoSocio.getApellidos());
			pStatement.setString(4, nuevoSocio.getFechaAlta().toString());
			
			resultado = pStatement.executeUpdate();

		}
		catch (SQLException e) {
			System.out.println("Error en la inserción del socio");
		}
		
		return resultado != 0;
	}

	@Override
	public boolean borrarSocio(Socio socioABorrar) {
		
		int resultado = 0;
		String sql = "DELETE FROM SOCIOS WHERE DNI = ?;";
		
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, socioABorrar.getDni());
			
			resultado = pStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Error borrando usuario");
		}
		
		return resultado != 0;
	}
	
	public static LocalDate pasarDeCadenaAFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static Object [][] listaAMatriz (List<Socio> lista) {
		
		Object [][] matriz = new Object [lista.size()][4];
			
			for (int i=0 ; i < lista.size() ; i++) {
				matriz[i][0] = lista.get(i).getDni();
				matriz[i][1] = lista.get(i).getNombre();
				matriz[i][2] = lista.get(i).getApellidos();
				matriz[i][3] = lista.get(i).getFechaAlta();
			}
		
		return matriz;	
	}

}









