package projetjava;

public class Employe {
	private String employeId;
	private String prenom;
	private String nom;
	private String numTel;
<<<<<<< HEAD
	// private String email;
	private String login;
	private String mdp;
	private double salaire;
	private String anneeService;
	private String poste;

	// Constructor
	public Employe(String employeId, String nom, String prenom, String login, String mdp, String numTel, double salaire,
			String anneeService, String poste) {
=======
	private String email;
//	private String message = "";
	private double salaire;
    private String mdp;
    private String fonction;

	// Constructor
	public Employe(String employeId, String prenom, String nom, String numTel, String email, String mdp,
			double salaire, String fonction) {
>>>>>>> 7702d09c08c37da27c3f69f7c8dc4c3349e996fc
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setEmployeId(employeId);
		this.setSalaire(salaire);
		this.setLogin(login);
		// this.setEmail(email);
		this.setNumTel(numTel);
		this.setMdp(mdp);
		this.setAnneeService(anneeService);
		this.setPoste(poste);
	}

	public Employe() {
		// TODO Auto-generated constructor stub
	}

	// geteurs et seteurs

	public String getEmployeId() {
		return employeId;
	}
	

	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

<<<<<<< HEAD
	public String getAnneeService() {
		return anneeService;
	}

	public void setAnneeService(String anneeService) {
		this.anneeService = anneeService;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
=======
	public String getAdresse() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFonction() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	



}
>>>>>>> 7702d09c08c37da27c3f69f7c8dc4c3349e996fc
