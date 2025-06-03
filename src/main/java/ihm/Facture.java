package ihm;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Facture extends JFrame {
    private JTextArea txtFacture;
    
    private String nom;
    private String prenom;
    private String adresse1; 
    private String adresse2;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    
    public Facture() {
        setTitle("Votre facture");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Votre facture", JLabel.CENTER);
        titleLabel.setIcon(new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png")));
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        titleLabel.setForeground(new Color(34, 139, 34));
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Message Label
        JLabel messageLabel = new JLabel("Merci de votre visite !", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        messageLabel.setForeground(new Color(46, 139, 87));
        titlePanel.add(messageLabel, BorderLayout.SOUTH);

        getContentPane().add(titlePanel, BorderLayout.NORTH);

        // Invoice Text Area
        txtFacture = new JTextArea();
        txtFacture.setEditable(false);
        txtFacture.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtFacture);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Buttons for print and quit
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("imprimer");
        JButton quitButton = new JButton("Quitter");
        quitButton.setBackground(new Color(255, 182, 193));

        printButton.addActionListener(e -> {
            // Implement printing functionality
        });

        quitButton.addActionListener(e -> dispose());

        buttonPanel.add(printButton);
        buttonPanel.add(quitButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

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
     

        txtFacture.setText("Tomate Ananas - 250 g          5,10 €          1          5,99      \r\n");
    }

}
