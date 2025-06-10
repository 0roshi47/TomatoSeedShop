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
        panelPaiement.setLayout(null);
        getContentPane().add(panelPaiement);

        JRadioButton rdbCarte = new JRadioButton("Carte de crédit");
        rdbCarte.setBounds(10, 20, 120, 20);
        panelPaiement.add(rdbCarte);

        JRadioButton rdbPaypal = new JRadioButton("Paypal");
        rdbPaypal.setBounds(150, 20, 80, 20);
        panelPaiement.add(rdbPaypal);

        JRadioButton rdbCheque = new JRadioButton("Chèque");
        rdbCheque.setBounds(240, 20, 80, 20);
        panelPaiement.add(rdbCheque);

        ButtonGroup bgPaiement = new ButtonGroup();
        bgPaiement.add(rdbCarte);
        bgPaiement.add(rdbPaypal);
        bgPaiement.add(rdbCheque);

        JPanel panelNewsletter = new JPanel();
        panelNewsletter.setBorder(BorderFactory.createTitledBorder("Abonnement à notre Newsletter"));
        panelNewsletter.setBounds(30, 380, 420, 60);
        panelNewsletter.setLayout(null);
        getContentPane().add(panelNewsletter);

        JRadioButton rdbOui = new JRadioButton("Oui");
        rdbOui.setBounds(10, 20, 60, 20);
        panelNewsletter.add(rdbOui);

        JRadioButton rdbNon = new JRadioButton("Non");
        rdbNon.setBounds(80, 20, 60, 20);
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

                String htmlContent = "<html>" +
                        "<head>" +
                        "<title>Facture</title>" +
                        "<style>" +
                        "body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f4f4f4; }" +
                        "h1 { text-align: center; color: #333; }" +
                        "p { text-align: center; font-size: 16px; line-height: 1.5; }" +
                        ".label { font-weight: bold; }" +
                        "</style>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Facture</h1>" +
                        "<p class='label'>Nom :</p> <p>" + nom + "</p>" +
                        "<p class='label'>Prénom :</p> <p>" + prenom + "</p>" +
                        "<p class='label'>Adresse 1 :</p> <p>" + adresse1 + "</p>" +
                        "<p class='label'>Adresse 2 :</p> <p>" + adresse2 + "</p>" +
                        "<p class='label'>Code postal :</p> <p>" + codePostal + "</p>" +
                        "<p class='label'>Ville :</p> <p>" + ville + "</p>" +
                        "<p class='label'>Téléphone :</p> <p>" + telephone + "</p>" +
                        "<p class='label'>Mail :</p> <p>" + mail + "</p>" +
                        "</div>" +
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
