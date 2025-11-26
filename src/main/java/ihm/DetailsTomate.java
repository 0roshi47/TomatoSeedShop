package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import modèle.*;

public class DetailsTomate extends JDialog {

    private static final long serialVersionUID = 1L;
    private JSpinner spinnerQuantite;

    // Constructeur prend l'objet Tomate direct
    public DetailsTomate(Tomate tomate) {
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Détail : " + tomate.getDésignation());
        setBounds(100, 100, 600, 450);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // --- HAUT : Image et Infos ---
        JPanel panelInfo = new JPanel(new GridLayout(1, 2, 10, 0));
        getContentPane().add(panelInfo, BorderLayout.CENTER);

        // Gauche : Image + Stock
        JPanel panelGauche = new JPanel(new BorderLayout());
        JPanel panelImage = new JPanel();
        panelImage.setBorder(new TitledBorder(new EtchedBorder(), tomate.getDésignation()));
        
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/Tomates200x200/" + tomate.getNomImage() + ".jpg"));
            panelImage.add(new JLabel(icon));
        } catch (Exception e) { panelImage.add(new JLabel("Image non trouvée")); }
        
        panelGauche.add(panelImage, BorderLayout.CENTER);
        
        // Indicateur de stock
        JLabel lblStock = new JLabel();
        lblStock.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
        if (tomate.getStock() > 0) {
            lblStock.setText("En stock (" + tomate.getStock() + ")");
            lblStock.setForeground(new Color(0, 128, 0));
        } else {
            lblStock.setText("Rupture de stock");
            lblStock.setForeground(Color.RED);
        }
        panelGauche.add(lblStock, BorderLayout.SOUTH);
        panelInfo.add(panelGauche);

        // Droite : Description + Similaires
        JPanel panelDroite = new JPanel(new BorderLayout());
        JTextArea txtDesc = new JTextArea(tomate.getDescription().replace("\\r\\n", "\n"));
        txtDesc.setWrapStyleWord(true);
        txtDesc.setLineWrap(true);
        txtDesc.setEditable(false);
        txtDesc.setBorder(new TitledBorder("Description"));
        panelDroite.add(new JScrollPane(txtDesc), BorderLayout.CENTER);

        JComboBox<String> comboSimilaires = new JComboBox<>();
        comboSimilaires.addItem("Produits similaires...");
        for(Tomate t : tomate.getTomatesApparentées()) {
            comboSimilaires.addItem(t.getDésignation());
        }
        comboSimilaires.addActionListener(e -> {
            if(comboSimilaires.getSelectedIndex() > 0) {
                String nom = (String) comboSimilaires.getSelectedItem();
                // Ouvre la page de la tomate similaire depuis la base centrale
                Tomate similar = accueil.getBaseDeDonnees().getTomate(nom);
                if(similar != null) {
                    dispose(); // Ferme l'actuelle
                    new DetailsTomate(similar).setVisible(true);
                }
            }
        });
        panelDroite.add(comboSimilaires, BorderLayout.SOUTH);
        panelInfo.add(panelDroite);

        // --- BAS : Achat ---
        JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        getContentPane().add(panelBas, BorderLayout.SOUTH);

        JLabel lblPrix = new JLabel("Prix : " + tomate.getPrixTTC() + "€");
        lblPrix.setFont(new Font("Arial", Font.BOLD, 16));
        panelBas.add(lblPrix);

        spinnerQuantite = new JSpinner(new SpinnerNumberModel(1, 1, Math.max(1, tomate.getStock()), 1));
        panelBas.add(new JLabel("Qté:"));
        panelBas.add(spinnerQuantite);

        JButton btnAjouter = new JButton("Ajouter au panier");
        btnAjouter.addActionListener(e -> {
            int qte = (int) spinnerQuantite.getValue();
            accueil.getPanier().ajouterTomate(tomate, qte);
            accueil.updateBtnPanier();
            dispose();
        });
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(e -> dispose());

        if (tomate.getStock() == 0) {
            btnAjouter.setEnabled(false);
            spinnerQuantite.setEnabled(false);
        }

        panelBas.add(btnAjouter);
        panelBas.add(btnAnnuler);
    }
}