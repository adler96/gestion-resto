package modele;

public class Produit {
	private int id, prixU;
	private String codeProd, libelle;
	public Produit() {
		super();
	}
	public Produit(int prixU, String codeProd, String libelle) {
		super();
		this.prixU = prixU;
		this.codeProd = codeProd;
		this.libelle = libelle;
	}
	public Produit(int id, int prixU, String codeProd, String libelle) {
		super();
		this.id = id;
		this.prixU = prixU;
		this.codeProd = codeProd;
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrixU() {
		return prixU;
	}
	public void setPrixU(int prixU) {
		this.prixU = prixU;
	}
	public String getCodeProd() {
		return codeProd;
	}
	public void setCodeProd(String codeProd) {
		this.codeProd = codeProd;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void affiche(){
		System.out.println("je teste gi sur desktop");
	}
	
	
}
