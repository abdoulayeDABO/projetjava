package projetjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnexionDB {
	public static Connection ConnectDB() {
		try {
			Properties p = new Properties();
			try (FileInputStream file = new FileInputStream("Config.properties")) {
				p.load(file);
			}
			String urlPilote = p.getProperty("jdbc.driver.class");
			Class.forName(urlPilote);
<<<<<<< HEAD
			String urlDB = p.getProperty("jdbc.url");
=======
//			System.out.println("Le pilote est bien charge");
			System.out.println("CHARGEMENT ...");
			String url = p.getProperty("jdbc.url");
>>>>>>> 7702d09c08c37da27c3f69f7c8dc4c3349e996fc
			String user = p.getProperty("jdbc.login");
			String password = p.getProperty("jdbc.password");
			Connection con = DriverManager.getConnection(urlDB, user, password);
			// System.out.println("Connexion établie");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
<<<<<<< HEAD
=======
		
>>>>>>> 7702d09c08c37da27c3f69f7c8dc4c3349e996fc
	}
}
