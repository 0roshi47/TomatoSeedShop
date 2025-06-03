package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConseilsCulture extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConseilsCulture dialog = new ConseilsCulture();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConseilsCulture() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrPourRussirLa = new JTextArea();
		txtrPourRussirLa.setEditable(false);
		txtrPourRussirLa.setText("Variétés adaptés: Tomate 'Cœur de Bœuf' ou la 'Tomate Cerise'\r\nPériode idéale: Mi-mai et début juin\r\nSol: Riche et drainé avec 3 à 5 kg de compost par mètre carré\r\nExposition au soleil: 6/8h par jour\r\npH du sol: 6 à 6.8\r\nLe plant: Utiliser des tuteurs\r\nArrosage: 5L à 10L par semaine");
		txtrPourRussirLa.setBounds(10, 10, 416, 212);
		contentPanel.add(txtrPourRussirLa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
