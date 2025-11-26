package ihm;

import java.awt.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modèle.*;

public class PagePanier extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable tableProduits;
    private JTextField txtTotalHT, txtTotalTTC;
    
    public PagePanier() {
        setModal(true);
        setTitle("Votre Panier");
        setBounds(100, 100, 700, 500);
        
        JPanel contentPane = new JPanel(new BorderLayout(0, 0));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Titre
        JLabel lblTitre = new JLabel("VOTRE PANIER", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(new Color(0, 128, 0));
        contentPane.add(lblTitre, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Produit", "Prix Unitaire", "Quantité", "Total Ligne"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tableProduits = new JTable(model);
        tableProduits.setRowHeight(30);
        contentPane.add(new JScrollPane(tableProduits), BorderLayout.CENTER);

        // Remplissage
        Panier panier = accueil.getPanier();
        for (Map.Entry<Tomate, Integer> entry : panier.getContenu().entrySet()) {
            Tomate t = entry.getKey();
            int qte = entry.getValue();
            double totalLigne = Math.round(t.getPrixTTC() * qte * 100.0) / 100.0;
            model.addRow(new Object[]{t.getDésignation(), t.getPrixTTC() + "€", qte, totalLigne + "€"});
        }

        // Bas (Totaux + Boutons)
        JPanel panelBas = new JPanel(new GridLayout(0, 1));
        contentPane.add(panelBas, BorderLayout.SOUTH);
        
        JPanel panelTotaux = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        double ht = Math.round(panier.total() * 100.0) / 100.0;
        double frais = 5.50;
        double ttc = Math.round((ht + frais) * 100.0) / 100.0;
        
        panelTotaux.add(new JLabel("Sous-total: " + ht + "€  |  Expédition: " + frais + "€  |  "));
        JLabel lblTotal = new JLabel("TOTAL TTC: " + ttc + "€");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotal.setForeground(Color.RED);
        panelTotaux.add(lblTotal);
        panelBas.add(panelTotaux);

        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnVider = new JButton("Vider panier");
        btnVider.addActionListener(e -> {
            accueil.getPanier().viderPanier();
            accueil.updateBtnPanier();
            dispose();
        });
        
        JButton btnContinuer = new JButton("Continuer achats");
        btnContinuer.addActionListener(e -> dispose());
        
        JButton btnValider = new JButton("Valider la commande");
        btnValider.setFont(new Font("Arial", Font.BOLD, 14));
        btnValider.setBackground(new Color(144, 238, 144));
        btnValider.addActionListener(e -> {
            dispose();
            new CoordonneesFrame(null).setVisible(true);
        });

        panelBoutons.add(btnVider);
        panelBoutons.add(btnContinuer);
        panelBoutons.add(btnValider);
        panelBas.add(panelBoutons);
    }
}