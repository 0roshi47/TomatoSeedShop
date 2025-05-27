package modèle;

import java.util.LinkedList;
import java.util.List;

public class Panier {

	private Tomates tomates;
	private List<Integer> quantité; 
	//pour chaque tomate de rang N, la quantité prise est stockée dans la liste quantité, au rang N
	
	public Panier() {
		this.tomates = new Tomates(); //un nouveau panier est considéré comme vide
	}
	
	public float total() {
		float resultat = 0.0F;
		for (int i = 0; i < this.tomates.getTomates().size(); i++) {
			resultat += this.tomates.getTomates().get(i).getPrixTTC() * this.quantité.get(i);
		}
		return resultat;
	}
	
	public void ajouterTomate(Tomate tomate, int quantité) {
		List<Tomate> nouvelleTomate = new LinkedList<Tomate>();
        nouvelleTomate.add(tomate);
		this.tomates.addTomates(nouvelleTomate);
		this.quantité.add(quantité);
	}
	
}
