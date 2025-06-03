package ihm;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modèle.OutilsBaseDonneesTomates;
import modèle.Panier;
import modèle.Tomate;
import modèle.Tomates;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private Panier panier;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil frame = new accueil();
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
		
		JButton btnPanier = new JButton("New button");
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png"));
		Image originalImage = originalIcon.getImage();

		int taille = 30;
		Image nouvelleImage = originalImage.getScaledInstance(taille, taille, Image.SCALE_SMOOTH);

		btnPanier.setIcon(new ImageIcon(nouvelleImage));
		btnPanier.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        PagePanier pagePanier = new PagePanier(accueil.this.panier);
		        pagePanier.setVisible(true);
		    }
		});

		header.add(btnPanier, BorderLayout.EAST);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));
		
		JPanel filtres = new JPanel();
		filtres.setBorder(new LineBorder(new Color(0, 169, 6)));
		footer.add(filtres, BorderLayout.WEST);
		filtres.setLayout(new BorderLayout(0, 0));
		
		JComboBox filtreTomate = new JComboBox();
		filtreTomate.setModel(new DefaultComboBoxModel(new String[] {"Toutes les tomates", "Cerises & Cocktails (16)", "Autres Tomates (47)"}));
		filtres.add(filtreTomate, BorderLayout.WEST);
		
		JComboBox filtreCouleurs = new JComboBox();
		filtreCouleurs.setModel(new DefaultComboBoxModel(new String[] {"Toutes les couleurs", "Bleu", "Vert", "Rouge", "Orange", "Jaune", "Noir", "Multicolore"}));
		filtres.add(filtreCouleurs, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("New button");
		footer.add(btnNewButton, BorderLayout.EAST);
		
		afficherToutesLesTomates();

	}
	
	public void afficherToutesLesTomates() {
		Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
		
		List<String> noms = new ArrayList<>();
		
		for (Tomate tomate : tomates.getTomates()) {
			noms.add(tomate.getDésignation());
		}
		
		JList<String> listeNoms = new JList<>(noms.toArray(new String[0]));
		listeNoms.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//DetailsTomate pageDetails = new DetailsTomate(accueil.this.panier);
				//pageDetails.setVisible(true);
			}
		});
		listeNoms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DetailsTomate pageDetails = new DetailsTomate(accueil.this.panier);
				pageDetails.setVisible(true);
			}
		});
		scrollPane.setViewportView(listeNoms);
	}
	
	public Panier getPanier() {
		return this.panier;
	}

}
