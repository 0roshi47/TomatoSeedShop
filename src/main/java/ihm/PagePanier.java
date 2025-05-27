package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import modèle.Panier;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;

public class PagePanier extends JFrame {

	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	private JTextField txtTotal;
	private JTextField txtSoustotal;
	private JTextField txtFraisDePort;
	private JTextField textField_3;
	private JTextField textField_4;

	private JTextField txtLeCacaEst;
	private JTextField txtRechercherUnArticle;

	/**
	 * Create the frame.
	 */
	public PagePanier(Panier panier) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Title = new JPanel();
		contentPane.add(Title, BorderLayout.NORTH);

		JLabel Market_title = new JLabel("VOTRE PANIER");
		Market_title.setHorizontalAlignment(SwingConstants.CENTER);
		Market_title.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		Title.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/ProjectImages/PetitPanier3.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		Title.add(lblNewLabel, BorderLayout.WEST);
		Title.add(Market_title, BorderLayout.CENTER);

		JScrollPane TomatoList = new JScrollPane();
		contentPane.add(TomatoList, BorderLayout.CENTER);

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
		panel_3.add(txtRechercherUnArticle);
		txtRechercherUnArticle.setText("Rechercher un article");
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

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Roboto", Font.BOLD, 10));
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setBackground(new Color(255, 255, 255));
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
		textField_4.setFont(new Font("Roboto", Font.BOLD, 10));
		textField_4.setBackground(new Color(255, 255, 255));
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

		txtLeCacaEst = new JTextField();
		txtLeCacaEst.setForeground(new Color(0, 83, 0));
		txtLeCacaEst.setFont(new Font("Roboto", Font.BOLD, 14));
		txtLeCacaEst.setBackground(new Color(217, 255, 217));
		txtLeCacaEst.setEditable(false);
		panel_5.add(txtLeCacaEst);
		txtLeCacaEst.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));

		JButton ButtonViderPanier = new JButton("Vider le panier");
		ButtonViderPanier.setForeground(new Color(255, 0, 0));
		panel_4.add(ButtonViderPanier);

		JButton ButtonContinuerAchats = new JButton("Continuer les achats");
		panel_4.add(ButtonContinuerAchats);

		JButton ButtonValiderPanier = new JButton("Valider le panier");
		ButtonValiderPanier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(ButtonValiderPanier);
		ButtonValiderPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// Add ActionListener to "Vider le panier" button
		ButtonViderPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(PagePanier.this,
						"Voulez-vous vraiment supprimer le panier ?", "Selectionner une option",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					// Code to clear the cart
					clearCart();
				}
			}
		});
	}

	// Method to clear the cart
	private void clearCart() {
		// Update the relevant fields to reflect an empty cart
		textField_3.setText("");
		textField_4.setText("");
		txtLeCacaEst.setText("");
		JOptionPane.showMessageDialog(this, "Le panier est maintenant vide.");
	}
}