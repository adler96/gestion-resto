package service;

import java.sql.ResultSet;
import dao.ConnexionBase;
import modele.VenteP;

public class TraitementP {
    
    //Enregistrer vente sur place
	public void ajouterVP(VenteP vp) {
		
		//connection base
        ConnectionBase cb = new ConnectionBase();
        cb.connect();
        
        //Requete
        String req = "INSERT INTO venteP(id, dateVSP, numeroVSP, article, prixU) VALUES ('"+vp.getId()+"', '"+vp.getDateVSP()+"', '"+vp.getNumeroVSP()+"', '"+vp.getArticle()+"', '"+vp.getPrixU()+"') ";
        
        try {
            //executer requete
            cb.st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VenteP.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	//Modifier vente sur place
	public void ModifierVP(VenteP vp) {
		
		//connection base
        ConnectionBase cb = new ConnectionBase();
        cb.connect();
		
		//Requete
		String req = "UPDATE venteP SET dateVSP='"+vp.getDateVSP()+"', numeroVSP='"+vp.getNumeroVSP()+"', article='"+vp.getArticle()+"', prixU='"+vp.getPrixU()+"' WHERE id='"+vp.getId()+"'  " ;
		
		try {
        	//executer requete
        	cb.st.executeUpdate(req);
		} catch (SQLException ex) {
        	Logger.getLogger(VenteP.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//Annuler/Supprimer vente sur place
	public void AnnulerVP(int id) {
		
		//connection base
        ConnectionBase cb = new ConnectionBase();
        cb.connect();
		
		//Requete
		String req = "DELETE FROM venteP WHERE id='"+id+"' " ;
		
		try {
        	//executer requete
        	cb.st.executeUpdate(req);
		} catch (SQLException ex) {
        	Logger.getLogger(VenteP.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	//Liste des ventes sur place
	public ResultSet listerVP() {
		ResultSet rs = null;
			
		//connection base
	    ConnectionBase cb = new ConnectionBase();
	    cb.connect();
	        
	    //Requete
	    String req = "SELECT * FROM venteP ORDER BY dateVSP ";
	        
	    try {
            //executer requete
            cb.st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VenteP.class.getName()).log(Level.SEVERE, null, ex);
        }
	    
	    return rs;

		}
	
	//Montant total des ventes sur place
	public ResultSet TotalVP() {
		ResultSet rs = null;
		
		//connection base
	    ConnectionBase cb = new ConnectionBase();
	    cb.connect();
		
		//Requete
	    String req = "SELECT SUM(prixU) FROM venteP ";
		
		try {
        	//executer requete
        	cb.st.executeUpdate(req);
		} catch (SQLException ex) {
        	Logger.getLogger(VenteP.class.getName()).log(Level.SEVERE, null, ex);
		}
	    
	    return rs;
	}

}
