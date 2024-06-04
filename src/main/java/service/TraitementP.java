package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnexionBase;
import modele.VenteP;

public class TraitementP {

    // Enregistrer vente sur place
    public void ajouterVP(VenteP vp) {
        // connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();

        // Requete
        String req = "INSERT INTO venteP(id, dateVSP, numeroVSP, article, prixU) VALUES ('"
                + vp.getId() + "', '" + vp.getDateVSP() + "', '" + vp.getNumeroVSP() + "', '" + vp.getArticle() + "', '"
                + vp.getPrixU() + "') ";

        try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erreur sur la requete d insertion");
            e.printStackTrace();
        }
    }

    // Modifier vente sur place
    public void ModifierVP(VenteP vp) {
        // connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();

        // Requete
        String req = "UPDATE venteP SET dateVSP='" + vp.getDateVSP() + "', numeroVSP='" + vp.getNumeroVSP()
                + "', article='" + vp.getArticle() + "', prixU='" + vp.getPrixU() + "' WHERE id='" + vp.getId()
                + "'  ";

        try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Annuler/Supprimer vente sur place
    public void AnnulerVP(int id) {
        // connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();

        // Requete
        String req = "DELETE FROM venteP WHERE id='" + id + "' ";

        try {
            cb.st.executeUpdate(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Liste des ventes sur place
    public ResultSet listerVP() {
        ResultSet rs = null;

        // connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();

        // Requete
        String req = "SELECT * FROM venteP ORDER BY dateVSP ";

        try {
            rs = cb.st.executeQuery(req);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rs;

    }

    // Montant total des ventes sur place
    public int TotalVP() {
        ResultSet rs = null;
        int s = 0;

        // connection base
        ConnexionBase cb = new ConnexionBase();
        cb.conn();

        // Requete
        String req = "SELECT SUM(prixU) as total FROM venteP ";

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
