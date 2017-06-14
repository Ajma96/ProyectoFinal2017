package modelo.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion = null;
	
	private Conexion(){
		try {
			Class.forName("org.sqlite.JDBC");
			
			try {
				conexion = DriverManager.getConnection("jdbc:sqlite:BD/biblioteca.db");
			}
			catch (SQLException e) {
				System.out.println("Error en el acceso a la BD");
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("No se encuentra jdbc");
		}
	}
	
	public static Connection getInstance(){
		if (conexion == null) {
			new Conexion();
		}
		return conexion;
	}
	
	public static void main(String[] args) {
		Conexion.getInstance();
	}
}