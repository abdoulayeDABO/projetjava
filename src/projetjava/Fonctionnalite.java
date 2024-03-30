package projetjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fonctionnalite {

	// Pas besoin de classe puisqu'onn manipule une base de données. De simples

	public static void CreerEmploye(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Donner l'identifiant de l'employé");
		String id = scan.next();
		System.out.println("Donner le nom de l'employé");
		String name = scan.next();
		scan.nextLine();
		System.out.println("Donner le(s) prenom(s) de l'employé");
		String firstname = scan.nextLine();
		System.out.println("Donnez le numero de telephone de l'employe");
		String tel = scan.nextLine();
		// scan.nextLine();
		System.out.println("Donnnez le mail de l'employe");
		String mail = scan.next();
		System.out.println("Définir le mot de passe de l'employé");
		String mdp = scan.next();

		String serviceDate;
		System.out.println("Donner l'année d'entrée dans le service");
		serviceDate = scan.next();
		double salary;
		do {
			System.out.println("Saisir le salaire de lemployé");
			salary = scan.nextDouble();
		} while (salary <= 0);
		System.out.println("Donnez le poste occupé par l'employé");
		String poste = scan.next();
		;
		int re = s.executeUpdate("insert into employes(id,nom,prenom,tel,mail,mdp,salaire,annee,poste) values('" + id
				+ "','" + name + "','" + firstname + "','" + tel + "','" + mail + "','" + mdp + "'," + salary + ",'"
				+ serviceDate + "','" + poste + "')");
		System.out.println("insertion réussie");

	}

	// AFFICHAGE DES EMPLOYES PAR l'ADMIN
	public static void printEmployes(Statement s) throws SQLException {
		ResultSet result = s.executeQuery("select * from employes");
		System.out.println("Identifiant" + "\t" + "Nom " + "\t" + "Prénom(s)   " + "\t" + "Mdp  " + "\t" + "\t"
				+ "AnnéeService" + "\t" + "Salaire");
		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3)
					+ "\t\t*****\t" + "\t" + result.getString(6) + "\t\t" + result.getDouble(7));
		}
	}

	// RECUPERATION DES INFORMATIONS D'UN EMPLOYE
	public static void getInformation(Employe E, Statement s) throws SQLException {

		ResultSet result = s.executeQuery("SELECT * FROM employes WHERE id='" + E.getEmployeId() + "'");
		if (result.next()) {
			System.out.println("Identifiant" + "\t" + "Nom" + "\t" + "Prénom(s)" + "Tel" + "\t" + "Mail" + "\t" + "Mdp"
					+ "\t" + "Salaire" + "\t" + "Année" + "\t" + "Poste");
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4) + "\t" + result.getString(5) + "\t" + "******" + result.getDouble(7) + "\t"
					+ result.getString(8) + "\t" + result.getString(9));
		} else {
			System.out.println("Opération échouée");
		}
	}

	// REINITIALISATION DU MOT DE PASSE
	public static void setPassword(Employe E, Statement s) throws SQLException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Donner votre ancien mot de passe");
		String mdp = scan.next();

		// VERIFCATION DE LA VALIDITE DES INFORMATIONS
		if (E.getMdp().equals(mdp)) {
			String newMdp, confirmMdp;
			do {
				System.out.println("Donner le nouveau mot de passe");
				newMdp = scan.next();
				System.out.println("Confirmer le mot de passe");
				confirmMdp = scan.next();
				if (!(newMdp.equals(confirmMdp))) {
					System.out.println("Les mots de passe ne correspondent pas!");
				}
			} while (!(newMdp.equals(confirmMdp)));
			int re = s.executeUpdate("update employes set mdp='" + newMdp + "' where id='" + E.getEmployeId() + "'");

			System.out.println("Mot de passe mis à jour");
		} else {
			System.out.println("Mot de passe incorrect");
		}
	}

	// SUPPRESSION DE COMPTE PAR L'ADMIN
	public static void supprimerCompte(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir l'identifiant");
		String id = scan.next();
		System.out.println("Confirmez vous la suppression?\n'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where id='" + id + "'");
			System.out.println("Suppression effectuée");
		} else {
			System.out.println("Suppression annullée");
		}

	}

	// SUPPRESSION DE COMPTE PAR L'EMPLOYE
	public static void supprimerMonCompte(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Confirmez vous vouloir supprimer votre compte? 'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			int result = s.executeUpdate("delete from employes where id='" + E.getEmployeId() + "'");
			System.out.println("Suppression effectuée");
		} else {
			System.out.println("Suppression annulée");
		}

		// Penser à déconnecter l'utilisateur

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

	public static void InsererNouvelArticle(Employe E, Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		float pu;
		int quantite;
		System.out.println("Donnez la catégorie de l'article");
		categorie = scan.next();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.next();
		do {
			System.out.println("Donnez le prix unitaire de l'article");
			pu = scan.nextFloat();
		} while (pu <= 0);
		do {
			System.out.println("Donnez la quantité de l'article");
			quantite = scan.nextInt();
		} while (quantite <= 0);
		// Ajout de la clé étrangère représentant le matricule de l'employé ayant
		// effectué l'insertion
		String query = "INSERT INTO Articles(libelle,pu,quantite,categorie) values('" + libelle + "'," + pu + ","
				+ quantite + ",'" + categorie + "')";
		int re = s.executeUpdate(query);
		System.out.println("Insertion réussie");
	}

	public static void faireApprovisionnement(Statement s) throws SQLException {
		afficherTousArticles(s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("\nDonnez la catégorie de l'article");
		categorie = scan.next();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.next();
		int quantiteAchat;
		do {
			System.out.println("Donnez la quantité d'article à acheter");
			quantiteAchat = scan.nextInt();
		} while (quantiteAchat <= 0);
		String query1 = "SELECT quantite FROM Articles WHERE libelle='" + libelle + "' AND categorie='" + categorie
				+ "'";
		ResultSet re = s.executeQuery(query1);
		if (re.next()) {
			int quantite = re.getInt(1);
			quantite += quantiteAchat;
			String query2 = "UPDATE Articles SET quantite=" + quantite + " WHERE libelle='" + libelle
					+ "' AND categorie='" + categorie + "'";
			int result = s.executeUpdate(query2);
			System.out.println("Opération Effetcué");
		} else {
			System.out.println("Opération non effectuée");
		}

	}

	public static void vendreArticle(Statement s) throws SQLException {
		afficherTousArticles(s);
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("Donnez la catégorie de l'article souhaité");
		categorie = scan.next();
		System.out.println("Donnez le libellé de l'article souhaité");
		libelle = scan.next();
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

		} else {
			System.out.println("Article non répertorié");
		}

	}

	public static void supprimerArticle(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String libelle, categorie;
		System.out.println("Donnez la catégorie de l'article");
		categorie = scan.next();
		System.out.println("Donnez le libellé de l'article");
		libelle = scan.next();
		System.out.println("Confirmez vous la suppression?\nSaisir'oui' pour confirmer");
		String reponse = scan.next();
		if (reponse.equals("oui")) {
			String query = "DELETE FROM articles WHERE libelle='" + libelle + "' AND categorie='" + categorie + "'";
			int re = s.executeUpdate(query);
			System.out.println("Suppression effectuée");
		} else {
			System.out.println("Suppression annulée");
		}

	}

	public static void afficherTousArticles(Statement s) throws SQLException {
		ResultSet re = s.executeQuery("SELECT * FROM Articles");
		int i = 0;
		while (re.next()) {
			if (i == 0) {
				System.out.println("Libellé" + "\t\t" + "Prix Unitaire" + "\t\t" + "Quantite" + "\t\t" + "Catégorie");
				i++;
			}

			System.out.println(
					re.getString(1) + "\t\t" + re.getInt(2) + "\t\t" + re.getInt(3) + "\t\t" + re.getString(4));
		}
	}

}
