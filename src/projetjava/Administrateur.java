package projetjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Date;
import java.util.Date;

import utilitaires.ConnexionDB;

import java.text.SimpleDateFormat;


public class Administrateur {
   

	public static boolean authentifier(String login, String mdp) {
		 try {
	            Connection con = ConnexionDB.ConnectDB();
	            String sql = "SELECT * FROM administrateurs WHERE login=? and password=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, login);
	            ps.setString(2, mdp);
	            ResultSet res = ps.executeQuery();
	            if (!res.next()) {
	              return false;
	            }
	            return true;
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }   
 
    public static void ajouterEmploye(Employe employe) {
   
    	 try {
             Connection con = ConnexionDB.ConnectDB();
         	
 	        	String sql = "INSERT INTO employe_table (prenom, nom, employeId, email, numTel, salaire) VALUES (?, ?, ?, ?, ?, ?)";
 	        	PreparedStatement ps = con.prepareStatement(sql);
 	
 	        	// Set values using setters in PreparedStatement
 	        	ps.setString(1, employe.getPrenom());
 	        	ps.setString(2, employe.getNom());
 	        	ps.setString(3, employe.getEmployeId());
 	        	ps.setString(4, employe.getEmail());
 	        	ps.setString(5, employe.getNumTel());
 	        	ps.setDouble(6, employe.getSalaire());
 	        	
 	        	int rowsAffected  = ps.executeUpdate();
        		if (rowsAffected > 0) {
         		  System.out.println("Opération réussie: Employe enregistre avec success!");
        		} else {
         		  System.out.println("Erreur lors de l'ajout!");
         		}
 	        	
         } catch (Exception e) {
             System.err.println("Erreur lors de l'ajout: ");
         }
         
    }    
    
    public static void afficherListEmploye() {
    	try {
            Connection con = ConnexionDB.ConnectDB();
            Statement s = con.createStatement();
            ResultSet res = s.executeQuery("select * from employe_table");
            
	    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
	    	System.out.println("| ID       | Prenom            | Nom        | Email                     | Tel          | Adresse           | Fonction        | Salaire XOF      |");
	    	System.out.println("-----------+-------------------+------------+---------------------------+--------------+-------------------+-----------------+-------------------");
//	    	System.out.println("-----------+-------------------+------------+---------------------------+--------------+-------------------+-----------------+-------------------");

	    	while (res.next()) {
	    	    String prenom = res.getString("prenom");
	    	    String nom = res.getString("nom");
	    	    String empId = res.getString("employeId");
	    	    Double salaire = res.getDouble("salaire");
	    	    String email = res.getString("email");
	    	    String numTel = res.getString("numTel");
	    	    String adresse = res.getString("adresse");
	    	    String fonction = res.getString("fonction");
	
	    	    System.out.printf("| %-8s |", empId);
	    	    System.out.printf(" %-17s |", prenom);
	    	    System.out.printf(" %-10s |", nom);
	    	    System.out.printf(" %-25s |", email);
	    	    System.out.printf(" %-12s |", numTel);
	    	    System.out.printf(" %-17s |", adresse);
	    	    System.out.printf(" %-15s |", fonction);
	    	    System.out.printf(" %-16f |\n", salaire);
		    	System.out.println("-----------+-------------------+------------+---------------------------+--------------+-------------------+-----------------+-------------------");

	
	    		}
	    	
		   } catch (Exception e) {
			   System.out.println("Erreur lors de l'affichage de la liste des employés.");
//		       e.printStackTrace();
	   }
    }
    
    public static void afficherInfo(String vId) {
		try {
            Connection con = ConnexionDB.ConnectDB();
            String sql = "select * from employe_table where employeId =? ";
            PreparedStatement ps = con.prepareStatement(sql);
      
            ps.setString(1, vId);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
            	  String empId = res.getString("employeId");
		          String nom = res.getString("nom");
		          String prenom = res.getString("prenom");
		          Double salaire = res.getDouble("salaire");
		          String adresse = res.getString("adresse");
		          String email = res.getString("email");
		          String numTel = res.getString("numTel");
		          
		          System.out.println("-------------------------------------");
		          System.out.println("         Informations de l'employé   ");
		          System.out.println("-------------------------------------");
		          System.out.println("     Prenom : \t" + prenom);
		          System.out.println("        Nom : \t" + nom );
		          System.out.println("Identifiant : \t" + empId);
		          System.out.println("      Email : \t" + email);
		          System.out.println("  Téléphone : \t" + numTel);
		          System.out.println("    Adresse : \t" + adresse);
		          // Salaire avec deux chiffres après la virgule
		          System.out.printf("    Salaire : \t%s FCFA\n", String.format("%.2f", salaire) );
		          System.out.println("-------------------------------------");
		         
	
		     }
        } catch (Exception e) {
//            e.printStackTrace();
	    	System.out.println("Erreur: veuillez réessayer.");
        }
    }
 
