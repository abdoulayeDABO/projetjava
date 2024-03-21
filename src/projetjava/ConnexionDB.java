package projetjava;

import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.sql.*;
import java.util.Properties;


public class ConnexionDB {

	public static Connection ConnectDB() throws SQLException, ClassNotFoundException {
		try {
			Properties p = new Properties();
			try (FileInputStream file = new FileInputStream("Config.properties")) {
				p.load(file);
			}
			String urlPilote = p.getProperty("jdbc.driver.class");
			Class.forName(urlPilote);
//			System.out.println("Le pilote est bien charge");
			System.out.println("... Chargement");
			String url = p.getProperty("jdbc.url");
			String user = p.getProperty("jdbc.login");
			String password = p.getProperty("jdbc.password");
			Connection con = DriverManager.getConnection(url, user, password);
//			System.out.println("Connexion etablie");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
//		String urlPilote = "com.mysql.cj.jdbc.Driver";
//		Class.forName(urlPilote);
//		System.out.println("Le pilote est bien charge");
//		String url = "jdbc:mysql://localhost:3306/banque";
//		String user = "root";
//		String password = "kaliuser";
//		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("Connexion etablie");
//		return con;
	}

//	public static void main(String args[]) throws Exception {
//		Connection con = ConnectDB();
//		Statement s = con.createStatement();
//		ResultSet res = s.executeQuery("select * from client");
//		while (res.next()) {
//			System.out.println(res.getInt(1)+ "\t" + res.getString(2));
//		}
//	}
}
