package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class DetailTomate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNbGraines;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailTomate frame = new DetailTomate();
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
	public DetailTomate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDetails = new JPanel();
		contentPane.add(panelDetails);
		panelDetails.setLayout(new BoxLayout(panelDetails, BoxLayout.X_AXIS));
		
		JPanel panelGauche = new JPanel();
		panelDetails.add(panelGauche);
		
		JPanel panelDroite = new JPanel();
		panelDetails.add(panelDroite);
		panelDroite.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 255), new Color(160, 160, 160)), "Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDroite.add(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));
		
		JTextArea Description = new JTextArea();
		Description.setEditable(false);
		panelDescription.add(Description);
		
		JPanel panelNbGraines = new JPanel();
		panelDroite.add(panelNbGraines);
		panelNbGraines.setLayout(new BoxLayout(panelNbGraines, BoxLayout.X_AXIS));
		
		JLabel lblNbGraines = new JLabel("Nombre de graines");
		panelNbGraines.add(lblNbGraines);
		
		textNbGraines = new JTextField();
		textNbGraines.setEditable(false);
		panelNbGraines.add(textNbGraines);
		textNbGraines.setColumns(10);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnAjouter = new JButton("Ajouter au panier");
		panelButtons.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		panelButtons.add(btnAnnuler);
	}
}
