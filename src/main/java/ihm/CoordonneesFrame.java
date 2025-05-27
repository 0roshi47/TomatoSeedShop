package ihm;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CoordonneesFrame extends JFrame {
    public CoordonneesFrame() {
        setTitle("Ô'Tomates");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 550);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblCoordonnees = new JLabel("Vos coordonnées");
        lblCoordonnees.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCoordonnees.setBounds(160, 10, 200, 30);
        getContentPane().add(lblCoordonnees);

        // Champs de saisie
        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(30, 60, 100, 20);
        getContentPane().add(lblNom);

        JTextField txtNom = new JTextField();
        txtNom.setBounds(150, 60, 300, 20);
        getContentPane().add(txtNom);

        JLabel lblPrenom = new JLabel("Prénom :");
        lblPrenom.setBounds(30, 90, 100, 20);
        getContentPane().add(lblPrenom);

        JTextField txtPrenom = new JTextField();
        txtPrenom.setBounds(150, 90, 300, 20);
        getContentPane().add(txtPrenom);

        JLabel lblAdresse1 = new JLabel("Adresse 1 :");
        lblAdresse1.setBounds(30, 120, 100, 20);
        getContentPane().add(lblAdresse1);

        JTextField txtAdresse1 = new JTextField();
        txtAdresse1.setBounds(150, 120, 300, 20);
        getContentPane().add(txtAdresse1);

        JLabel lblAdresse2 = new JLabel("Adresse 2 :");
        lblAdresse2.setBounds(30, 150, 100, 20);
        getContentPane().add(lblAdresse2);

        JTextField txtAdresse2 = new JTextField();
        txtAdresse2.setBounds(150, 150, 300, 20);
        getContentPane().add(txtAdresse2);

        JLabel lblCodePostal = new JLabel("Code postal :");
        lblCodePostal.setBounds(30, 180, 100, 20);
        getContentPane().add(lblCodePostal);

        JTextField txtCodePostal = new JTextField();
        txtCodePostal.setBounds(150, 180, 300, 20);
        getContentPane().add(txtCodePostal);

        JLabel lblVille = new JLabel("Ville :");
        lblVille.setBounds(30, 210, 100, 20);
        getContentPane().add(lblVille);

        JTextField txtVille = new JTextField();
        txtVille.setBounds(150, 210, 300, 20);
        getContentPane().add(txtVille);

        JLabel lblTelephone = new JLabel("Téléphone :");
        lblTelephone.setBounds(30, 240, 100, 20);
        getContentPane().add(lblTelephone);

        JTextField txtTelephone = new JTextField();
        txtTelephone.setBounds(150, 240, 300, 20);
        getContentPane().add(txtTelephone);

        JLabel lblMail = new JLabel("Mail :");
        lblMail.setBounds(30, 270, 100, 20);
        getContentPane().add(lblMail);

        JTextField txtMail = new JTextField();
        txtMail.setBounds(150, 270, 300, 20);
        getContentPane().add(txtMail);

        // === Panel : Moyen de paiement ===
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

        // === Panel : Newsletter ===
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

        // Boutons
        JButton btnOK = new JButton("OK");
        btnOK.setBounds(270, 460, 80, 30);
        getContentPane().add(btnOK);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(360, 460, 100, 30);
        getContentPane().add(btnAnnuler);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CoordonneesFrame().setVisible(true);
        });
    }
}
