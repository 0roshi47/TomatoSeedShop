package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import modèle.Panier;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PagePanier extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtTotal;
	private JTextField txtSoustotal;
	private JTextField txtFraisDePort;
	private JTextField textField_3;
	private JTextField textField_4;

	private JTextField txtTotalCalculée;
	private JTextField txtRechercherUnArticle;
	private JTable tableProduits;

	public PagePanier() {
		setModal(true); 
		setTitle("Votre panier");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 390);
		getContentPane().setLayout(new BorderLayout(0, 0));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER); 
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Title = new JPanel();
		contentPane.add(Title, BorderLayout.NORTH);

		JLabel Market_title = new JLabel("VOTRE PANIER");
		Market_title.setForeground(new Color(0, 128, 0));
		Market_title.setHorizontalAlignment(SwingConstants.CENTER);
		Market_title.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		Title.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		Title.add(lblNewLabel, BorderLayout.WEST);
		Title.add(Market_title, BorderLayout.CENTER);
		
		Panier[] conseils = {
	
	    	};

		JPanel BottomPane = new JPanel();
		contentPane.add(BottomPane, BorderLayout.SOUTH);
		BottomPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		BottomPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		txtRechercherUnArticle = new JTextField();
		txtRechercherUnArticle.setToolTipText("Rechercher un article");
		panel_3.add(txtRechercherUnArticle);
		txtRechercherUnArticle.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 3, 0, 0));

		txtSoustotal = new JTextField();
		txtSoustotal.setFont(new Font("Roboto", Font.BOLD, 10));
		txtSoustotal.setEditable(false);
		txtSoustotal.setText("Sous-total :");
		panel_5.add(txtSoustotal);
		txtSoustotal.setColumns(10);

		double totalHT = accueil.getPanier().total();
		double totalHTArrondi = Math.round(totalHT * 100.0) / 100.0;
		txtTotalCalculée = new JTextField(totalHTArrondi + "€");
		textField_3.setFont(new Font("Roboto", Font.BOLD, 10));
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setBackground(SystemColor.info);
		textField_3.setEditable(false);
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		txtFraisDePort = new JTextField();
		txtFraisDePort.setFont(new Font("Roboto", Font.BOLD, 10));
		txtFraisDePort.setText("Expédition (forfait):");
		txtFraisDePort.setEditable(false);
		panel_5.add(txtFraisDePort);
		txtFraisDePort.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("5.50€");
		textField_4.setFont(new Font("Roboto", Font.BOLD, 10));
		textField_4.setBackground(SystemColor.info);
		textField_4.setEditable(false);
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setForeground(new Color(0, 128, 0));
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTotal.setText("TOTAL :");
		panel_5.add(txtTotal);
		txtTotal.setColumns(10);

		double totalTTC = 5.5 + accueil.getPanier().total();
		double totalTTCArrondi = Math.round(totalTTC* 100.0) / 100.0;
		txtTotalCalculée = new JTextField(totalTTCArrondi + "€");
		txtTotalCalculée.setForeground(new Color(0, 83, 0));
		txtTotalCalculée.setFont(new Font("Roboto", Font.BOLD, 14));
		txtTotalCalculée.setBackground(new Color(217, 255, 217));
		txtTotalCalculée.setEditable(false);
		panel_5.add(txtTotalCalculée);
		txtTotalCalculée.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));

		JButton ButtonViderPanier = new JButton("Vider le panier");
		ButtonViderPanier.setForeground(new Color(255, 0, 0));
		panel_4.add(ButtonViderPanier);

		JButton ButtonContinuerAchats = new JButton("Continuer les achats");
		ButtonContinuerAchats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_4.add(ButtonContinuerAchats);

		JButton ButtonValiderPanier = new JButton("Valider le panier");
		ButtonValiderPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoordonneesFrame coordonnées = new CoordonneesFrame(null);
				coordonnées.setModal(true);
				coordonnées.setVisible(true);
				coordonnées.setFocusableWindowState(true);
			}
		});
		
		ButtonValiderPanier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(ButtonValiderPanier);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableProduits = new JTable();
		tableProduits.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Photo", "Produit", "Prix", "Quantité", "Total"
			}
		));
		scrollPane.setViewportView(tableProduits);

		ButtonViderPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(PagePanier.this,
						"Voulez-vous vraiment supprimer le panier ?", "Selectionner une option",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					accueil.setPanier(new Panier());
					dispose();
				}
			}
		});
	}

}