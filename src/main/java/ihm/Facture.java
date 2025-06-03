package ihm;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Facture extends JDialog {

    private String nom;
    private String prenom;
    private String adresse1; 
    private String adresse2;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;

    public Facture() {

        setSize(700, 800);

        // Generate the invoice
        //genererFacture(nom, prenom, adresse1, adresse2, codePostal, ville, telephone, email);
    }

    private void genererFacture(String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville, String telephone, String email) {
        // Format the date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy 'à' HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        String dateFormatted = dateFormat.format(new Date());

        // Determine if it's daylight saving time
        boolean isDaylight = TimeZone.getDefault().inDaylightTime(new Date());
        String heure = isDaylight ? "d'été" : "d'hiver";

        // Generate the invoice text
        String facture = "TomatoSeedShop, redécouvrez le gout des tomates anciennes\n";
        facture += "Commande du " + dateFormatted + " heure " + heure + " d'Europe centrale\n\n";
        facture += "Nom : " + nom + "\n";
        facture += "Prénom : " + prenom + "\n";
        facture += "Adresse : " + adresse1 + (adresse2.isEmpty() ? "" : ", " + adresse2) + ", " + codePostal + " " + ville + "\n";
        facture += "Téléphone : " + telephone + "\n";
        facture += "Mèl : " + email + "\n\n";

        facture += String.format("%-30s %-15s %-10s %-10s\n", "Produit", "Prix unitaire", "Quantité", "Prix TTC");
        facture += "-------------------------------------------------------------------\n";
    
    }
}
