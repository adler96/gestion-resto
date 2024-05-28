package service;

import java.util.Date;

import dao.ConnexionBase;

public class ProduitService {
	
	public int quantiteVendueParProduit(int id) {
		int quantite = 0;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		// Requete SQL
		String requete = "select (select count(article) from VenteC where article.id=" +id+ ") + "
				+ "(select count(article) from VenteC where article.id=" +id+ ") ";
		
		// Executer la requete
		quantite = cb.st.executeQuery(requete);
		
		return quantite;
	}
	
	public int montantTotalVentes() {
		int montant = 0;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		// Requete SQL
		String requete = "select (select sum(pu) from VenteC) + (select sum(pu) from VenteC) as total_sum";
		
		// Executer la requete
		montant = cb.st.executeQuery(requete);
		
		return montant;
	}
	
	public int montantTotalVentesParPeriode(Date periodeDebut, Date periodeFin) {
		int montant = 0;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase();
		cb.connect();
		
		// Requete SQL
		String requete = "select (select sum(pu) from VenteC where date>"+periodeDebut+" and date<"+periodeFin+") "
				+ "+ (select sum(pu) from VenteC where date>"+periodeDebut+" and date<"+periodeFin+") as total_sum";
		
		// Executer la requete
		montant = cb.st.executeQuery(requete);
		
		return montant;
	}

}
