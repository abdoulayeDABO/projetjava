package projetjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Fonctionnalite {

	// Pas besoin de classe puisqu'onn manipule une base de données. De simples

	public static void CreerEmploye(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("Donner l'identifiant de l'employé: ");
		String id = scan.next();
		System.out.print("Donner le nom de l'employé: ");
		String name = scan.next();
		scan.nextLine();
		System.out.print("Donner le prenom de l'employé: ");
=======
		System.out.println("> Donner l'identifiant de l'employé");
		String id = scan.next();
		System.out.println("> Donner le nom de l'employé");
		String name = scan.next();
		scan.nextLine();
		System.out.println("> Donner le prenom de l'employé");
>>>>>>> origin/Samuel
		String firstname = scan.next();
		String login;
		boolean bool = true;
		do {
<<<<<<< HEAD
			System.out.print("Veuillez saisir un nouveau login: ");
=======
			System.out.println("> Veuillez saisir un nouveau login");
>>>>>>> origin/Samuel
			login = scan.next();
			ResultSet result = s.executeQuery("SELECT * FROM employes WHERE login='" + login + "'");
			if (result.next()) {
				bool = false;
				System.out.println("Login déjà utilisé");
			} else {
				bool = true;
			}

		} while (!bool);
<<<<<<< HEAD
		System.out.print("Définir le mot de passe de l'employé (*n'y mettez pas d'espace): ");
		String mdp = scan.next();
		scan.nextLine();
		System.out.print("Donnez le numero de telephone de l'employe: ");
		String tel = scan.nextLine();
		String serviceDate;
		System.out.print("Donner l'année d'entrée dans le service: ");
		serviceDate = scan.next();
		scan.nextLine();
		System.out.print("Donnez la fonction occupée par l'employé: ");
		String poste = scan.nextLine();
		double salary;
		do {
			System.out.print("Saisir le salaire de lemployé: ");
=======
		System.out.println("> Définir le mot de passe de l'employé (*n'y mettez pas d'espace)");
		String mdp = scan.next();
		scan.nextLine();
		System.out.println("> Donnez le numero de telephone de l'employe");
		String tel = scan.nextLine();
		String serviceDate;
		System.out.println("> Donner l'année d'entrée dans le service");
		serviceDate = scan.next();
		scan.nextLine();
		System.out.println("> Donnez la fonction occupée par l'employé");
		String poste = scan.nextLine();
		double salary;
		do {
			System.out.println("> Saisir le salaire de lemployé");
>>>>>>> origin/Samuel
			salary = scan.nextDouble();
		} while (salary <= 0);
		int re = s.executeUpdate("insert into employes(id,nom,prenom,login,mdp,tel,salaire,annee,poste) values('" + id
				+ "','" + name + "','" + firstname + "','" + login + "','" + mdp + "','" + tel + "'," + salary + ",'"
				+ serviceDate + "','" + poste + "')");

		if (re != 0) {
<<<<<<< HEAD
			System.out.println("# Insertion réussie #");
		} else {
			System.out.println("# Opération échouée #");
=======
			System.out.println("> Insertion réussie");
		} else {
			System.out.println("> Opération échouée");
>>>>>>> origin/Samuel
		}

	}

	// AFFICHAGE DES EMPLOYES PAR l'ADMIN
	public static void printEmployes(Statement s) throws SQLException {
		ResultSet result = s.executeQuery("select * from employes");
<<<<<<< HEAD
		while (result.next()) {
	
			// Affichage de l'en-tête du tableau
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");
			System.out.println("|  ID    |        Nom          |       Prénom        |     Login        |     Téléphone      |      Salaire      |  Année Intégration |       Poste         |");
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");

			// Boucle pour afficher chaque ligne du tableau
			while (result.next()) {
			    System.out.printf("| %-6s | %-19s | %-19s | %-16s | %-18s | %-17.2f | %-18s | %-18s  |\n",
			            result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(6),
			            result.getDouble(7), result.getString(8), result.getString(9));
			}

			// Affichage du bas du tableau
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");

=======
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18s %-20s %-19s%n", "Identifiant", "Nom ", "Prénom",
				"Login", "Mot de passe", "Telephone", "Salaire", "AnnéeIntégration", "Poste");
		while (result.next()) {
			System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18.2f %-20s %-20s%n", result.getString(1),
					result.getString(2), result.getString(3), result.getString(4), "*****", result.getString(6),
					result.getDouble(7), result.getString(8), result.getString(9));
>>>>>>> origin/Samuel

		}

	}

	// AFFICHAGE DES INFORMATIONS D'UN EMPLOYE
	public static void printEmploye(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("Donner le login de l'employe: ");
		String login = scan.next();
		ResultSet result = s.executeQuery("select * from employes where login='" + login + "'");
		if (result.next()) {
			// Affichage de l'en-tête du tableau
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");
			System.out.println("|  ID    |        Nom          |       Prénom        |     Login        |     Téléphone      |      Salaire      |  Année Intégration |       Poste         |");
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");
		    System.out.printf("| %-6s | %-19s | %-19s | %-16s | %-18s | %-17.2f | %-18s | %-18s  |\n",
	            result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(6),
	            result.getDouble(7), result.getString(8), result.getString(9));
			System.out.println("+--------+---------------------+---------------------+------------------+--------------------+-------------------+--------------------+---------------------+");

		} else {
			System.out.print("# Aucun employé correspondant au login saisi #");
=======
		System.out.println("Donner le login de l'employe");
		String login = scan.next();
		ResultSet result = s.executeQuery("select * from employes where login='" + login + "'");
		if (result.next()) {
			System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18s %-20s %-19s%n ", "Identifiant", "Nom ",
					"Prénom", "Login", "Mot de passe", "Telephone", "Salaire", "AnnéeIntégration", "Poste");

			System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18.2f %-20s %-20s%n", result.getString(1),
					result.getString(2), result.getString(3), result.getString(4), "****", result.getString(6),
					result.getDouble(7), result.getString(8), result.getString(9));

		} else {
			System.out.print("Aucun employé correspondant au login saisi");
>>>>>>> origin/Samuel
		}

	}

	// RECUPERATION DES INFORMATIONS D'UN EMPLOYE
	public static void getInformation(Employe E, Statement s) throws SQLException {
<<<<<<< HEAD
		// System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18s %-20s %-19s%n ", "Identifiant", "Nom ", "Prénom",
		// 		"Login", "Mot de passe", "Telephone", "Salaire", "AnnéeIntégration", "Poste");
		// System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18.2f %-20s %-20s%n", E.getEmployeId(), E.getNom(),
		// 		E.getPrenom(), E.getLogin(), "*******", E.getNumTel(), E.getSalaire(), E.getAnneeService(),
		// 		E.getPoste());

		// Affichage des informations d'un emplooyer
		System.out.println("Mes Informations");
		System.out.println("==============================\n");

		System.out.println("Identifiant:         "+E.getEmployeId());
		System.out.println("Nom:                 "+E.getNom());
		System.out.println("Prénom:              "+E.getPrenom());
		System.out.println("Login:               "+E.getLogin());
		System.out.println("Mot de passe:        "+"*******");
		System.out.println("Téléphone:           "+E.getNumTel());
		System.out.println("Salaire:             "+E.getSalaire());
		System.out.println("Année d'intégration: "+E.getAnneeService());
		System.out.println("Poste:               "+E.getPoste());

=======
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18s %-20s %-19s%n ", "Identifiant", "Nom ", "Prénom",
				"Login", "Mot de passe", "Telephone", "Salaire", "AnnéeIntégration", "Poste");
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18.2f %-20s %-20s%n", E.getEmployeId(), E.getNom(),
				E.getPrenom(), E.getLogin(), "*******", E.getNumTel(), E.getSalaire(), E.getAnneeService(),
				E.getPoste());
