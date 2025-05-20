package ihm;

import javax.swing.*;
import java.awt.*;

public class Imprimer extends JFrame {

    public Imprimer() {
        setTitle("Imprimer");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel generalPanel = new JPanel();
        generalPanel.setLayout(new GridLayout(4, 2, 5, 5));

        generalPanel.add(new JLabel("Service d'impression"));
        JComboBox<String> printerList = new JComboBox<>(new String[]{"HP Officejet 5740 series"});
        generalPanel.add(printerList);

        generalPanel.add(new JLabel("Statut"));
        generalPanel.add(new JLabel("Acceptation des tâches"));

        generalPanel.add(new JLabel("Type"));
        generalPanel.add(new JLabel(""));

        JCheckBox printToFile = new JCheckBox("Imprimer dans un fichier");
        generalPanel.add(printToFile);

        tabbedPane.addTab("Général", generalPanel);

        JPanel miseEnPagePanel = new JPanel(); // You can add components to this panel as needed
        tabbedPane.addTab("Mise en page", miseEnPagePanel);

        JPanel apparencePanel = new JPanel(); // You can add components to this panel as needed
        tabbedPane.addTab("Apparence", apparencePanel);

        add(tabbedPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton printButton = new JButton("Imprimer");
        JButton cancelButton = new JButton("Annuler");

        printButton.addActionListener(e -> {
            // Implement the actual print functionality here
            JOptionPane.showMessageDialog(this, "Impression en cours...");
        });

        cancelButton.addActionListener(e -> dispose());

        bottomPanel.add(printButton);
        bottomPanel.add(cancelButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}