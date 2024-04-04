package projetjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Fonctionnalite {

	// Pas besoin de classe puisqu'onn manipule une base de données. De simples

	public static void CreerEmploye(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("> Donner l'identifiant de l'employé");
		String id = scan.next();
		System.out.println("> Donner le nom de l'employé");
		String name = scan.next();
		scan.nextLine();
		System.out.println("> Donner le prenom de l'employé");
		String firstname = scan.next();
		String login;
		boolean bool = true;
		do {
			System.out.println("> Veuillez saisir un nouveau login");
			login = scan.next();
			ResultSet result = s.executeQuery("SELECT * FROM employes WHERE login='" + login + "'");
			if (result.next()) {
				bool = false;
				System.out.println("Login déjà utilisé");
			} else {
				bool = true;
			}

		} while (!bool);
		System.out.println("> Définir le mot de passe de l'employé (*n'y mettez pas d'espace)");
		String mdp = scan.next();
		scan.nextLine();
		System.out.println("> Donnez le numero de telephone de l'employe");
		String tel = scan.nextLine();
		String serviceDate;
		System.out.println("> Donner l'année d'entrée dans le service");
		serviceDate = scan.next();
		double salary;
		do {
			System.out.println("> Saisir le salaire de lemployé");
			salary = scan.nextDouble();
		} while (salary <= 0);
		scan.nextLine();
		System.out.println("> Donnez la fonction occupée par l'employé");
		String poste = scan.nextLine();
		;
		int re = s.executeUpdate("insert into employes(id,nom,prenom,login,mdp,tel,salaire,annee,poste) values('" + id
				+ "','" + name + "','" + firstname + "','" + login + "','" + mdp + "','" + tel + "'," + salary + ",'"
				+ serviceDate + "','" + poste + "')");

		if (re != 0) {
			System.out.println("> Insertion réussie");
			int result = s.executeUpdate("INSERT INTO historique(id_employe,poste,operation,date) values('"
					+ E.getEmployeId() + "','" + E.getPoste() + "','Creation_employe','" + LocalDate.now() + "')");
		} else {
			System.out.println("> Opération échouée");
		}

	}

	// AFFICHAGE DES EMPLOYES PAR l'ADMIN
	public static void printEmployes(Employe E, Statement s) throws SQLException {
		ResultSet result = s.executeQuery("select * from employes");
		System.out.println("> Identifiant" + "\t" + "Nom " + "\t" + "Prénom   " + "\t" + "Login" + "\tMot de passe"
				+ "\t" + "Telephone" + "\tSalaire" + "\t" + "AnnéeIntégrationService" + "\t" + "Poste");
		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4) + "\t" + "\t*****\t" + result.getString(6) + "\t" + result.getString(7)
					+ "\t\t" + result.getDouble(8) + "\t" + result.getString(9));

		}

	}

	// RECUPERATION DES INFORMATIONS D'UN EMPLOYE
	public static void getInformation(Employe E, Statement s) throws SQLException {

		System.out.println("> Identifiant" + "\t" + "Nom " + "\t" + "Prénom   " + "\t" + "Login" + "\tMot de passe"
				+ "\t" + "Telephone" + "\tSalaire" + "\t" + "AnnéeIntégrationService" + "\t" + "Poste");
		System.out.println(
				E.getEmployeId() + "\t\t" + E.getNom() + "\t" + E.getPrenom() + "\t" + E.getLogin() + "\t" + "\t*****\t"
						+ E.getNumTel() + "\t" + E.getSalaire() + "\t\t" + E.getAnneeService() + "\t" + E.getPoste());
	}

	// REINITIALISATION DU MOT DE PASSE
	public static void setPassword(Employe E, Statement s) throws SQLException {

		Scanner scan = new Scanner(System.in);
		String mdp;
		int i = 0;
		do {
			i++;

			System.out.println("> Donner votre ancien mot de passe");
			mdp = scan.next();
			if (!E.getMdp().equals(mdp))
				System.out.println("Mot de passe incorrect");
		} while (i < 3 && !E.getMdp().equals(mdp));

		// VERIFCATION DE LA VALIDITE DES INFORMATIONS
		if (E.getMdp().equals(mdp))

		{
			String newMdp, confirmMdp;
			do {
				System.out.println("> Donner le nouveau mot de passe");
				newMdp = scan.next();
				System.out.println("> Confirmer le mot de passe");
				confirmMdp = scan.next();
				if (!(newMdp.equals(confirmMdp))) {
					System.out.println("> Les mots de passe ne correspondent pas!");
				}
			} while (!(newMdp.equals(confirmMdp)));
			int re = s.executeUpdate("update employes set mdp='" + newMdp + "' where id='" + E.getEmployeId() + "'");
			if (re != 0) {
				System.out.println("> Mot de passe mis à jour");
				E.setMdp(confirmMdp);
				/*
				 * int result = s.executeUpdate(
				 * "INSERT INTO historique(id_employe,poste,operation,date) values('" +
				 * E.getEmployeId() + "','" + E.getPoste() + "','Modif. mot de passe','" +
				 * LocalDate.now() + "')");
				 */
			} else {
				System.out.println("> Opération échouée");
			}
		} else {
			System.out.println("Dépassement du nombre de tentatives. Réessayez plus tard");
		}
	}

	// SUPPRESSION DE COMPTE PAR L'ADMIN
	public static void supprimerCompte(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("> Saisir l'identifiant de l'employé");
		String id = scan.next();
		System.out.println("> Confirmez vous la suppression?\n'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where id='" + id + "'");
			if (result != 0) {
				System.out.println("Suppression effectuée");
				int re = s.executeUpdate(
						"INSERT INTO historique(id_employe,poste,operation,date) values('" + E.getEmployeId() + "','"
								+ E.getPoste() + "','Supp. compte Admin','" + LocalDate.now() + "')");
			} else {
				System.out.println("Opération échouée");
			}
		} else {
			System.out.println("Suppression annullée");
		}

	}

	// SUPPRESSION DE COMPTE PAR L'EMPLOYE
	public static boolean supprimerMonCompte(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Confirmez vous vouloir supprimer votre compte? 'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where id='" + E.getEmployeId() + "'");
			if (result != 0) {
				System.out.println("Suppression effectuée");
				return true;
			} else {
				System.out.println("Opération échouée");
			}
		} else {
			System.out.println("Suppression annulée");
		}
		return false;// Suppression non effectuée ou annullée

	}

	// CALCUL DU SALAIRE MOYEN
	public static void getAverageSalary(Employe E, Statement s) throws SQLException {
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

	public static void InsererNouvelArticle(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		float pu;
		int quantite;
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
			quantite = scan.nextInt();
		} while (quantite <= 0);

		String query = "INSERT INTO Articles(libelle,pu,quantite,categorie) values('" + libelle + "'," + pu + ","
				+ quantite + ",'" + categorie + "')";
		int re = s.executeUpdate(query);
		if (re != 0) {
			System.out.println("Insertion réussie");
			int result = s.executeUpdate("INSERT INTO historique(id_employe,poste,operation,date) values('"
					+ E.getEmployeId() + "','" + E.getPoste() + "','Achat nouvel article','" + LocalDate.now() + "')");
		} else {
			System.out.println("Opération échouée");
		}
	}

	public static void faireApprovisionnement(Employe E, Statement s) throws SQLException {
		afficherTousArticles(E, s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("Rentrez les bonnes informations à partir de la liste d'articles affichée ci-dessus");
		System.out.println("\nDonnez la catégorie de l'article");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.nextLine();
		int quantiteAchat;
		do {
			System.out.println("Donnez la quantité d'article à acheter");
			quantiteAchat = scan.nextInt();
		} while (quantiteAchat <= 0);
		String query1 = "SELECT quantite FROM Articles WHERE libelle='" + libelle + "' AND categorie='" + categorie
				+ "'";
		ResultSet re = s.executeQuery(query1);
		re.next();
		int quantite = re.getInt(1);
		quantite += quantiteAchat;
		String query2 = "UPDATE Articles SET quantite=" + quantite + " WHERE libelle='" + libelle + "' AND categorie='"
				+ categorie + "'";
		int result = s.executeUpdate(query2);
		if (result != 0) {
			System.out.println("Opération Effectuée");
			int request = s
					.executeUpdate("INSERT INTO historique(id_employe,poste,operation,date) values('" + E.getEmployeId()
							+ "','" + E.getPoste() + "','Approvionnement article','" + LocalDate.now() + "')");
		} else {
			System.out.println("Opération non effectuée");
		}

	}

	public static void vendreArticle(Employe E, Statement s) throws SQLException {
		afficherTousArticles(E, s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("Donnez la catégorie de l'article souhaité");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article souhaité");
		libelle = scan.nextLine();
		int quantiteVente;
		do {
			System.out.println("Donnez la quantité d'article à vendre");
			quantiteVente = scan.nextInt();
		} while (quantiteVente <= 0);
		String query1 = "SELECT quantite, pu FROM Articles WHERE libelle='" + libelle + "' AND categorie='" + categorie
				+ "'";
		ResultSet re = s.executeQuery(query1);
		if (re.next()) {
			int stock = re.getInt(1);
			int pu = re.getInt(2);
			if (stock < quantiteVente) {
				System.out.println("Quantite insuffisante en stock");
				return;
			}
			stock -= quantiteVente;
			System.out.println("Donnez le nom du client");
			String nom = scan.next();
			System.out.println("Donnez le prenom du client");
			String prenom = scan.next();
			String query2 = "UPDATE Articles SET quantite=" + stock + " WHERE libelle='" + libelle + "' AND categorie='"
					+ categorie + "'";
			int result = s.executeUpdate(query2);
			System.out.println("--------------------------------------");
			System.out.println("|               FACTURE               |");
			System.out.println("--------------------------------------");
			System.out.println("Nom: " + nom);
			System.out.println("Prenom: " + prenom);
			System.out.println("Produit Acheté: " + libelle);
			System.out.println("Prix unitaire: " + pu);
			System.out.println("Quantite: " + quantiteVente);
			System.out.println("Total: " + pu * quantiteVente);
			int request = s.executeUpdate("INSERT INTO historique(id_employe,poste,operation,date) values('"
					+ E.getEmployeId() + "','" + E.getPoste() + "','Vente article','" + LocalDate.now() + "')");

		} else {
			System.out.println("Opération échouée.\nL'Article n'est peut être pas répertorié");
		}

	}

	public static void supprimerArticle(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("Donnez la catégorie de l'article");
		categorie = scan.nextLine();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.nextLine();
		System.out.println("Confirmez vous la suppression?\nSaisir'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			String query = "DELETE FROM articles WHERE libelle='" + libelle + "' AND categorie='" + categorie + "'";
			int re = s.executeUpdate(query);
			if (re != 0) {
				System.out.println("Suppression effectuée");
				int result = s.executeUpdate(
						"INSERT INTO historique(id_employe,poste,operation,date) values('" + E.getEmployeId() + "','"
								+ E.getPoste() + "','Suppression Article','" + LocalDate.now() + "')");

			} else {
				System.out.println("Opération annulée\nL'article n'existe peut être pas!");
			}

		} else {
			System.out.println("Suppression annulée");
		}

	}

	public static void afficherTousArticles(Employe E, Statement s) throws SQLException {
		ResultSet re = s.executeQuery("SELECT * FROM Articles");
		boolean bool = false;
		System.out.println("Libellé" + "\t\t" + "Prix Unitaire" + "\t\t" + "Quantite" + "\t\t" + "Catégorie");
		while (re.next()) {
			System.out.println(
					re.getString(1) + "\t\t" + re.getInt(2) + "\t\t" + re.getInt(3) + "\t\t" + re.getString(4));
			bool = true;
		}
		if (!bool) {
			System.out.println("Opération échouée");
		}
	}

}
