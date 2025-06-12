package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CoordonneesFrame extends JDialog {
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtAdresse1;
    private JTextField txtAdresse2;
    private JTextField txtCodePostal;
    private JTextField txtVille;
    private JTextField txtTelephone;
    private JTextField txtMail;

    public CoordonneesFrame(JFrame parent) {
        super(parent, "Ô'Tomates", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(520, 550);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);

        JLabel lblCoordonnees = new JLabel("Vos coordonnées");
        lblCoordonnees.setForeground(new Color(34, 139, 34));
        lblCoordonnees.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCoordonnees.setBounds(160, 10, 200, 30);
        getContentPane().add(lblCoordonnees);

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(30, 60, 100, 20);
        getContentPane().add(lblNom);

        txtNom = new JTextField();
        txtNom.setBounds(150, 60, 300, 20);
        getContentPane().add(txtNom);

        JLabel lblPrenom = new JLabel("Prénom :");
        lblPrenom.setBounds(30, 90, 100, 20);
        getContentPane().add(lblPrenom);

        txtPrenom = new JTextField();
        txtPrenom.setBounds(150, 90, 300, 20);
        getContentPane().add(txtPrenom);

        JLabel lblAdresse1 = new JLabel("Adresse 1 :");
        lblAdresse1.setBounds(30, 120, 100, 20);
        getContentPane().add(lblAdresse1);

        txtAdresse1 = new JTextField();
        txtAdresse1.setBounds(150, 120, 300, 20);
        getContentPane().add(txtAdresse1);

        JLabel lblAdresse2 = new JLabel("Adresse 2 :");
        lblAdresse2.setBounds(30, 150, 100, 20);
        getContentPane().add(lblAdresse2);

        txtAdresse2 = new JTextField();
        txtAdresse2.setBounds(150, 150, 300, 20);
        getContentPane().add(txtAdresse2);

        JLabel lblCodePostal = new JLabel("Code postal :");
        lblCodePostal.setBounds(30, 180, 100, 20);
        getContentPane().add(lblCodePostal);

        txtCodePostal = new JTextField();
        txtCodePostal.setBounds(150, 180, 300, 20);
        getContentPane().add(txtCodePostal);

        JLabel lblVille = new JLabel("Ville :");
        lblVille.setBounds(30, 210, 100, 20);
        getContentPane().add(lblVille);

        txtVille = new JTextField();
        txtVille.setBounds(150, 210, 300, 20);
        getContentPane().add(txtVille);

        JLabel lblTelephone = new JLabel("Téléphone :");
        lblTelephone.setBounds(30, 240, 100, 20);
        getContentPane().add(lblTelephone);

        txtTelephone = new JTextField();
        txtTelephone.setBounds(150, 240, 300, 20);
        getContentPane().add(txtTelephone);

        JLabel lblMail = new JLabel("Mail :");
        lblMail.setBounds(30, 270, 100, 20);
        getContentPane().add(lblMail);

        txtMail = new JTextField();
        txtMail.setBounds(150, 270, 300, 20);
        getContentPane().add(txtMail);

        JPanel panelPaiement = new JPanel();
        panelPaiement.setForeground(new Color(34, 139, 34));
        panelPaiement.setBorder(BorderFactory.createTitledBorder("Moyen de paiement"));
        panelPaiement.setBounds(30, 310, 420, 60);
        getContentPane().add(panelPaiement);
        panelPaiement.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JRadioButton rdbCarte = new JRadioButton("Carte de crédit");
        JRadioButton rdbPaypal = new JRadioButton("Paypal");
        JRadioButton rdbCheque = new JRadioButton("Chèque");

        panelPaiement.add(rdbCarte);
        panelPaiement.add(rdbPaypal);
        panelPaiement.add(rdbCheque);

        ButtonGroup bgPaiement = new ButtonGroup();
        bgPaiement.add(rdbCarte);
        bgPaiement.add(rdbPaypal);
        bgPaiement.add(rdbCheque);

        JPanel panelNewsletter = new JPanel();
        panelNewsletter.setBorder(BorderFactory.createTitledBorder("Abonnement à notre Newsletter"));
        panelNewsletter.setBounds(30, 380, 420, 60);
        getContentPane().add(panelNewsletter);
        panelNewsletter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JRadioButton rdbOui = new JRadioButton("Oui");
        JRadioButton rdbNon = new JRadioButton("Non");

        panelNewsletter.add(rdbOui);
        panelNewsletter.add(rdbNon);

        ButtonGroup bgNewsletter = new ButtonGroup();
        bgNewsletter.add(rdbOui);
        bgNewsletter.add(rdbNon);

        JButton btnOK = new JButton("OK");
        btnOK.setBounds(270, 460, 80, 30);
        getContentPane().add(btnOK);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(360, 460, 100, 30);
        getContentPane().add(btnAnnuler);

        btnAnnuler.addActionListener(e -> dispose());

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                String prenom = txtPrenom.getText();
                String adresse1 = txtAdresse1.getText();
                String adresse2 = txtAdresse2.getText();
                String codePostal = txtCodePostal.getText();
                String ville = txtVille.getText();
                String telephone = txtTelephone.getText();
                String mail = txtMail.getText();
                double total = 5.5 + accueil.getPanier().total();
        		double totalArrondi = Math.round(total * 100.0) / 100.0;

                String moyenPaiement = "";
                if (rdbCarte.isSelected()) moyenPaiement = "Carte de crédit";
                else if (rdbPaypal.isSelected()) moyenPaiement = "Paypal";
                else if (rdbCheque.isSelected()) moyenPaiement = "Chèque";

                String abonnementNewsletter = rdbOui.isSelected() ? "Oui" : "Non";

                String htmlContent = "<html>" +
                        "<head>" +
                        "<title>Facture</title>" +
                        "<style>" +
                        "body { font-family: 'Segoe UI', sans-serif; background-color: #fff8f0; margin: 0; padding: 40px; color: #3e3e3e; }" +
                        "h1 { text-align: center; color: #b22222; margin-bottom: 30px; font-size: 32px; }" +
                        "table { width: 100%; border-collapse: collapse; margin-bottom: 30px; }" +
                        "td.label { font-weight: bold; background-color: #f0e5d8; padding: 10px; width: 35%; color: #5a2d0c; }" +
                        "td.value { background-color: #fffdfb; padding: 10px; color: #3e3e3e; }" +
                        "tr:nth-child(even) td { background-color: #f9f3ee; }" +
                        ".print-btn { background-color: #b22222; color: white; padding: 12px 20px; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; margin: 30px auto 0; display: block; font-weight: bold; }" +
                        ".print-btn:hover { background-color: #a11c1c; }" +
                        ".footer { text-align: center; font-size: 12px; color: #888; margin-top: 40px; }" +
                        "@media print { .print-btn { display: none; } body { padding: 0; background: white; } }" +
                        "</style>" +
                        "</head>" +
                        "<body>" +
                        "<h1>🍅 Facture</h1>" +
                        "<table>" +
                        "<tr><td class='label'>Nom :</td><td class='value'>" + nom + "</td></tr>" +
                        "<tr><td class='label'>Prénom :</td><td class='value'>" + prenom + "</td></tr>" +
                        "<tr><td class='label'>Adresse 1 :</td><td class='value'>" + adresse1 + "</td></tr>" +
                        "<tr><td class='label'>Adresse 2 :</td><td class='value'>" + adresse2 + "</td></tr>" +
                        "<tr><td class='label'>Code postal :</td><td class='value'>" + codePostal + "</td></tr>" +
                        "<tr><td class='label'>Ville :</td><td class='value'>" + ville + "</td></tr>" +
                        "<tr><td class='label'>Téléphone :</td><td class='value'>" + telephone + "</td></tr>" +
                        "<tr><td class='label'>Mail :</td><td class='value'>" + mail + "</td></tr>" +
                        "<tr><td class='label'>Moyen de paiement :</td><td class='value'>" + moyenPaiement + "</td></tr>" +
                        "<tr><td class='label'>Abonnement Newsletter :</td><td class='value'>" + abonnementNewsletter + "</td></tr>" +
                        "</table>" +
                        "<tr><td class='label'>total panier TTC:</td><td class='value'>"+totalArrondi + " €"+"</td></tr>"+
                        "<button class='print-btn' onclick='window.print()'>🖨️ Imprimer la facture</button>" +
                        "<div class='footer'>Merci pour votre confiance!</div>" +
                        "</body>" +
                        "</html>";

                try {
                    File htmlFile = new File("facture.html");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile));
                    writer.write(htmlContent);
                    writer.close();

                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(CoordonneesFrame.this, "Erreur lors de la création de la facture.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CoordonneesFrame dialog = new CoordonneesFrame(null);
            dialog.setVisible(true);
        });
    }
}
