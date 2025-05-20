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

public class PagePanier extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PagePanier frame = new PagePanier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JTextField txtTotal;
	private JTextField txtSoustotal;
	private JTextField txtFraisDePort;
	private JTextField textField_3;
	private JTextField textField_4;

	private JTextField textField_5;
	private JTextField txtRechercherUnArticle;

	/**
	 * Create the frame.
	 */
	public PagePanier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Title = new JPanel();
		contentPane.add(Title, BorderLayout.NORTH);
		
		JLabel Market_title = new JLabel("VOTRE PANIER");
		Market_title.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		GroupLayout gl_Title = new GroupLayout(Title);
		gl_Title.setHorizontalGroup(
			gl_Title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Title.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Market_title, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(483))
		);
		gl_Title.setVerticalGroup(
			gl_Title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Title.createSequentialGroup()
					.addComponent(Market_title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_Title.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
		);
		Title.setLayout(gl_Title);

		JScrollPane TomatoList = new JScrollPane();
		contentPane.add(TomatoList, BorderLayout.CENTER);

		JPanel BottomPane = new JPanel();
		contentPane.add(BottomPane, BorderLayout.SOUTH);
		BottomPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		BottomPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		txtRechercherUnArticle = new JTextField();
		txtRechercherUnArticle.setText("Rechercher un article");
		txtRechercherUnArticle.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtRechercherUnArticle, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(18)
					.addComponent(txtRechercherUnArticle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
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
		textField_3.setBackground(new Color(255, 255, 128));
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
		textField_4.setBackground(new Color(255, 255, 128));
		textField_4.setEditable(false);
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setForeground(new Color(255, 0, 0));
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTotal.setText("TOTAL :");
		panel_5.add(txtTotal);
		txtTotal.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setFont(new Font("Roboto", Font.BOLD, 14));
		textField_5.setBackground(new Color(255, 255, 128));
		textField_5.setEditable(false);
		panel_5.add(textField_5);
		textField_5.setColumns(10);

		JPanel Validation = new JPanel();
		BottomPane.add(Validation);
		Validation.setLayout(new GridLayout(0, 3, 0, 0));

		JButton ButtonValiderPanier = new JButton("Valider le panier");
		Validation.add(ButtonValiderPanier);

		JButton ButtonViderPanier = new JButton("Vider le panier");
		Validation.add(ButtonViderPanier);

		JButton ButtonContinuerAchats = new JButton("Continuer les achats");
		Validation.add(ButtonContinuerAchats);

		// Add ActionListener to "Vider le panier" button
		ButtonViderPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(PagePanier.this,
						"Voulez-vous vraiment supprimer le panier ?", "SÃ©lectionner une option",
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
		textField_5.setText("");
		JOptionPane.showMessageDialog(this, "Le panier est maintenant vide.");
	}
}