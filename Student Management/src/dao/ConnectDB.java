package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static String jdbcURL = "jdbc:mysql://localhost:3308/QLHV";
	private static String username = "root";
	private static String password = "";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected!");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = ConnectDB.getConnection();
	}

}
