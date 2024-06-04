package modele;

import java.util.Date;

public class VenteC {
	private int id, prixU, tel;
	private String numeroC;
	private Date dateC;
	private Produit article;
	public VenteC() {
		super();
	}
	public VenteC(int prixU, int tel, String numeroC, Date dateC, Produit article) {
		super();
		this.prixU = prixU;
		this.tel = tel;
		this.numeroC = numeroC;
		this.dateC = dateC;
		this.article = article;
	}
	public VenteC(int id, int prixU, int tel, String numeroC, Date dateC, Produit article) {
		super();
		this.id = id;
		this.prixU = prixU;
		this.tel = tel;
		this.numeroC = numeroC;
		this.dateC = dateC;
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getNumeroC() {
		return numeroC;
	}
	public void setNumeroC(String numeroC) {
		this.numeroC = numeroC;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	public Produit getArticle() {
		return article;
	}
	public void setArticle(Produit article) {
		this.article = article;
	}
	
	
}
