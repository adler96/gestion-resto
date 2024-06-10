package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.ConnexionBase;

public class ProduitService {
	
	public int quantiteVendueParProduit(int id) {
		int quantite = 0;
		ResultSet rs = null;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase();
		cb.conn();
		
		// Requete SQL
		String requete = "select (select count(article) from VenteC where article.id=" +id+ ") + "
				+ "(select count(article) from VenteP where article.id=" +id+ ") as qte";
		
		// Executer la requete
		try {
			rs = cb.st.executeQuery(requete);
			
			if(rs != null) {
				quantite = rs.getInt("qte");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quantite;
	}
	
	public int montantTotalVentes() {
		int montant = 0;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase(); 
		cb.conn();
		
		// Requete SQL
		String requete = "select (select sum(pu) from VenteC) + (select sum(pu) from VenteC) as total_sum";
		
		// Executer la requete
		try {
			ResultSet rs = cb.st.executeQuery(requete);
			
			if(rs != null) {
				montant = rs.getInt("total_sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return montant;
	}
	
	public int montantTotalVentesParPeriode(Date periodeDebut, Date periodeFin) {
		int montant = 0;
		
		// Connexion bdd
		ConnexionBase cb = new ConnexionBase();
		cb.conn();
		
		// Requete SQL
		String requete = "select (select sum(pu) from VenteC where date>"+periodeDebut+" and date<"+periodeFin+") "
				+ "+ (select sum(pu) from VenteP where date>"+periodeDebut+" and date<"+periodeFin+") as total_sum";
		
		// Executer la requete
		try {
			ResultSet rs = cb.st.executeQuery(requete);
			
			if (rs != null) {
				montant = rs.getInt("total_sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return montant;
	}

}
