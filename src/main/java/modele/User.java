package modele;

public class User {
	private int id;
	private String matricule, prenom, nom, login, password;
	
	public User() {
		super();
	}

	public User(int id, String matricule, String prenom, String nom, String login, String password) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	public User(String matricule, String prenom, String nom, String login, String password) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
