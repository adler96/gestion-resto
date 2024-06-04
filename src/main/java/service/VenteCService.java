
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ConnexionBase;
import modele.Produit;
import modele.VenteC;


public class VenteCService {
	
	  
    //Enregistrer vente sur place
	public void ajouterVC(VenteC vc) {
		
		//connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();
        
        //Requete
        String req = "INSERT INTO venteC(id, prixU, tel, numeroC, dateC, article) VALUES ('"+vc.getId()+"', '"+vc.getPrixU()+"','"+vc.getTel()+"',  '"+vc.getNumeroC()+"', '"+vc.getDateC()+"', '"+vc.getArticle()+"') ";
        
        try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur sur la requete d insertion");
            e.printStackTrace();
        }
	}
	
	//Modifier vente sur place
	public void ModifierVC(VenteC vc) {
		
		//connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();
		
		//Requete
		String req = "UPDATE venteC SET dateC='"+vc.getDateC()+"', numeroC='"+vc.getNumeroC()+"', article='"+vc.getArticle()+"', prixU='"+vc.getPrixU()+"' WHERE id='"+vc.getId()+"'  " ;
		
		try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	//Annuler/Supprimer vente sur place
	public void AnnulerVC(int id) {
		
		//connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();
		
		//Requete
		String req = "DELETE FROM venteC WHERE id='"+id+"' " ;
		
		try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	
	//Liste des ventes sur place
	public ResultSet listerVC() {
		ResultSet rs = null;
			
		//connection base
	    ConnexionBase cb = new ConnexionBase();
	    cb.conn();
	        
	    //Requete
	    String req = "SELECT * FROM venteC ORDER BY dateC ";
	        
	    try {
            rs = cb.st.executeQuery(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return rs;

		}
	
	//Montant total des ventes sur place
	public int TotalVC() {
		ResultSet rs = null;
        int s = 0;
		
		//connection base
	    ConnexionBase cb = new ConnexionBase();
	    cb.conn();
		
		//Requete
	    String req = "SELECT SUM(prixU) as total FROM venteC ";
		
		try {
            rs = cb.st.executeQuery(req);
            s = rs.getInt("total");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return s;
	}
	}