	public static void imprimerRecuPayement(String vId) {
				   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           Date date = new Date();
           
	    try {
	    	Connection con = ConnexionDB.ConnectDB();
	        String query = "SELECT * FROM employe_table WHERE employeID = ?";
	        PreparedStatement myStmt = con.prepareStatement(query);
	        myStmt.setString(1, vId);
	        ResultSet res = myStmt.executeQuery();
	
	        
	        if (res.next()) {
	            
	            String empId = res.getString("employeId");
	            String prenom = res.getString("prenom");
	            String nom = res.getString("nom");
	            String numTel = res.getString("numTel");
	            double salaire = res.getDouble("salaire");
	            String adresse = res.getString("adresse");
		        String email = res.getString("email");
	
	            System.out.println("--------------------------------------------------");
	            System.out.println("               REÇU DE PAIEMENT                   ");
	            System.out.println("--------------------------------------------------");
	            System.out.println("            Employé:\t " + prenom + " " + nom );
	            System.out.println("         Téléphone :\t " + numTel);
	            System.out.println("             Email :\t " + email);	        
		        System.out.println("           Adresse :\t " + adresse);
	            System.out.println("    ID de l'employé:\t " + empId );
	            System.out.println("   Date de paiement:\t " + dateFormat.format(date));
	            System.out.println(" Montant du salaire:\t " + salaire + " XOF");
	            System.out.println("--------------------------------------------------");
	        } else {
	            System.out.println("Aucun employé trouvé avec les informations fournies.");
	        }
	
	        res.close();
	        myStmt.close();
	        con.close();
	        
	    } catch (Exception e) {
//	        e.printStackTrace();
	    	System.out.println("Erreur: veuillez réessayer.");
	    }
		 
	}

	public static void supprimerEmploye(String employeId) {

		try {
		    Connection connection = ConnexionDB.ConnectDB();
		    String sql = "DELETE FROM employe_table WHERE employeId = ?";
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setString(1, employeId);

		    int rowsAffected = statement.executeUpdate();

		    if (rowsAffected > 0) {
		        System.out.println("Succès: L'employé a été supprimé avec succès!");
		    } else {
		        System.err.println("Erreur: Aucun employé trouvé avec l'identifiant fourni.");
		    }

		} catch (Exception e) {
		    System.err.println("Erreur lors de la suppression de l'employé : " + e.getMessage());
		}
		
	}
	
	public static void editerEmploye(Employe employe) {

	    Connection connection = null;
	    try {
	    	// Connexion a la base de donnee.
	    	connection = ConnexionDB.ConnectDB();
	    	
	        String sql = "UPDATE employe_table "
	                + "SET prenom = ?, nom = ?, numTel = ?, email = ?, adresse = ?, salaire = ?, fonction = ?"
	                + " WHERE  employeId = ?";

	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, employe.getPrenom());
	        statement.setString(2, employe.getNom());
	        statement.setString(3, employe.getNumTel());
	        statement.setString(4, employe.getEmail());
	        statement.setString(5, employe.getAdresse());
	        statement.setDouble(6, employe.getSalaire());
	        statement.setString(7, employe.getFonction());
	        statement.setString(8, employe.getEmployeId());

	        statement.executeUpdate();
	        System.out.println("Succès: L'employé a été mis à jour avec succès!");
	       
	        // Fermeture des ressources
	        statement.close();
	        connection.close();
	        

	    } catch (Exception e) {
//	        e.printStackTrace();
	        System.err.println("Erreur: Échec de la mise à jour de l'employé. Veuillez vérifier les informations fournies.");
	    } 
	}


	public static void afficherStatistique() {

	    try{
	    	Connection connection = ConnexionDB.ConnectDB();
		    String sqlNbEmployes = "SELECT COUNT(*) FROM employe_table";
		    String sqlSalaireMoyen = "SELECT AVG(salaire) FROM employe_table";
		    String sqlTotalSalaire = "SELECT SUM(salaire) FROM employe_table";
		    
		    Statement statement = connection.createStatement();
	        ResultSet resultSetNbEmployes = statement.executeQuery(sqlNbEmployes);
	        resultSetNbEmployes.next();
	        int nbEmployes = resultSetNbEmployes.getInt(1);
	        resultSetNbEmployes.close();

	        ResultSet resultSetSalaireMoyen = statement.executeQuery(sqlSalaireMoyen);
	        resultSetSalaireMoyen.next();
	        double salaireMoyen = resultSetSalaireMoyen.getDouble(1);
	        resultSetSalaireMoyen.close();

	        ResultSet resultSetTotalSalaire = statement.executeQuery(sqlTotalSalaire);
	        resultSetTotalSalaire.next();
	        double totalSalaire = resultSetTotalSalaire.getDouble(1);
	        resultSetTotalSalaire.close();

	        System.out.println("\t\t Statistiques de l'entreprise ");
	        System.out.println("----------------------------------------------------");
	        System.out.printf("\t  Nombre d'employés : %d\n", nbEmployes);
	        System.out.printf("\t      Salaire moyen : %.2f XOF\n", salaireMoyen);
	        System.out.printf("\t Total des salaires : %.2f XOF\n", totalSalaire);
	        System.out.println("----------------------------------------------------");
	    } catch (Exception e) {
	        System.err.println("Erreur lors de l'affichage des statistiques : ");
	    }
	}

	
	



}
