package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coordonnees extends JFrame {
    private JTextField textNom, textPrenom, textAdresse1, textAdresse2, textCodePostal, textVille, textTelephone, textMail;
    private JRadioButton cardButton, paypalButton, chequeButton, yesButton, noButton;

    public Coordonnees() {
        setTitle("Formulaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(680, 550));

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label "Coordonnées"
        JLabel labelCoordonnees = new JLabel("Coordonnées");
        labelCoordonnees.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        labelCoordonnees.setHorizontalAlignment(SwingConstants.CENTER);
        labelCoordonnees.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(labelCoordonnees, gbc);

        // Form Fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        panel.add(new JLabel("Nom :"), gbc);
        textNom = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textNom, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Prénom :"), gbc);
        textPrenom = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textPrenom, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Adresse 1 :"), gbc);
        textAdresse1 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textAdresse1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Adresse 2 :"), gbc);
        textAdresse2 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textAdresse2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Code postal :"), gbc);
        textCodePostal = new JTextField(10);
        gbc.gridx = 1;
        panel.add(textCodePostal, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Ville :"), gbc);
        textVille = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textVille, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Téléphone :"), gbc);
        textTelephone = new JTextField(15);
        gbc.gridx = 1;
        panel.add(textTelephone, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Mail :"), gbc);
        textMail = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textMail, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Moyen de paiement :"), gbc);
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cardButton = new JRadioButton("Carte de crédit");
        paypalButton = new JRadioButton("Paypal");
        chequeButton = new JRadioButton("Paiement par chèque");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cardButton);
        paymentGroup.add(paypalButton);
        paymentGroup.add(chequeButton);
        cardButton.setSelected(true);
        paymentPanel.add(cardButton);
        paymentPanel.add(paypalButton);
        paymentPanel.add(chequeButton);
        gbc.gridx = 1;
        panel.add(paymentPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Abonnement à notre Newsletter :"), gbc);
        JPanel newsletterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        yesButton = new JRadioButton("Oui");
        noButton = new JRadioButton("Non");
        ButtonGroup newsletterGroup = new ButtonGroup();
        newsletterGroup.add(yesButton);
        newsletterGroup.add(noButton);
        yesButton.setSelected(true);
        newsletterPanel.add(yesButton);
        newsletterPanel.add(noButton);
        gbc.gridx = 1;
        panel.add(newsletterPanel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Annuler");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(buttonPanel, gbc);

        // Add action listener for OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textNom.getText();
                String prenom = textPrenom.getText();
                String adresse1 = textAdresse1.getText();
                String adresse2 = textAdresse2.getText();
                String codePostal = textCodePostal.getText();
                String ville = textVille.getText();
                String telephone = textTelephone.getText();
                String mail = textMail.getText();

                Facture facture = new Facture(nom, prenom, adresse1, adresse2, codePostal, ville, telephone, mail);
                facture.setVisible(true);
            }
        });

        // Close the application on cancel
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coordonnees().setVisible(true);
            }
        });
    }
}
