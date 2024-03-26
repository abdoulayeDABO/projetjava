package projetjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fonctionnalite {

	// Pas besoin de classe puisqu'onn manipule une base de données. De simples

	public static void CreateEmployee(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Donner le matricule de l'employé");
		String matricule = scan.next();
		System.out.println("Donner le nom de l'employé");
		String name = scan.next();
		System.out.println("Donner le(s) prenom(s) de l'employé");
		scan.nextLine();
		String firstname = scan.nextLine();
		System.out.println("Définir le mot de passe de l'employé");
		String mdp = scan.next();
		System.out.println("Informations complémentaires");
		int age;
		do {
			System.out.println("Donner l'âge de l'employé");
			age = scan.nextInt();
		} while (age <= 0);
		String serviceDate;
		System.out.println("Donner l'année d'entrée dans l'année d'entrée dans le service");
		serviceDate = scan.next();
		double salary;
		do {
			System.out.println("Saisir le salaire de lemployé");
			salary = scan.nextDouble();
		} while (salary <= 0);
		int re = s.executeUpdate(
				"insert into employes(matricule,nom,prenom,mdp,age,annee,salaire) values('" + matricule + "','" + name
						+ "','" + firstname + "','" + mdp + "'," + age + ",'" + serviceDate + "'," + salary + ")");

		System.out.println("insertion réussie");
	}

	// AFFICHAGE DES EMPLOYES
	public static void printEmployees(Statement s) throws SQLException {
		ResultSet result = s.executeQuery("select * from employes");
		System.out.println("Matricule" + "\t" + "Nom " + "\t" + "Prénom(s)   " + "\t" + "Mdp  " + "\t" + "Age" + "\t"
				+ "AnnéeService" + "\t" + "Salaire");
		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3)
					+ "\t\t*****\t" + result.getInt(5) + "\t" + result.getString(6) + "\t\t" + result.getDouble(7));
		}

	}

	// RECUPERATION DES INFORMATIONS DES EMPLOYES
	public static void getInformation(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Authentification requise. Veuillez saisir les informations demandées");
		System.out.println("Donner votre nom");
		String name = scan.next();
		System.out.println("Donner votre/vos prénom(s)");
		scan.nextLine();
		String firstname = scan.nextLine();
		System.out.println("Donner votre mot de passe");
		String mdp = scan.next();

		ResultSet result = s.executeQuery(
				"select * from employes where nom='" + name + "' and prenom='" + firstname + "' and mdp='" + mdp + "'");
		boolean check = false;// Pour vérifier si les informations sont correctes
		if (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3)
					+ "\t\t*****\t" + result.getInt(5) + "\t" + result.getString(6) + "\t\t" + result.getDouble(7));
		} else {
			System.out.println("Informations incorrectes");
		}
	}

	// REINITIALISATION DU MOT DE PASSE
	public static void setPassword(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Authentification requise. Veuillez saisir les informations demandées");
		System.out.println("Saisir le nom");
		String name = scan.next();
		System.out.println("Saisir le(s) prénom(s)");
		scan.nextLine();
		String firstname = scan.nextLine();
		System.out.println("Donner l'ancien mot de passe");
		String mdp = scan.next();

		ResultSet result = s.executeQuery(
				"select * from employes where nom='" + name + "' and prenom='" + firstname + "' and mdp='" + mdp + "'");
		// VERIFCATION DE LA VALIDITE DES INFORMATIONS
		if (result.next()) {
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
			int re = s.executeUpdate("update employes set mdp='" + newMdp + "' where nom='" + name + "' and prenom='"
					+ firstname + "' and mdp='" + mdp + "'");
			System.out.println("Mot de passe mis à jour");
		} else {
			System.out.println("Informations incorrectes");
		}
	}

	// SUPPRESSION DE COMPTE PAR L'ADMIN
	public static void removeAccount(Statement s) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir le matricule de l'employé");
		String matricule = scan.next();
		int result = s.executeUpdate("delete from employes where matricule='" + matricule + "'");
		if (result != 0) {
			System.out.println("Compte supprimé");
		} else {
			System.out.println("Suppression non effectuée. Veuillez rensigner un matricule valide");
		}
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
}
