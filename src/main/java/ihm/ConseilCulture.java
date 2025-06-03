package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class ConseilCulture extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConseilCulture dialog = new ConseilCulture();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConseilCulture() {
	    setBounds(100, 100, 593, 441);
	    getContentPane().setLayout(new BorderLayout());
	    
	    JPanel panel = new JPanel();
	    getContentPane().add(panel, BorderLayout.NORTH);
	    panel.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel = new JLabel("Conseils de culture");
	    lblNewLabel.setForeground(new Color(255, 0, 0));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel.add(lblNewLabel);
	    
	    JTextPane txtpnSemisMarsavril = new JTextPane();
	    txtpnSemisMarsavril.setForeground(new Color(255, 0, 0));
	    txtpnSemisMarsavril.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtpnSemisMarsavril.setEditable(false);
	    txtpnSemisMarsavril.setText("Semis : mars-avril\r\nRepiquage : après les gelées\r\nRécolte : juillet à septembre, voire octobre");
	    panel.add(txtpnSemisMarsavril, BorderLayout.SOUTH);
	    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    getContentPane().add(contentPanel, BorderLayout.CENTER);
	    String[] conseils = {
	    	    "Conseils de culture",
	    	    "",
	    	    "Semis : mars-avril",
	    	    "Repiquage : après les gelées",
	    	    "Récolte : juillet à septembre, voire octobre",
	    	    "",
	    	    "Semis :",
	    	    "Démarrez vos semis en terrine dès mars / avril (15-20° nuit et jour).",
	    	    "Utilisez un terreau spécial semis, couvrez les graines de 0,5 cm, tassez légèrement et maintenez humide.",
	    	    "Repiquer à 5 cm dans des godets avec du terreau enrichi (1/3 compost ou fumier).",
	    	    "",
	    	    "Plantation :",
	    	    "Après les Saints de glaces, plantez en pleine terre jusqu'aux premières feuilles.",
	    	    "Ajoutez du compost ou des feuilles d'ortie au fond du trou.",
	    	    "Espacez les plants de 50 cm et les rangs de 70 cm.",
	    	    "Tuteurez dès la plantation avec des tuteurs solides.",
	    	    "",
	    	    "Entretien :",
	    	    "Arrosez abondamment les 3 premiers jours, puis modérément sans mouiller le feuillage.",
	    	    "Paillez le sol pour conserver l'humidité et limiter les mauvaises herbes.",
	    	    "Supprimez les gourmands (pousses entre tige principale et feuilles) pour favoriser la fructification.",
	    	    "Fertilisez tous les 15 jours avec un engrais riche en potassium.",
	    	    "",
	    	    "Prévention :",
	    	    "Évitez les arrosages en soirée pour limiter les maladies fongiques.",
	    	    "Surveillez les signes de mildiou (taches brunes sur feuilles et fruits).",
	    	    "Utilisez des purins naturels (ortie, prêle) en prévention.",
	    	    "",
	    	    "Récolte :",
	    	    "Récoltez les tomates bien rouges, de préférence le matin.",
	    	    "Conservez-les à température ambiante, pas au réfrigérateur.",
	    	    "",
	    	    "Pensez à pailler ! Vous garderez plus facilement l'humidité et protégerez vos plants."
	    	};

	    contentPanel.setLayout(new BorderLayout(0, 0));
	    JScrollPane scrollPane = new JScrollPane();
	    contentPanel.add(scrollPane);
	    
	    	    JList<String> list = new JList<>(conseils);
	    	    list.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    	    scrollPane.setViewportView(list);

	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);

	    JButton okButton = new JButton("OK");
	    okButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    	}
	    });
	    okButton.setActionCommand("OK");
	    buttonPane.add(okButton);
	    
	}
}
