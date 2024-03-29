package projetjava;

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

}
