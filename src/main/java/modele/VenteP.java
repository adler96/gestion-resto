package modele;

import java.util.Date;

public class VenteP {
	private int id, prixU;
	private String numeroVSP;
	private Date dateVSP;
	private Produit article;
	public VenteP() {
		super();
	}
	public VenteP(int prixU, String numeroVSP, Date dateVSP, Produit article) {
		super();
		this.prixU = prixU;
		this.numeroVSP = numeroVSP;
		this.dateVSP = dateVSP;
		this.article = article;
	}
	public VenteP(int id, int prixU, String numeroVSP, Date dateVSP, Produit article) {
		super();
		this.id = id;
		this.prixU = prixU;
		this.numeroVSP = numeroVSP;
		this.dateVSP = dateVSP;
		this.article = article;
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
	public String getNumeroVSP() {
		return numeroVSP;
	}
	public void setNumeroVSP(String numeroVSP) {
		this.numeroVSP = numeroVSP;
	}
	public Date getDateVSP() {
		return dateVSP;
	}
	public void setDateVSP(Date dateVSP) {
		this.dateVSP = dateVSP;
	}
	public Produit getArticle() {
		return article;
	}
	public void setArticle(Produit article) {
		this.article = article;
	}
	
	
}
