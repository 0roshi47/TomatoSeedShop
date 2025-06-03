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
	    setBounds(100, 100, 500, 400);
	    getContentPane().setLayout(new BorderLayout());
	    
	    JPanel panel = new JPanel();
	    getContentPane().add(panel, BorderLayout.NORTH);
	    panel.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel = new JLabel("Conseils de culture");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    panel.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("test");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(lblNewLabel_1, BorderLayout.SOUTH);
	    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    getContentPane().add(contentPanel, BorderLayout.CENTER);
	    String[] conseils = {
	    	    "Semis :",
	    	    "Démarrez vos semis en petite terrine dès mars / avril (15-20° nuit et jour)",
	    	    "dans du terreau à semis, couvrez vos graines de 0,5 cm, tassez doucement et maintenez humide.",
	    	    "Repiquer vos semis lorsqu'ils font 5 cm, dans des godets avec du terreau,",
	    	    "1/3 de fumier ou du compost, enterrez jusqu'aux premières feuilles.",
	    	    "",
	    	    "Après les Saints de glaces :",
	    	    "Plantez vos pieds de tomates dès qu'ils auront atteint 15 cm,",
	    	    "enterrez-les jusqu'aux premières feuilles en pleine terre avec un trou contenant",
	    	    "du fumier, du compost ou quelques feuilles d'ortie si besoin.",
	    	    "Installez vos tuteurs espacés de 70 cm.",
	    	    "Arrosez abondamment les 3 premiers jours,",
	    	    "arrêtez les 15 jours suivants puis arrosez régulièrement.",
	    	    "",
	    	    "Pensez à pailler ! ainsi vous garderez beaucoup plus facilement..."
	    	};
	    contentPanel.setLayout(new BorderLayout(0, 0));
	    JScrollPane scrollPane = new JScrollPane();
	    contentPanel.add(scrollPane);
	    
	    	    JList<String> list = new JList<>(conseils);
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
