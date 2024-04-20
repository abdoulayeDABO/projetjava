package projetjava;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitaire {
	// Menu d'authentification
	public static void afficherAuthentificationMenu() {

		System.out.println();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
		Date date = new Date();
		System.out.println("#Aujourd'hui : " + formatter.format(date));
<<<<<<< HEAD
=======
		// System.out.println();
>>>>>>> origin/Samuel

		System.out.println("##########################################################");
		System.out.println("#                INTERFACE DE CONNEXION                  #");
		System.out.println("##########################################################");
		System.out.println();
		System.out.println(" (1) Se connecter");
		System.out.println(" (2) Quitter");
		System.out.println();
<<<<<<< HEAD
		System.out.print("Veuillez choisir une option : ");
=======
		System.out.print("> Veuillez choisir une option : ");
>>>>>>> origin/Samuel

	}

	public static boolean estAuthentifie(String login, String mdp, Statement s) {

		try {
			Connection con = ConnexionDB.ConnectDB();
			String sql = "SELECT * FROM employes WHERE login='" + login + "' and mdp='" + mdp + "'";
			ResultSet result = s.executeQuery(sql);
			if (!result.next()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Menu d'administration
	public static void afficherAdministrationMenu() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
		Date date = new Date();
		System.out.println("\n");
		System.out.println("# Aujourd'hui : " + formatter.format(date));
		System.out.println("##########################################################");
		System.out.println("#                INTERFACE D'ADMINISTRATION              #");
		System.out.println("##########################################################");
		System.out.println();
		System.out.println();
		// Options
<<<<<<< HEAD
		System.out.println("==========================================================");
		System.out.println("                     GESTION DES EMPLOYES                 ");
		System.out.println("==========================================================");
		System.out.println(" (1) Ajouter un nouveau compte employé");
=======
		System.out.println("----------------------------------------------------------");
		System.out.println("|                    GESTION DES EMPLOYES                |");
		System.out.println("----------------------------------------------------------");
		System.out.println(" (1) Ajouter un nouveau compte employé");
		// System.out.println(" (2) Editer un employé");
>>>>>>> origin/Samuel
		System.out.println(" (2) Supprimer un compte employé");
		System.out.println(" (3) Afficher la liste des employés et leurs informations");
		System.out.println(" (4) Afficher les informations d'un employe");
		System.out.println(" (5) Afficher le salaire moyen des employés");
		System.out.println();
<<<<<<< HEAD
		System.out.println("==========================================================");
		System.out.println("                     GESTION DES ARTICLES                 ");
		System.out.println("==========================================================");
=======
		System.out.println("----------------------------------------------------------");
		System.out.println("|                    GESTION DES ARTICLES                |");
		System.out.println("----------------------------------------------------------");
>>>>>>> origin/Samuel
		System.out.println(" (6)  Ajouter un nouvel article");
		System.out.println(" (7)  Supprimer un article");
		System.out.println(" (8)  Afficher tous les articles");
		System.out.println(" (9)  Faire l'approvionnement d'un article");
		System.out.println(" (10) Procéder à la vente d'un article");
<<<<<<< HEAD
		System.out.println(" (0) Quitter");
		System.out.println();
		System.out.print("Veuillez choisir une option : ");
=======
		// System.out.println(" (5) Imprimer le reçu de paiement d'un employé");
		// System.out.println(" (6) Afficher des statistiques de l'entreprise");
		System.out.println(" (0) Quitter");
		System.out.println();
		System.out.print("> Veuillez choisir une option : ");
>>>>>>> origin/Samuel

	}

	public static void afficherEmployeMenu() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
		Date date = new Date();
		System.out.println("\n");
		System.out.println("# Aujourd'hui : " + formatter.format(date));
		System.out.println("##########################################################");
		System.out.println("#                  INTERFACE UTILISATEUR                 #");
		System.out.println("##########################################################");
		System.out.println();
		// Options
		System.out.println(" (1) Afficher mes informations");
		System.out.println(" (2) Afficher ma fiche de paie");
		System.out.println(" (3) Supprimer mon compte"); // Penser à déconnecter l'utilisateur
		System.out.println(" (4) Réinitialiser mon mot de passe");
		System.out.println(" (0) Quitter");
		System.out.println();
<<<<<<< HEAD
		System.out.print("Veuillez choisir une option : ");
=======
		System.out.print("> Veuillez choisir une option : ");
>>>>>>> origin/Samuel

	}

	public static void initialiserEmploye(ResultSet result, Employe E) throws SQLException {
<<<<<<< HEAD
	
=======
		// result.next();
		// System.out.println("id=" + result.getString(1));
>>>>>>> origin/Samuel
		String id = result.getString(1);
		String nom = result.getString(2);
		String prenom = result.getString(3);
		String login = result.getString(4);
		String mdp1 = result.getString(5);
		String tel = result.getString(6);
		double salaire = result.getDouble(7);
		String annee = result.getString(8);
		String poste = result.getString(9);
		E.setEmployeId(id);
		E.setNom(nom);
		E.setPrenom(prenom);
		E.setLogin(login);
		E.setMdp(mdp1);
		E.setNumTel(tel);
		E.setSalaire(salaire);
		E.setAnneeService(annee);
		E.setPoste(poste);
<<<<<<< HEAD
		
=======
		// E = new Employe(id, nom, prenom, login, mdp1, tel, salaire, annee, poste);
		// System.out.println(E.getAnneeService() + " " + E.getEmployeId());
>>>>>>> origin/Samuel
	}
=======
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilitaire {
  // Menu d'authentification
	 public static void afficherAuthentificationMenu() {
	 System.out.println();
	 SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
	 Date date = new Date();
	 System.out.println("#Aujourd'hui : " + formatter.format(date));
	 //System.out.println();
	 System.out.println("##########################################################");
	 System.out.println("#                INTERFACE DE CONNEXION                  #");
	 System.out.println("##########################################################");
	 System.out.println();
	 System.out.println(" (1) Se connecter");
	 System.out.println(" (2) Quitter");
	 System.out.println();
	 System.out.print("> Veuillez choisir une option : ");
	 }

  // Menu d'administration
  public static void afficherAdministrationMenu() {
	SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
	Date date = new Date();
	System.out.println("\n");
	System.out.println("# Aujourd'hui : " + formatter.format(date));
	System.out.println("##########################################################");
	System.out.println("#                INTERFACE D'ADMINISTRATION              #");
	System.out.println("##########################################################");
	System.out.println();
	// Options
	System.out.println(" (1) Ajouter un employé");
	System.out.println(" (2) Editer un employé");
	System.out.println(" (3) Supprimer un employé");
	System.out.println(" (4) Afficher la liste de tous les employés");
	System.out.println(" (5) Chercher un employe	");
	System.out.println(" (6) Imprimer le reçu de paiement d'un employé");
	System.out.println(" (7) Afficher des statistiques de l'entreprise");
	System.out.println(" (8) Quitter");
	System.out.println();
	System.out.print("> Veuillez choisir une option : ");
  }
  
  public static Employe demanderInfosEmploye() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("> Entrez le prénom de l'employé : ");
	    String prenom = scanner.nextLine();

	    System.out.print("> Entrez le nom de l'employé : ");
	    String nom = scanner.nextLine();

	    System.out.print("> Entrez l'identifiant de l'employé : ");
	    String employeId = scanner.nextLine();

	    System.out.print("> Entrez le numéro de téléphone de l'employé : ");
	    String numTel = scanner.nextLine();

	    System.out.print("> Entrez l'adresse email de l'employé : ");
	    String email = scanner.nextLine();

	    System.out.print("> Entrez le salaire de l'employé : ");
	    double salaire = scanner.nextDouble();
	    scanner.nextLine(); // Consomme le retour chariot restant
	    
	    String mdp = "passer";

	    System.out.print("> Entrez la fonction de l'employé : ");
	    String fonction = scanner.nextLine();
	    
	 // Création de l'employé à partir des informations saisies
	    Employe employe = new Employe(employeId, prenom, nom, numTel, email, mdp, salaire, fonction);
		return employe;
	}

>>>>>>> 7702d09c08c37da27c3f69f7c8dc4c3349e996fc
}
