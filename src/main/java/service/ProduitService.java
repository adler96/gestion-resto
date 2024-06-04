package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import dao.ConnexionBase;

public class ProduitService {

    public int quantiteVendueParProduit(int id) {
        int quantite = 0;
        ConnexionBase cb = new ConnexionBase();
        Connection conn = cb.conn();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            String requete = "SELECT COUNT(*) AS total FROM VenteC WHERE article_id = " + id;
            rs = stmt.executeQuery(requete);
            if (rs.next()) {
                quantite = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quantite;
    }

    public int montantTotalVentes() {
        int montant = 0;
        ConnexionBase cb = new ConnexionBase();
        Connection conn = cb.conn();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            String requete = "SELECT SUM(pu) AS total_sum FROM VenteC";
            rs = stmt.executeQuery(requete);
            if (rs.next()) {
                montant = rs.getInt("total_sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return montant;
    }

    public int montantTotalVentesParPeriode(Date periodeDebut, Date periodeFin) {
        int montant = 0;
        ConnexionBase cb = new ConnexionBase();
        Connection conn = cb.conn();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String debut = sdf.format(periodeDebut);
            String fin = sdf.format(periodeFin);
            String requete = "SELECT SUM(pu) AS total_sum FROM VenteC WHERE date >= '" + debut + "' AND date <= '" + fin + "'";
            rs = stmt.executeQuery(requete);
            if (rs.next()) {
                montant = rs.getInt("total_sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return montant;
    }
}
