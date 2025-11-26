package modèle;

import java.util.HashMap;
import java.util.Map;

public class Panier {

   private Map<Tomate, Integer> contenu;

    public Panier() {
        this.contenu = new HashMap<>();
    }

    public void ajouterTomate(Tomate tomate, int quantiteAjoutee) {
        if (quantiteAjoutee <= 0) return;
        
        this.contenu.put(tomate, this.contenu.getOrDefault(tomate, 0) + quantiteAjoutee);
    }

    public void retirerTomate(Tomate tomate) {
        this.contenu.remove(tomate);
    }

    public void viderPanier() {
        this.contenu.clear();
    }

    public float total() {
        float total = 0.0f;
        for (Map.Entry<Tomate, Integer> entry : contenu.entrySet()) {
            total += entry.getKey().getPrixTTC() * entry.getValue();
        }
        return total;
    }

    public void validerLaCommande() {
        for (Map.Entry<Tomate, Integer> entry : contenu.entrySet()) {
            Tomate t = entry.getKey();
            int qteAchetee = entry.getValue();
            t.diminuerStock(qteAchetee);
        }
    }

    public Map<Tomate, Integer> getContenu() {
        return this.contenu;
    }
    
     public Tomates getTomates() {
        Tomates t = new Tomates();
        t.addTomates(new java.util.ArrayList<>(contenu.keySet()));
        return t;
    }
}