>>>>>>> origin/Samuel
	}

	// AFFICHER FICHE DE PAIE
	public static void afficherFiche(Employe E, Statement s) {
<<<<<<< HEAD
		System.out.println("======================================");
		System.out.println("            FICHE DE PAIE             ");
		System.out.println("======================================");
=======
		System.out.println("--------------------------------------");
		System.out.println("|            FICHE DE PAIE            |");
		System.out.println("--------------------------------------");
>>>>>>> origin/Samuel
		System.out.println("Nom: " + E.getNom());
		System.out.println("Prenom: " + E.getPrenom());
		System.out.println("Montant du salaire: " + E.getSalaire());
		System.out.println("Date:" + LocalDate.now());
	}

	// REINITIALISATION DU MOT DE PASSE
	public static void setPassword(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String mdp;
		int i = 0;
		do {
			i++;

<<<<<<< HEAD
			System.out.print("> Donner votre ancien mot de passe: ");
=======
			System.out.println("> Donner votre ancien mot de passe");
>>>>>>> origin/Samuel
			mdp = scan.next();
			if (!E.getMdp().equals(mdp))
				System.out.println("Mot de passe incorrect");
		} while (i < 3 && !E.getMdp().equals(mdp));

		// VERIFCATION DE LA VALIDITE DES INFORMATIONS
		if (E.getMdp().equals(mdp))

		{
			String newMdp, confirmMdp;
			do {
<<<<<<< HEAD
				System.out.print("Donner le nouveau mot de passe: ");
				newMdp = scan.next();
				System.out.print("Confirmer le mot de passe: ");
				confirmMdp = scan.next();
				if (!(newMdp.equals(confirmMdp))) {
					System.out.println("# Les mots de passe ne correspondent pas! #");
=======
				System.out.println("> Donner le nouveau mot de passe");
				newMdp = scan.next();
				System.out.println("> Confirmer le mot de passe");
				confirmMdp = scan.next();
				if (!(newMdp.equals(confirmMdp))) {
					System.out.println("> Les mots de passe ne correspondent pas!");
>>>>>>> origin/Samuel
				}
			} while (!(newMdp.equals(confirmMdp)));
			int re = s.executeUpdate("update employes set mdp='" + newMdp + "' where id='" + E.getEmployeId() + "'");
			if (re != 0) {
<<<<<<< HEAD
				System.out.println("# Mot de passe mis à jour #");
				E.setMdp(confirmMdp);
			} else {
				System.out.println("# Opération échouée #");
			}
		} else {
			System.out.println("# Dépassement du nombre de tentatives. Réessayez plus tard #");
=======
				System.out.println(">Mot de passe mis à jour");
				E.setMdp(confirmMdp);
			} else {
				System.out.println(">Opération échouée");
			}
		} else {
			System.out.println(">Dépassement du nombre de tentatives. Réessayez plus tard");
>>>>>>> origin/Samuel
		}
	}

	// SUPPRESSION DE COMPTE PAR L'ADMIN
	public static void supprimerCompte(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("Saisir le login de l'employé: ");
		String login = scan.next();
		System.out.print("Confirmez vous la suppression?\n'oui' pour confirmer: ");
=======
		System.out.println(">Saisir le login de l'employé");
		String login = scan.next();
		System.out.println("> Confirmez vous la suppression?\n'oui' pour confirmer");
>>>>>>> origin/Samuel
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where login='" + login + "'");
			if (result != 0) {
<<<<<<< HEAD
				System.out.println("# Suppression effectuée #");
			} else {
				System.out.println("# Opération échouée #");
			}
		} else {
			System.out.println("# Suppression annullée #");
=======
				System.out.println("Suppression effectuée");
			} else {
				System.out.println("Opération échouée");
			}
		} else {
			System.out.println("Suppression annullée");
>>>>>>> origin/Samuel
		}

	}

	// SUPPRESSION DE COMPTE PAR L'EMPLOYE
	public static boolean supprimerMonCompte(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String mdp;
		int cpt = 0;
		do {
			cpt++;
<<<<<<< HEAD
			System.out.print("Saisissez votre mot de passe: ");
=======
			System.out.println("Saissisez votre mot de passe");
>>>>>>> origin/Samuel
			mdp = scan.next();
			if (cpt == 3) {

				return false;
			}
		} while (!mdp.equals(E.getMdp()));

<<<<<<< HEAD
		System.out.print("Confirmez vous vouloir supprimer votre compte? 'oui' pour confirmer: ");
=======
		System.out.println("Confirmez vous vouloir supprimer votre compte? 'oui' pour confirmer");
>>>>>>> origin/Samuel
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where id='" + E.getEmployeId() + "'");
			if (result != 0) {
<<<<<<< HEAD
				System.out.println("# Suppression effectuée #");

				return true;
			} else {
				System.out.println("# Opération échouée #");
			}
		} else {
			System.out.println("# Suppression annulée #");
=======
				System.out.println("Suppression effectuée");

				return true;
			} else {
				System.out.println("Opération échouée");
			}
		} else {
			System.out.println("Suppression annulée");
>>>>>>> origin/Samuel
		}

		return false;// Suppression non effectuée ou annullée

	}

	// CALCUL DU SALAIRE MOYEN
	public static void getAverageSalary(Statement s) throws SQLException {
		ResultSet result = s.executeQuery("select salaire from employes");
		int nbOfEmployees = 0;
		double salary = 0;
		while (result.next()) {
			salary += result.getDouble(1);
			nbOfEmployees++;
		}
		if (nbOfEmployees != 0) {
			salary = salary / nbOfEmployees;
			System.out.println("Le salaire moyen des emplyés est: " + salary);

		} else {
			System.out.println("Vous n'avez enregistré aucun salaire. Veuillez réessayer plus tard.");
		}

	}

	// FONCTIONNALITE RELATIF AUX ARTICLES
	public static void InsererNouvelArticle(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		float pu;
		int quantite;
<<<<<<< HEAD
		System.out.print("Donnez la catégorie de l'article: ");
		categorie = scan.nextLine();
		System.out.print("Donnez le libellé de l'article: ");
		libelle = scan.nextLine();
		do {
			System.out.print("Donnez le prix unitaire de l'article: ");
			pu = scan.nextFloat();
		} while (pu <= 0);
		do {
			System.out.print("Donnez la quantité de l'article: ");
=======
		System.out.println("Donnez la catégorie de l'article");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.nextLine();
		do {
			System.out.println("Donnez le prix unitaire de l'article");
			pu = scan.nextFloat();
		} while (pu <= 0);
		do {
			System.out.println("Donnez la quantité de l'article");
>>>>>>> origin/Samuel
			quantite = scan.nextInt();
		} while (quantite <= 0);

		String query = "INSERT INTO Articles(libelle,pu,quantite,categorie) values('" + libelle + "'," + pu + ","
				+ quantite + ",'" + categorie + "')";
		int re = s.executeUpdate(query);
		if (re != 0) {
<<<<<<< HEAD
			System.out.println("# Insertion réussie #");
		} else {
			System.out.println("# Opération échouée #");
=======
			System.out.println("Insertion réussie");
		} else {
			System.out.println("Opération échouée");
>>>>>>> origin/Samuel
		}
	}

	public static void faireApprovisionnement(Statement s) throws SQLException {
		afficherTousArticles(s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
<<<<<<< HEAD
		System.out.println("# Rentrez les bonnes informations à partir de la liste d'articles affichée ci-dessus #");
		System.out.print("Donnez la catégorie de l'article: ");
		categorie = scan.nextLine();
		System.out.print("Donnez le libellé de l'article: ");
		libelle = scan.nextLine();
		int quantiteAchat;
		do {
			System.out.print("Donnez la quantité d'article à acheter: ");
=======
		System.out.println("Rentrez les bonnes informations à partir de la liste d'articles affichée ci-dessus");
		System.out.println("\nDonnez la catégorie de l'article");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.nextLine();
		int quantiteAchat;
		do {
			System.out.println("Donnez la quantité d'article à acheter");
>>>>>>> origin/Samuel
			quantiteAchat = scan.nextInt();
		} while (quantiteAchat <= 0);
		String query1 = "SELECT quantite FROM Articles WHERE libelle='" + libelle + "' AND categorie='" + categorie
				+ "'";
		ResultSet re = s.executeQuery(query1);
		if (!re.next()) {
<<<<<<< HEAD
			System.out.print("# Opération non effectuée #");
=======
			System.out.print("L'article n'est pas enregistré...\nVeuillez procéder à l'enregistrement au préalable\n");
>>>>>>> origin/Samuel
			return;
		}

		int quantite = re.getInt(1);
		quantite += quantiteAchat;
		String query2 = "UPDATE Articles SET quantite=" + quantite + " WHERE libelle='" + libelle + "' AND categorie='"
				+ categorie + "'";
		int result = s.executeUpdate(query2);
		if (result != 0) {
<<<<<<< HEAD
			System.out.println("# Opération Effectuée #");
		} else {
			System.out.println("# Opération non effectuée #");
=======
			System.out.println("Opération Effectuée");
		} else {
			System.out.println("Opération non effectuée");
>>>>>>> origin/Samuel
		}

	}

	public static void vendreArticle(Statement s) throws SQLException {
		afficherTousArticles(s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
<<<<<<< HEAD
		System.out.print("Donnez la catégorie de l'article souhaité: ");
		categorie = scan.nextLine();
		System.out.print("Donnez le libellé de l'article souhaité: ");
		libelle = scan.nextLine();
		int quantiteVente;
		do {
			System.out.print("Donnez la quantité d'article à vendre: ");
=======
		System.out.println("Donnez la catégorie de l'article souhaité");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article souhaité");
		libelle = scan.nextLine();
		int quantiteVente;
		do {
			System.out.println("Donnez la quantité d'article à vendre");
>>>>>>> origin/Samuel
			quantiteVente = scan.nextInt();
		} while (quantiteVente <= 0);
		String query1 = "SELECT quantite, pu FROM Articles WHERE libelle='" + libelle + "' AND categorie='" + categorie
				+ "'";
		ResultSet re = s.executeQuery(query1);
		if (re.next()) {
			int stock = re.getInt(1);
			float pu = re.getFloat(2);
			if (stock < quantiteVente) {
<<<<<<< HEAD
				System.out.println("# Quantite insuffisante en stock #");
=======
				System.out.println("Quantite insuffisante en stock");
>>>>>>> origin/Samuel
				scan.close();
				return;
			}
			stock -= quantiteVente;
<<<<<<< HEAD
			System.out.print("Donnez le nom du client: ");
			String nom = scan.next();
			System.out.print("Donnez le prenom du client: ");
=======
			System.out.println("Donnez le nom du client");
			String nom = scan.next();
			System.out.println("Donnez le prenom du client");
>>>>>>> origin/Samuel
			String prenom = scan.next();
			String query2 = "UPDATE Articles SET quantite=" + stock + " WHERE libelle='" + libelle + "' AND categorie='"
					+ categorie + "'";
			int result = s.executeUpdate(query2);
<<<<<<< HEAD
			System.out.println("======================================");
			System.out.println("               FACTURE                ");
			System.out.println("======================================");
=======
			System.out.println("--------------------------------------");
			System.out.println("|               FACTURE              |");
			System.out.println("--------------------------------------");
>>>>>>> origin/Samuel
			System.out.println("Nom: " + nom);
			System.out.println("Prenom: " + prenom);
			System.out.println("Produit Acheté: " + libelle);
			System.out.println("Prix unitaire: " + pu);
			System.out.println("Quantite: " + quantiteVente);
			System.out.println("Total: " + pu * quantiteVente);

		} else {
<<<<<<< HEAD
			System.out.println("# Opération échouée: l'Article n'est peut être pas répertorié #");
=======
			System.out.println("Opération échouée.\nL'Article n'est peut être pas répertorié");
>>>>>>> origin/Samuel
		}

	}

	public static void supprimerArticle(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
<<<<<<< HEAD
		System.out.print("Donnez la catégorie de l'article: ");
		categorie = scan.nextLine();
		System.out.print("Donnez le libellé de l'article: ");
		libelle = scan.nextLine();
		System.out.print("Confirmez vous la suppression?\nSaisir'oui' pour confirmer: ");
=======
		System.out.println("Donnez la catégorie de l'article");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.nextLine();
		System.out.println("Confirmez vous la suppression?\nSaisir'oui' pour confirmer");
>>>>>>> origin/Samuel
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			String query = "DELETE FROM articles WHERE libelle='" + libelle + "' AND categorie='" + categorie + "'";
			int re = s.executeUpdate(query);
			if (re != 0) {
<<<<<<< HEAD
				System.out.println("# Suppression effectuée #");

			} else {
				System.out.println("# Opération annulée: l'article n'existe peut être pas! #");
			}

		} else {
			System.out.println("# Suppression annulée #");
=======
				System.out.println("Suppression effectuée");

			} else {
				System.out.println("Opération annulée\nL'article n'existe peut être pas!");
			}

		} else {
			System.out.println("Suppression annulée");
>>>>>>> origin/Samuel
		}
	}

	public static void afficherTousArticles(Statement s) throws SQLException {
<<<<<<< HEAD
			ResultSet re = s.executeQuery("SELECT * FROM Articles");
			boolean bool = false;
			System.out.println("+----------------------+---------------------+---------------------+--------------------+");
			System.out.println("| Libellé              | Prix Unitaire       |      Quantite       |  Catégorie         |");
			System.out.println("+----------------------+---------------------+---------------------+--------------------+");
			while (re.next()) {
		    System.out.printf("| %-20s | %-19s | %-19s | %-18s |\n",
	        re.getString(1), re.getString(2), re.getString(3), re.getString(4));
			System.out.println("+----------------------+---------------------+---------------------+--------------------+");
			bool = true;
		}
		if (!bool) {
			System.out.println("# Opération échouée #");
=======
		ResultSet re = s.executeQuery("SELECT * FROM Articles");
		boolean bool = false;
		System.out.printf("%-20s %-20s %-19s %-20s%n", "Libellé", "Prix Unitaire", "Quantite", "Catégorie");
		while (re.next()) {
			System.out.printf("%-21s %-17.3f %-20d %-20s%n", re.getString(1), re.getFloat(2), re.getInt(3),
					re.getString(4));
			bool = true;
		}
		if (!bool) {
			System.out.println("Opération échouée");
>>>>>>> origin/Samuel
		}
	}

}
