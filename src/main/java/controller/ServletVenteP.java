package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.ProduitService;
import service.TraitementP;
import modele.VenteP;
import modele.Produit;

@WebServlet("/ServletVenteP")
public class ServletVenteP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletVenteP() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ProduitService produitService = new ProduitService();
        TraitementP traitementP = new TraitementP();

        try {
            String idParam = request.getParameter("id");
            String startDateParam = request.getParameter("startDate");
            String endDateParam = request.getParameter("endDate");

            // ProduitService calls
            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                int quantite = produitService.quantiteVendueParProduit(id);
                out.println("<h1>Quantité vendue pour le produit avec ID " + id + " : " + quantite + "</h1>");
            }

            int montantTotal = produitService.montantTotalVentes();
            out.println("<h1>Montant total des ventes : " + montantTotal + "</h1>");

            if (startDateParam != null && endDateParam != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date periodeDebut = sdf.parse(startDateParam);
                Date periodeFin = sdf.parse(endDateParam);
                int montantPeriode = produitService.montantTotalVentesParPeriode(periodeDebut, periodeFin);
                out.println("<h1>Montant total des ventes pour la période du " + startDateParam + " au " + endDateParam + " : " + montantPeriode + "</h1>");
            }

            // TraitementP calls
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "ajouter":
                        int id = Integer.parseInt(request.getParameter("id"));
                        double prixU = Double.parseDouble(request.getParameter("prixU"));
                        String numeroVSP = request.getParameter("numeroVSP");
                        String dateVSPStr = request.getParameter("dateVSP");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateVSP = sdf.parse(dateVSPStr);
                        String articleName = request.getParameter("article");

                        Produit article = new Produit(); // Créez un objet Produit vide
                        article.setLibelle(articleName); // Définissez le nom de l'article

                        // Créez un objet VenteP avec le constructeur approprié
                        VenteP vente = new VenteP(0, prixU, numeroVSP, dateVSP, article);
                        traitementP.ajouterVP(vente);
                        out.println("<h1>Vente ajoutée avec succès</h1>");
                        break;
                    // Traitez les autres cas de manière similaire
                }
            }
        } catch (NumberFormatException | ParseException e) {
            out.println("<h1>Paramètres invalides</h1>");
            e.printStackTrace(out);
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
