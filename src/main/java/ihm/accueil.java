package ihm;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modèle.*;

public class accueil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPaneListe;
    private JList<String> jListTomates;
    
    // --- STATIC: Données partagées par toute l'application ---
    private static Panier panier;
    private static Tomates baseDeDonnees; 
    private static JButton btnPanier;
    
    private JComboBox<String> filtreTomates;
    private JComboBox<String> filtreCouleurs;
    private JTextField rechercheTomate;

    public static void main(String[] args) {
        // Chargement initial unique de la base de données
        baseDeDonnees = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
        panier = new Panier();

        EventQueue.invokeLater(() -> {
            try {
                accueil frame = new accueil();
                frame.setSize(900, 600);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    // Accesseurs statiques pour les autres fenêtres
    public static Panier getPanier() { return panier; }
    public static void setPanier(Panier p) { 
        panier = p; 
        updateBtnPanier();
    }
    
    public static Tomates getBaseDeDonnees() { return baseDeDonnees; }

    public static void updateBtnPanier() {
        double totalArrondiHT = Math.round(panier.total() * 100.0) / 100.0;
        btnPanier.setText(totalArrondiHT + "€");
    }

    public accueil() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // --- HEADER ---
        JPanel header = new JPanel(new BorderLayout());
        contentPane.add(header, BorderLayout.NORTH);

        JLabel lblTitre = new JLabel("Nos graines de tomates");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(lblTitre, BorderLayout.CENTER);

        btnPanier = new JButton("0.00€");
        // Chargement sécurisé de l'image
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png"));
            Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            btnPanier.setIcon(new ImageIcon(img));
        } catch (Exception e) { System.err.println("Image panier manquante"); }

        btnPanier.addActionListener(e -> {
            if (panier.total() == 0.0F) {
                JOptionPane.showMessageDialog(this, "Votre panier est vide !", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new PagePanier().setVisible(true);
            }
        });
        header.add(btnPanier, BorderLayout.EAST);

        // --- LISTE CENTRALE ---
        scrollPaneListe = new JScrollPane();
        contentPane.add(scrollPaneListe, BorderLayout.CENTER);
        
        // --- FOOTER (Filtres) ---
        JPanel footer = new JPanel(new BorderLayout());
        contentPane.add(footer, BorderLayout.SOUTH);

        JPanel filtres = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        filtres.setBorder(new LineBorder(new Color(0, 169, 6), 1));
        footer.add(filtres, BorderLayout.CENTER);

        // Filtre Type
        filtreTomates = new JComboBox<>(new String[] {"Toutes les tomates", "Cerises & Cocktails (16)", "Autres Tomates (47)"});
        filtreTomates.addActionListener(e -> actualiserListeTomate());
        filtres.add(new JLabel("Type:"));
        filtres.add(filtreTomates);

        // Filtre Couleur
        filtreCouleurs = new JComboBox<>(new String[] {"Toutes les couleurs", "Bleu", "Vert", "Rouge", "Orange", "Jaune", "Noir", "Multicolore"});
        filtreCouleurs.addActionListener(e -> actualiserListeTomate());
        filtres.add(new JLabel("Couleur:"));
        filtres.add(filtreCouleurs);

        // Recherche
        rechercheTomate = new JTextField(15);
        rechercheTomate.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualiserListeTomate(); }
            public void removeUpdate(DocumentEvent e) { actualiserListeTomate(); }
            public void changedUpdate(DocumentEvent e) { actualiserListeTomate(); }
        });
        filtres.add(new JLabel("Recherche:"));
        filtres.add(rechercheTomate);

        // Bouton Conseil
        JButton conseils = new JButton("Conseils");
        conseils.addActionListener(e -> new ConseilCulture().setVisible(true));
        footer.add(conseils, BorderLayout.EAST);

        actualiserListeTomate();
    }

    // Affiche la liste en fonction des filtres
    public void actualiserListeTomate() {
        String search = rechercheTomate.getText().toLowerCase();
        Couleur color = Couleur.getCouleur((String) filtreCouleurs.getSelectedItem());
        TypeTomate type = TypeTomate.getTypeTomate((String) filtreTomates.getSelectedItem());

        List<String> noms = new ArrayList<>();
        // On utilise la base chargée en static
        for (Tomate t : baseDeDonnees.getTomates()) {
            boolean matchColor = (color == null || t.getCouleur() == color);
            boolean matchType = (type == null || t.getType() == type);
            boolean matchSearch = (search.isEmpty() || t.getDésignation().toLowerCase().contains(search));

            if (matchColor && matchType && matchSearch) {
                noms.add(t.getDésignation());
            }
        }

        jListTomates = new JList<>(noms.toArray(new String[0]));
        jListTomates.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListTomates.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double clic pour ouvrir
                   ouvrirDetails();
                }
            }
        });
        scrollPaneListe.setViewportView(jListTomates);
    }
    
    private void ouvrirDetails() {
        String selected = jListTomates.getSelectedValue();
        if (selected != null) {
            // On cherche l'objet tomate RÉEL dans la base unique
            Tomate t = baseDeDonnees.getTomate(selected);
            if(t != null) {
                new DetailsTomate(t).setVisible(true);
            }
        }
    }
}