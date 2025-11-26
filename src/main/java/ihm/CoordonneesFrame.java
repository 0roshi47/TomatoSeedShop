package ihm;

import java.awt.*;
import java.io.*;
import java.util.Map;
import javax.swing.*;
import modèle.*;

public class CoordonneesFrame extends JDialog {

    private JTextField txtNom, txtPrenom, txtAdresse, txtVille, txtCP, txtEmail;

    public CoordonneesFrame(JFrame parent) {
        super(parent, "Validation de commande", true);
        setSize(500, 600);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        addLabelField(mainPanel, "Nom :", txtNom = new JTextField());
        addLabelField(mainPanel, "Prénom :", txtPrenom = new JTextField());
        addLabelField(mainPanel, "Adresse :", txtAdresse = new JTextField());
        addLabelField(mainPanel, "Code Postal :", txtCP = new JTextField());
        addLabelField(mainPanel, "Ville :", txtVille = new JTextField());
        addLabelField(mainPanel, "Email :", txtEmail = new JTextField());

        // Boutons
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnValider = new JButton("Confirmer et Payer");
        JButton btnAnnuler = new JButton("Annuler");

        btnValider.addActionListener(e -> validerEtGenererFacture());
        btnAnnuler.addActionListener(e -> dispose());

        btnPanel.add(btnValider);
        btnPanel.add(btnAnnuler);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(btnPanel);
    }

    private void addLabelField(JPanel p, String label, JTextField field) {
        JPanel row = new JPanel(new BorderLayout());
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        row.add(new JLabel(label), BorderLayout.WEST);
        row.add(field, BorderLayout.CENTER);
        p.add(row);
        p.add(Box.createVerticalStrut(10));
    }

    private void validerEtGenererFacture() {
        Panier panier = accueil.getPanier();
        
        // 1. Mise à jour des stocks en mémoire
        panier.validerLaCommande();
        
        // 2. Sauvegarde JSON (Chemin à adapter selon votre structure)
        String chemin = "src/main/resources/data/tomates.json";
        OutilsBaseDonneesTomates.sauvegarderBaseDeTomates(accueil.getBaseDeDonnees(), chemin);

        // 3. Génération HTML
        genererHTML(panier);

        // 4. Reset
        panier.viderPanier();
        accueil.updateBtnPanier();
        
        JOptionPane.showMessageDialog(this, "Commande validée ! La facture a été générée.");
        dispose();
    }

    private void genererHTML(Panier panier) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><h1>Facture Ô'Tomates</h1>");
        html.append("<p>Client : ").append(txtNom.getText()).append(" ").append(txtPrenom.getText()).append("</p>");
        html.append("<table border='1' width='100%'><tr><th>Produit</th><th>Qté</th><th>Prix</th></tr>");
        
        for(Map.Entry<Tomate, Integer> entry : panier.getContenu().entrySet()) {
            Tomate t = entry.getKey();
            html.append("<tr><td>").append(t.getDésignation())
                .append("</td><td>").append(entry.getValue())
                .append("</td><td>").append(t.getPrixTTC() * entry.getValue()).append("€</td></tr>");
        }
        
        html.append("</table>");
        html.append("<h3>Total Payé : ").append(panier.total() + 5.5).append("€ (dont 5.5€ frais port)</h3>");
        html.append("</body></html>");

        try {
            File f = new File("facture.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(html.toString());
            writer.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}