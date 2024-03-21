package projetjava;

public class Employer {
	private String employeId;
    private String prenom;
    private String nom;
    private String numTel;
    private String email;
    private String adresse;
    private double salaire;
    

    // Constructor
    public Employer(String employeId, String prenom, String nom, String numTel,  String email,  String adresse, double salaire ) {
        this.setPrenom(prenom);
        this.setNom(nom);
        this.setEmployeId(employeId);
        this.setSalaire(salaire);
        this.setEmail(email);
        this.setNumTel(numTel);
        this.setAdresse(adresse);
    }

    public Employer() {
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
    
    
}
