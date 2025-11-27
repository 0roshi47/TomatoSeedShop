package ihm;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modèle.Couleur;
import modèle.OutilsBaseDonneesTomates;
import modèle.Panier;
import modèle.Tomate;
import modèle.Tomates;
import modèle.TypeTomate;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.FlowLayout;
import javax.swing.border.Border;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane listeTomates;
	private static Panier panier;
	private static JButton btnPanier;
	private JPanel filtres;
	private JComboBox filtreTomates;
	private JComboBox filtreCouleurs;
	private JTextField rechercheTomate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil frame = new accueil();
	                frame.setSize(800, 600);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public accueil() {
		
		this.panier = new Panier();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("Nos graines de tomates");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lblTitre, BorderLayout.CENTER);
		
		accueil.btnPanier = new JButton("0.00€");
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png"));
		Image originalImage = originalIcon.getImage();

		int taille = 30;
		Image nouvelleImage = originalImage.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);

		accueil.btnPanier.setIcon(new ImageIcon(nouvelleImage));
		accueil.btnPanier.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	if (accueil.getPanier().total() == 0.0F) {
		    		JOptionPane.showMessageDialog(null, "Votre panier est vide !", "Panier vide", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	else{
		    		PagePanier pagePanier = new PagePanier();
		    		pagePanier.setVisible(true);		    	
		    	}
		    }
		});

		header.add(accueil.btnPanier, BorderLayout.EAST);
		
		listeTomates = new JScrollPane();
		contentPane.add(listeTomates, BorderLayout.CENTER);
		
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));
		
		filtres = new JPanel();
		filtres.setBorder(new LineBorder(new Color(0, 169, 6), 0));
		footer.add(filtres, BorderLayout.WEST);
		filtres.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelFiltreTomates = new JPanel();
		filtres.add(panelFiltreTomates);
		
		JLabel imageFiltreTomates = new JLabel("");
		imageFiltreTomates.setHorizontalAlignment(SwingConstants.LEFT);
		
		originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/plusieursTomatesImage.jpg"));
		originalImage = originalIcon.getImage();

		taille = 50;
		nouvelleImage = originalImage.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);
		panelFiltreTomates.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		imageFiltreTomates.setIcon(new ImageIcon(nouvelleImage));
		panelFiltreTomates.add(imageFiltreTomates);
		
		this.filtreTomates = new JComboBox();
		this.filtreTomates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualiserListeTomate();
			}
		});
		panelFiltreTomates.add(filtreTomates);
		filtreTomates.setModel(new DefaultComboBoxModel(new String[] {"Toutes les tomates", "Cerises & Cocktails (16)", "Autres Tomates (47)"}));
		
		JPanel panelFiltreCouleurs = new JPanel();
		filtres.add(panelFiltreCouleurs);
		panelFiltreCouleurs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel imageFiltreCouleurs = new JLabel("");
		originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/palettes.png"));
		originalImage = originalIcon.getImage();
		taille = 50;
		nouvelleImage = originalImage.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);
		imageFiltreCouleurs.setIcon(new ImageIcon(nouvelleImage));
		imageFiltreCouleurs.setHorizontalAlignment(SwingConstants.LEFT);
		panelFiltreCouleurs.add(imageFiltreCouleurs);
		
		this.filtreCouleurs = new JComboBox();
		this.filtreCouleurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualiserListeTomate();
			}
		});
		panelFiltreCouleurs.add(this.filtreCouleurs);
		this.filtreCouleurs.setModel(new DefaultComboBoxModel(new String[] {"Toutes les couleurs", "Bleu", "Vert", "Rouge", "Orange", "Jaune", "Noir", "Multicolore"}));
		
		JPanel panelRechercheTomates = new JPanel();
		filtres.add(panelRechercheTomates);
		
		JLabel imageRechercheTomate= new JLabel("");
		originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/loupe.png"));
		originalImage = originalIcon.getImage();
		nouvelleImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imageRechercheTomate.setIcon(new ImageIcon(nouvelleImage));
		imageRechercheTomate.setHorizontalAlignment(SwingConstants.LEFT);
		panelRechercheTomates.add(imageRechercheTomate);
		
		rechercheTomate = new JTextField(15);
		panelRechercheTomates.add(rechercheTomate);
		rechercheTomate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        actualiserListeTomate();
		    }
		});
		rechercheTomate.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		        actualiserListeTomate();
		    }
		    public void removeUpdate(DocumentEvent e) {
		        actualiserListeTomate();
		    }
		    public void changedUpdate(DocumentEvent e) {
		        actualiserListeTomate();
		    }
		});
		
		JButton conseils = new JButton("");
		conseils.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConseilCulture coordonnées = new ConseilCulture();
				coordonnées.setVisible(true);
				coordonnées.setFocusableWindowState(true);
			}
		});
		originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/plant.png"));
		originalImage = originalIcon.getImage();
		taille = 50;
		nouvelleImage = originalImage.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);
		conseils.setIcon(new ImageIcon(nouvelleImage));
		conseils.setHorizontalAlignment(SwingConstants.RIGHT);
		footer.add(conseils, BorderLayout.EAST);
		
		afficherToutesLesTomates();

	}
	
	public void afficherToutesLesTomates() {
		Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
		
		List<String> noms = new ArrayList<>();
		
		for (Tomate tomate : tomates.getTomates()) {
			noms.add(tomate.getDésignation());
		}
		
		JList<String> listeNoms = new JList<>(noms.toArray(new String[0]));
		listeNoms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tomateLibellé = listeNoms.getSelectedValue();
				System.out.println(tomateLibellé);
				DetailsTomate pageDetails = new DetailsTomate(tomateLibellé);
				pageDetails.setVisible(true);
			}
		});
		listeTomates.setViewportView(listeNoms);
	}
	
	public static Panier getPanier() {
		return panier;
	}

	public static void setPanier(Panier p) {
		accueil.panier = p;
		double totalArrondiHT = Math.round(accueil.getPanier().total() * 100.0) / 100.0;
		accueil.btnPanier.setText(totalArrondiHT + "€");
	}
	
	public Border getFiltresBorder() {
		return filtres.getBorder();
	}
	public void setFiltresBorder(Border border) {
		filtres.setBorder(border);
	}
	
	public void actualiserListeTomate() {
	    String nouvelleRecherche = rechercheTomate.getText().toLowerCase();
	    Couleur nouvelleCouleur = Couleur.getCouleur((String) this.filtreCouleurs.getSelectedItem());
	    TypeTomate nouveauType = TypeTomate.getTypeTomate((String) this.filtreTomates.getSelectedItem());

	    Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
	    List<String> noms = new ArrayList<>();

	    for (Tomate tomate : tomates.getTomates()) {
	        boolean couleurCorrespond = (nouvelleCouleur == null || tomate.getCouleur() == nouvelleCouleur);
	        boolean typeCorrespond = (nouveauType == null || tomate.getType() == nouveauType);
	        boolean rechercheCorrespond = (nouvelleRecherche.isEmpty() || tomate.getDésignation().toLowerCase().contains(nouvelleRecherche));

	        if (couleurCorrespond && typeCorrespond && rechercheCorrespond) {
	            noms.add(tomate.getDésignation());
	        }
	    }

	    JList<String> listeNoms = new JList<>(noms.toArray(new String[0]));
	    listeNoms.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent arg0) {
	            String tomateLibellé = listeNoms.getSelectedValue();
	            System.out.println(tomateLibellé);
	            DetailsTomate pageDetails = new DetailsTomate(tomateLibellé);
	            pageDetails.setVisible(true);
	        }
	    });
	    listeTomates.setViewportView(listeNoms);
	}

	
	public static double arrondi(float nombre, int décimales) {
		Double pow = Math.pow(10, décimales);
		return Math.round(nombre * pow) / pow; 
	}
}
