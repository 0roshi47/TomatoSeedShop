package ihm;

import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modèle.OutilsBaseDonneesTomates;
import modèle.Tomate;
import modèle.Tomates;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		
		JLabel lblTitre = new JLabel("Nos graines de tomates");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblTitre);
		
		JLabel lblPrix = new JLabel("New label");
		lblPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		panelHeader.add(lblPrix);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("/Users/liam/Documents/Cours/S2/S2.01 /TomatoSeedShop/src/main/resources/data/tomates.json");
		
		List<String> noms = new ArrayList<>();
		
		for (Tomate tomate : tomates.getTomates()) {
			noms.add(tomate.getDésignation());
		}
		
		JList<String> listeNoms = new JList<>(noms.toArray(new String[0]));
		scrollPane.setViewportView(listeNoms);

	}

}
