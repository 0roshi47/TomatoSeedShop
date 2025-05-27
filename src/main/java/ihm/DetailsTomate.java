package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modèle.Panier;

public class DetailsTomate extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the dialog.
     */
    public DetailsTomate(Panier panier) {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Détail de la tomate");
        setBounds(100, 100, 450, 316);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        String désignation = "Tomates de test";
        String prix = "10 €";
        int maxQuantité = 10;

        JPanel panelButtons = new JPanel();
        contentPane.add(panelButtons, BorderLayout.SOUTH);

        JButton btnAjouter = new JButton("Ajouter au panier");
        panelButtons.add(btnAjouter);

        JButton btnAnnuler = new JButton("Annuler");
        panelButtons.add(btnAnnuler);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelGauche = new JPanel();
        panel.add(panelGauche);
        panelGauche.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panelGauche.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JLabel lblDésignation = new JLabel("Tomates de test");
        panel_1.add(lblDésignation, BorderLayout.NORTH);

        JLabel lblImage = new JLabel("");
        ImageIcon image = new ImageIcon(getClass().getResource("/images/Tomates200x200/ananas-2-scaled.jpg"));
        lblImage.setIcon(image);
        panel_1.add(lblImage, BorderLayout.CENTER);

        JComboBox<String> produitsSimilaires = new JComboBox<>();
        produitsSimilaires.setToolTipText("");
        produitsSimilaires.setModel(new DefaultComboBoxModel<>(new String[] {"Produits similaires", "Truc", "Bidule", "Machin", "Chose"}));
        panelGauche.add(produitsSimilaires, BorderLayout.SOUTH);

        JLabel lblDisponibilite = new JLabel("En rupture");
        panelGauche.add(lblDisponibilite, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JTextArea textArea = new JTextArea();
        panel_2.add(textArea, BorderLayout.NORTH);
    }
}