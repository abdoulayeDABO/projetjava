package projetjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
//import java.util.Date;
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
 	        	  System.out.println("Operation reussie.\n\n");
         		  System.out.println("Employe enregistre avec success!");
        		} else {
         		  System.out.println("Erreur lors de l'ajout!");
         		}
 	        	
         } catch (Exception e) {
             System.err.println("Erreur lors de l'ajout: " + e.getMessage());
         }
         
    }    
    
    public static void afficherListEmploye() {
      
    }
    
    public static void afficherInfo(Employe employe) {
		try {
            Connection con = ConnexionDB.ConnectDB();
            String sql = "select * from employe_table where prenom =? and nom=?";
            PreparedStatement ps = con.prepareStatement(sql);
      
            ps.setString(1, employe.getPrenom());
        	ps.setString(2, employe.getNom());
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
            	  String empId = res.getString("employeId");
		          String nom = res.getString("nom");
		          String prenom = res.getString("prenom");
		          Double salaire = res.getDouble("salaire");
		          String adresse = res.getString("adresse");
		          String email = res.getString("email");
		          String numTel = res.getString("numTel");
		          
		          System.out.println("-------------------------------");
		          System.out.println("|  Informations de l'employé  |");
		          System.out.println("-------------------------------");

		      
		          System.out.println("     Prenom : \t" + prenom);
		          System.out.println("        Nom : \t" + nom );
		          System.out.println("Identifiant : \t" + empId);
		          System.out.println("      Email : \t" + email);
		          System.out.println("  Téléphone : \t" + numTel);
		          System.out.println("    Adresse : \t" + adresse);
		          // Salaire en vert avec deux chiffres après la virgule
		          System.out.printf("    Salaire : \t%s FCFA\n", String.format("%.2f", salaire) );
		         
	
		     }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
	public static void imprimerRecuPayement(Employe employe) {
				   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           Date date = new Date();
           
	    try {
	    	Connection con = ConnexionDB.ConnectDB();
	        String query = "SELECT * FROM employe_table WHERE prenom = ? AND nom = ?";
	        PreparedStatement myStmt = con.prepareStatement(query);
	        myStmt.setString(1, employe.getPrenom());
	        myStmt.setString(2, employe.getNom());
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
	            System.out.println("|              REÇU DE PAIEMENT                  |");
	            System.out.println("--------------------------------------------------");
	            System.out.println("            Employé:\t " + prenom + " " + nom );
	            System.out.println("         Téléphone :\t " + numTel);
	            System.out.println("             Email :\t " + email);	        
		        System.out.println("           Adresse :\t " + adresse);
	            System.out.println("    ID de l'employé:\t " + empId );
	            System.out.println("   Date de paiement:\t " + dateFormat.format(date));
	            System.out.println("--------------------------------------------------");
	            System.out.println(" Montant du salaire:\t " + salaire + " XOF");
	            System.out.println("--------------------------------------------------");
	        } else {
	            System.out.println("Aucun employé trouvé avec les informations fournies.");
	        }
	
	        res.close();
	        myStmt.close();
	        con.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		 
	}

	public static void supprimerEmploye(Employe employe) {
		// TODO Auto-generated method stub
		
	}
	
	public static void editerEmploye(Employe employe) {
		// TODO Auto-generated method stub
		
	}

}
