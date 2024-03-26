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
              	   System.out.print("Login: ");
              	   String login = scanner.next();
                     System.out.print("Mot de passe: ");
                     String password = scanner.next();
                     is_authenticated = Administrateur.authentifier(login, password);
                     if(is_authenticated) {
                  	   System.out.println("Succes: Authentification reussie.");
                  	   // Afficher l'interface d'administration apres une connexion reussie.                 
                  	   Utilitaire.afficherAdministrationMenu();
                     }else {
                  	   System.out.println("Erreur: Oops! Login ou mot de passe incorect.\n");
                     }
                  break;
              case 2: System.out.println("Merci d'avoir utilisé notre application. Au revoir !"); break;
              default: System.out.println("Choix invalide. Veuillez sélectionner une option valide."); break;
          }
          
      } while (choix != 2 && !is_authenticated ); 
      scanner.close();
      
      Employe employe = new Employe();
      
      while (true) {
    	 Utilitaire.afficherAdministrationMenu();
      	choix = scanner.nextInt();
      	scanner.nextLine();
      	  	
      	if(choix == 1) {
      		System.out.println("");     		
      		System.out.println("##########################################################");
   	        System.out.println("#                ENREGISTREMENT D'UN EMPLOYE             #");
   	        System.out.println("##########################################################");
   	        System.out.print(" Prenom: ");
      	  	String 	prenom = scanner.nextLine();
      	  	System.out.print(" Nom: ");
      	    String 	nom = scanner.nextLine();
      	    System.out.print(" Telephone: ");
      	    String numTel = scanner.nextLine();
      	    System.out.print(" Email: ");
      	    String email = scanner.nextLine();
      	    //System.out.print(" Adresse: ");
      	    //String addr = scanner.nextLine();
      	    System.out.print(" Indentifiant: ");
      	    String uid = scanner.nextLine();  
      	    System.out.print(" Salaire: ");
      	    double salaire = scanner.nextDouble(); 
      	   
      	    employe.setPrenom(prenom);
      	    employe.setNom(nom);
      		employe.setEmployeId(uid);
      		employe.setEmail(email);
      		employe.setNumTel(numTel);
      		//employe.setAddr(addr);
      		employe.setSalaire(salaire);
      	    
      		Administrateur.ajouterEmploye(employe);
      		
      	}
      	if(choix == 2) Administrateur.supprimerEmploye(employe);  
      	if(choix == 3) Administrateur.editerEmploye(employe);
      	if(choix == 4) Administrateur.afficherListEmploye();  
      	if(choix == 5) Administrateur.afficherInfo(employe);
      	if(choix == 6) Administrateur.imprimerRecuPayement(employe);
      	
      	if(choix == 7) {
      		System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
      		break;
      	}
      	
      		
      }
      
      
		
  }
}

