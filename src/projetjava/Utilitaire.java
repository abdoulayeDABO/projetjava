package projetjava;

import java.text.SimpleDateFormat;
import java.util.Date;

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

//  public static void afficherAuthentificationMenu() {
//    System.out.println();
//    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy 'à' HH:mm");
//    Date date = new Date();
//    System.out.printf(" %s : %s%n", "Aujourd'hui", formatter.format(date));
//    System.out.println("----------------------------------------------------------");
//    System.out.println("                 INTERFACE DE CONNEXION");
//    System.out.println("----------------------------------------------------------");
//    System.out.println(" 1. Se connecter");
//    System.out.println(" 2. Quitter");
//    System.out.println();
//    System.out.print(" Veuillez choisir une option : ");
//}

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
	System.out.println(" (2) Supprimer un employé");
	System.out.println(" (3) Editer un employé");
	System.out.println(" (4) Afficher la liste de tous les employés");
	System.out.println(" (5) Afficher un employé");
	System.out.println(" (6) Imprimer le reçu de paiement d'un employé");
	System.out.println(" (7) Quitter");
	System.out.println();
	System.out.print("> Veuillez choisir une option : ");
  }
}
