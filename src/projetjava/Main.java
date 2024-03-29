package projetjava;

import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
//	  System.out.println("Hello World!");
//    Utilitaire.afficherAuthentificationMenu();
//    Utilitaire.afficherAdministrationMenu();
	  
	  int choix;
	  boolean is_authenticated = false;
	  Scanner scanner = new Scanner(System.in);
      do {
    	  Utilitaire.afficherAuthentificationMenu();
          choix = scanner.nextInt();
          switch (choix) {
              case 1:
            	  System.out.println();
            	  System.out.println("##########################################################");
            	  System.out.println("#                  AUTHENTIFICATION                      #");
            	  System.out.println("##########################################################");
            	  System.out.println();
            	  System.out.print("> Entrer le Login: ");
              	  String login = scanner.next();
				  System.out.print("> Entrer le Mot de passe: ");
				  String password = scanner.next();
				  is_authenticated = Administrateur.authentifier(login, password);
				  if(is_authenticated) {
				    System.out.println("Succes: Authentification reussie.");
				  }else {
				    System.out.println("Erreur: Oops! Login ou mot de passe incorect.\n");
				  }
                  break;
              case 2: System.out.println("Merci d'avoir utilisé notre application. Au revoir !"); break;
              default: System.out.println("Choix invalide. Veuillez sélectionner une option valide."); break;
          }
          
      } while (choix != 2 && !is_authenticated ); 
      
      Employe employe = new Employe();
      while (true) {
     	 // Afficher l'interface d'administration apres une connexion reussie.                 
    	 Utilitaire.afficherAdministrationMenu();
      	choix = scanner.nextInt();
      	scanner.nextLine();
      	  	
      	if(choix == 1) {  
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                ENREGISTREMENT D'UN EMPLOYE             #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   	        employe = Utilitaire.demanderInfosEmploye();
      		Administrateur.ajouterEmploye(employe);
      	}
      	
      	if(choix == 2 ) {
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                  EDITION D'UN EMPLOYE                  #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   	        employe = Utilitaire.demanderInfosEmploye();
   	        Administrateur.editerEmploye(employe);
      	}
      	if(choix == 3) {  
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                  SUPPRESSION D'UN EMPLOYE              #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   			System.out.print("Entrez l'identifiant de l'employé à supprimer : ");
   			String employeId = scanner.nextLine();
      		Administrateur.supprimerEmploye(employeId);
      	}
      	
   
      	if(choix == 4) {
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                   LISTES DES EMPLOYES                  #");
   	        System.out.println("##########################################################");
   	        System.out.println();
      		Administrateur.afficherListEmploye();  
      	}
      	if(choix == 5) { 
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#               INFORMATIONS SUR L'EMPLOYE               #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   	        System.out.print("> Entrer l'Identifiant de l'employe: ");
	        String employeId = scanner.next();
      		Administrateur.afficherInfo(employeId);
      	
      	}
      	if(choix == 6) {
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                       RECU DE PAIEMENT                 #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   	        System.out.print("> Entrer l'Identifiant de l'employe: ");
   	        String employeId = scanner.next();
      		Administrateur.imprimerRecuPayement(employeId);
      	}
      	if(choix == 7) {
      		System.out.println();
      		System.out.println("##########################################################");
   	        System.out.println("#                       STATISTIQUE                      #");
   	        System.out.println("##########################################################");
   	        System.out.println();
   	        Administrateur.afficherStatistique();
      	}
      	
      	if(choix == 8) {
      		System.out.println("\t\t---# Merci d'avoir utilisé notre application. Au revoir ! #---");
      		break;
      	}
	
      }    
      
      scanner.close();
  }
}

