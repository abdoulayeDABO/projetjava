package projetjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Connection con = ConnexionDB.ConnectDB();
		try {
			Statement s = con.createStatement();
			Employe E = new Employe();
			int choice;
			String login, mdp, poste = null;
			do {
				Utilitaire.afficherAuthentificationMenu();
				choice = sc.nextInt();
			} while (choice != 1 && choice != 2);
			if (choice == 1) {
				int i = 0;
				boolean bool = true;
				do {
					i++;
<<<<<<< HEAD
					System.out.print("Saisir votre Login: ");
					login = sc.next();
					System.out.print("Saisir votre mot de passe: ");
=======
					System.out.println("Saisir votre Login");
					login = sc.next();
					System.out.println("Saisir votre mot de passe");
>>>>>>> origin/Samuel
					mdp = sc.next();
					bool = Utilitaire.estAuthentifie(login, mdp, s);
					if (!bool) {
						System.out.print("Login et/ou mot de passe incorrects\n");
					} else {
						String query = "SELECT * FROM employes WHERE login='" + login + "'";
						ResultSet result = s.executeQuery(query);
						result.next();
						poste = result.getString(9);
						Utilitaire.initialiserEmploye(result, E);
					}
				} while (!bool && i < 3);// Trois essais
				// Affichage du menu selon l'employé connecté
				if (bool) {
					// MENU Admin
					int option;
					if (poste.equals("administrateur")) {
						do {
							Utilitaire.afficherAdministrationMenu();
							option = sc.nextInt();
							switch (option) {
							case 1:
								Fonctionnalite.CreerEmploye(s);
								break;
							case 2:
								Fonctionnalite.supprimerCompte(s);
								break;

							case 3:
								Fonctionnalite.printEmployes(s);
								break;
							case 4:
								Fonctionnalite.printEmploye(s);
								break;
							case 5:
								Fonctionnalite.getAverageSalary(s);
								break;
							case 6:
								Fonctionnalite.InsererNouvelArticle(s);
								break;
							case 7:
								Fonctionnalite.supprimerArticle(s);
								break;
							case 8:
								Fonctionnalite.afficherTousArticles(s);
								break;
							case 9:
								Fonctionnalite.faireApprovisionnement(s);
								break;
							case 10:
								Fonctionnalite.vendreArticle(s);
								break;
							case 0:
								System.out.println("Bye...");
								break;
							default:
								System.out.println("Choix invalide\n");
							}

						} while (option != 0);
					} else {
						do {
							Utilitaire.afficherEmployeMenu();
							option = sc.nextInt();
							switch (option) {
							case 1:
								Fonctionnalite.getInformation(E, s);
								break;
							case 2:
								Fonctionnalite.afficherFiche(E, s);
								break;
							case 3:
								boolean bool2 = Fonctionnalite.supprimerMonCompte(E, s);
								if (bool2) {
									System.out.println(
<<<<<<< HEAD
											"# Vous avez été déconnecté car n'ayant plus de compte. Veuillez voir l'administrateur si vous pensez ne pas être à l'origine de cet inconvenient #");
=======
											"Vous avez été déconnecté car n'ayant plus de compte.\nVeuillez voir l'administrateur si vous pensez ne pas être à l'origine de cet inconvenient");
>>>>>>> origin/Samuel
									return;
								}

								break;
							case 4:
								Fonctionnalite.setPassword(E, s);
								break;
							case 0:
								System.out.println("Bye...");
								break;
							default:
<<<<<<< HEAD
								System.out.println("# Choix invalide #");
=======
								System.out.println("Choix invalide\n");
>>>>>>> origin/Samuel
							}
						} while (option != 0);
					}
				}
				// Cas de dépassement du nombre d'essai
				else {
<<<<<<< HEAD
					System.out.println("# Vous avez dépassé le nombre d'essai autorisé! Réessayez plus tard. #");
=======
					System.out.println("Vous avez dépassé le nombre d'essai autorisé...\n" + "Réessayez plus tard");
>>>>>>> origin/Samuel
					return;
				}
			} else if (choice == 2) {
				System.out.print("Bye...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
