package ihm;

import java.awt.EventQueue;
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

public class accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private Panier pani er;
	
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
		
		panier = new Panier();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("Nos graines de tomates");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitre, BorderLayout.CENTER);
		
		JButton btnPanier = new JButton("New button");
		btnPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagePanier pagePanier = new PagePanier();
				pagePanier.setVisible(true);
			}
		});
		panel.add(btnPanier, BorderLayout.EAST);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		afficherToutesLesTomates();

	}
	
	public void afficherToutesLesTomates() {
		Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("/Users/liam/Documents/Cours/S2/S2.01 /TomatoSeedShop/src/main/resources/data/tomates.json");
		
		List<String> noms = new ArrayList<>();
		
		for (Tomate tomate : tomates.getTomates()) {
			noms.add(tomate.getDésignation());
		}
		
		JList<String> listeNoms = new JList<>(noms.toArray(new String[0]));
		scrollPane.setViewportView(listeNoms);
	}

}
