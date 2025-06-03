package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modèle.Panier;
import modèle.Tomate;
import modèle.Tomates;
import modèle.OutilsBaseDonneesTomates;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSpinner;
import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;

public class DetailsTomate extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public DetailsTomate(String désignationTomate) {
    	Tomate tomate = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json").getTomate(désignationTomate);
    	
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Détail de la tomate");
        setBounds(100, 100, 450, 316);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        String désignation = "Tomates de test";
        String prix = "10 €";
        int maxQuantité = 10;

        JPanel panelButtons = new JPanel();
        contentPane.add(panelButtons, BorderLayout.SOUTH);

        JButton btnAjouter = new JButton("Ajouter au panier");
        panelButtons.add(btnAjouter);

        JButton btnAnnuler = new JButton("Annuler");
        panelButtons.add(btnAnnuler);

        JPanel panelHaut = new JPanel();
        contentPane.add(panelHaut, BorderLayout.CENTER);
        panelHaut.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelGauche = new JPanel();
        panelHaut.add(panelGauche);
        panelGauche.setLayout(new BorderLayout(0, 0));

        JPanel panelImage = new JPanel();
        panelImage.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nom de la tomate", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panelGauche.add(panelImage);

        JLabel lblImage = new JLabel("");
        ImageIcon image = new ImageIcon(getClass().getResource("/images/Tomates200x200/"+tomate.getNomImage()+".jpg"));
        panelImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        lblImage.setIcon(image);
        panelImage.add(lblImage);
        
        JPanel panel_1 = new JPanel();
        panelGauche.add(panel_1, BorderLayout.SOUTH);
        
                JLabel lblDisponibilite = new JLabel("En stock");
                panel_1.add(lblDisponibilite);
                lblDisponibilite.setForeground(new Color(0, 128, 0));
                        
                                JComboBox<String> produitsSimilaires = new JComboBox<>();
                                panel_1.add(produitsSimilaires);
                                produitsSimilaires.setToolTipText("");
                                produitsSimilaires.setModel(new DefaultComboBoxModel<>(new String[] {"Produits similaires", "Truc", "Bidule", "Machin", "Chose"}));

        JPanel panelDroite = new JPanel();
        panelHaut.add(panelDroite);
        panelDroite.setLayout(new BorderLayout(0, 0));
        
        JPanel panelDescription = new JPanel();
        panelDescription.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panelDroite.add(panelDescription);
        panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.X_AXIS));
        
        JTextArea textDescription = new JTextArea();
        panelDescription.add(textDescription);
        
        JPanel panelNbQuantite = new JPanel();
        panelDroite.add(panelNbQuantite, BorderLayout.SOUTH);
        panelNbQuantite.setLayout(new BorderLayout(0, 0));
        
        JPanel panelNbGraines = new JPanel();
        panelNbQuantite.add(panelNbGraines, BorderLayout.NORTH);
        
        JLabel lblNbGraines = new JLabel("Nombre de graines :");
        panelNbGraines.add(lblNbGraines);
        
        textField = new JTextField();
        textField.setEditable(false);
        panelNbGraines.add(textField);
        textField.setColumns(3);
        
        JPanel panelQuantite = new JPanel();
        panelNbQuantite.add(panelQuantite, BorderLayout.CENTER);
        
        JLabel lblQuantite = new JLabel("Prix :");
        panelQuantite.add(lblQuantite);
        
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        panelQuantite.add(textField_1);
        textField_1.setColumns(3);
        
        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        panelQuantite.add(spinner);
    }
}