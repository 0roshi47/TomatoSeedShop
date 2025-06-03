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

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;

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
import java.awt.Font;
import javax.swing.DropMode;

public class DetailsTomate extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNbGraines;
    private JTextField textPrix;


    public DetailsTomate(String désignationTomate) {
    	Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
    	Tomate tomate = tomates.getTomate("Tomate Joie de la Table");
    	//Tomate tomate = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json").getTomate(désignationTomate);
    	
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Détail de la tomate");
        setBounds(100, 100, 515, 340);
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
        //lblImage.setIcon(new ImageIcon(getClass().getResource("/images/Tomates200x200/" + tomate.getNomImage() + ".jpg")));
        lblImage.setIcon(new ImageIcon(getClass().getResource("/images/Tomates200x200/Tomate-Joie-de-la-Table-ressemble-scaled.jpg")));

        panelImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelImage.add(lblImage);
        
        JPanel panelStock = new JPanel();
        panelGauche.add(panelStock, BorderLayout.SOUTH);
                
        JComboBox<String> produitsSimilaires = new JComboBox<>();
        produitsSimilaires.setModel(new DefaultComboBoxModel(new String[] {"Produits similaires", "Fraise", "Aubergine", "Fruit du dragon"}));
        //JComboBox<String> produitsSimilaires = new JComboBox<>(tomate.getTomatesApparentées().toArray(new String[0]));
        panelStock.add(produitsSimilaires);
        produitsSimilaires.setToolTipText("Produits similaires");

        JPanel panelDroite = new JPanel();
        panelHaut.add(panelDroite);
        panelDroite.setLayout(new BorderLayout(0, 0));
        
        JPanel panelDescription = new JPanel();
        panelDescription.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panelDroite.add(panelDescription);
        panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.X_AXIS));
        
        String texte = "Variété rustique, précoce vigoureuse et productive.\\r\\n\\r\\nSes fruits de 150 à 250 g, très légèrement côtelés, ont une chair fine, juteuse et savoureuse.\\r\\n\\r\\nElles sont délicieuses en salade.";
        //String texte = tomate.getDescription();
        texte = texte.replace("\\r\\n\\r\\n", "\n\n");
        JTextArea textDescription = new JTextArea(texte);
        textDescription.setWrapStyleWord(true);
        textDescription.setForeground(new Color(0, 0, 0));
        textDescription.setLineWrap(true);
        textDescription.setToolTipText("");
        textDescription.setColumns(1);
        textDescription.setEditable(false);
        textDescription.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panelDescription.add(textDescription);
        
        JPanel panelNbQuantite = new JPanel();
        panelDroite.add(panelNbQuantite, BorderLayout.SOUTH);
        panelNbQuantite.setLayout(new BorderLayout(0, 0));
        
        JPanel panelNbGraines = new JPanel();
        panelNbQuantite.add(panelNbGraines, BorderLayout.NORTH);
        
        JLabel lblNbGraines = new JLabel("Nombre de graines :");
        panelNbGraines.add(lblNbGraines);
        
        textNbGraines = new JTextField();
        textNbGraines.setText(String.valueOf(10));
        //textNbGraines.setText(String.valueOf(tomate.getNbGrainesParSachet()));
        textNbGraines.setEditable(false);
        panelNbGraines.add(textNbGraines);
        textNbGraines.setColumns(2);
        
        JPanel panelQuantitePrix = new JPanel();
        panelNbQuantite.add(panelQuantitePrix, BorderLayout.CENTER);
        
        JLabel lblQuantite = new JLabel("Prix :");
        panelQuantitePrix.add(lblQuantite);
        
        textPrix = new JTextField();
        textPrix.setText("15€");
        //textPrix.setText(String.valueOf(tomate.getPrixTTC() + "€"));
        textPrix.setEditable(false);
        panelQuantitePrix.add(textPrix);
        textPrix.setColumns(3);
        
        JSpinner spinnerQuantite = new JSpinner();
        spinnerQuantite.setModel(new SpinnerNumberModel(0, 0, 20, 1));
        //spinnerQuantite.setModel(new SpinnerNumberModel(0, 0, tomate.getStock(), 1));
        panelQuantitePrix.add(spinnerQuantite);
        
        JLabel lblDisponibilite = new JLabel("En stock");
        lblDisponibilite.setForeground(new Color(0, 128, 0));
        if(tomate.getStock() == 0) {
        	lblDisponibilite.setText("En rupture");
        	lblDisponibilite.setForeground(new Color(128, 0, 0));
         	btnAjouter.setEnabled(false);
         	spinnerQuantite.setEnabled(false);
        }
        panelStock.add(lblDisponibilite);
    }
}