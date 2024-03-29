package projetjava;

public class Employe {
	private String employeId;
	private String prenom;
	private String nom;
	private String numTel;
	private String email;
//	private String message = "";
	private double salaire;
    private String mdp;
    private String fonction;

	// Constructor
	public Employe(String employeId, String prenom, String nom, String numTel, String email, String mdp,
			double salaire, String fonction) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setEmployeId(employeId);
		this.setSalaire(salaire);
		this.setEmail(email);
		this.setNumTel(numTel);
		this.setMdp(mdp);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
