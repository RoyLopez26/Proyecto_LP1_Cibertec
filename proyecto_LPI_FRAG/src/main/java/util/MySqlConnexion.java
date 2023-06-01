package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnexion {
	@SuppressWarnings("deprecation")
	public static Connection getConexion() {
		Connection con = null;
		try {
			//Cargar la libreria de conexion a BD de datos ya instalada
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Establecer la conexión
			String url = "jdbc:mysql://localhost:3306/BD_ITSDC?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}
}
