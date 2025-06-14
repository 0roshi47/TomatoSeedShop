package modèle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Panier {

	private Tomates tomates;
	private List<Integer> quantité; 
	//pour chaque tomate de rang N, la quantité prise est stockée dans la liste quantité, au rang N
	
	public Panier() {
		this.tomates = new Tomates(); //un nouveau panier est considéré comme vide
		this.quantité = new ArrayList<>();
	}
	
	public float total() {
		float resultat = 0.0F;
		for (int i = 0; i < this.tomates.getTomates().size(); i++) {
			resultat += this.tomates.getTomates().get(i).getPrixTTC() * this.quantité.get(i);
		}
		return resultat;
	}
	
	public void ajouterTomate(Tomate tomate, int nouvelleQuantité) {
		if (this.tomates.getTomate(tomate.getDésignation()) != null) {
			List<Tomate> listTomatesDansPanier = this.tomates.getTomates();
			for (int position = 0; position < listTomatesDansPanier.size(); position++) {
				if (this.tomates.getTomate(position).equals(tomate)) {
					this.quantité.set(position, this.quantité.get(position)+nouvelleQuantité);
				}
			}
		} else {
			List<Tomate> nouvelleTomate = new LinkedList<Tomate>();
	        nouvelleTomate.add(tomate);
			this.tomates.addTomates(nouvelleTomate);
			this.quantité.add(nouvelleQuantité);
		}
	}
	
	public void ajouterQuantité(Tomate tomate, int nouvelleQuantité) {
		int iTomate = 0;
		for (int i = 0; i < this.quantité.size(); i ++) {
			if (tomates.getTomate(i) == tomate) {
				iTomate = i;
			}
		}
		this.quantité.set(iTomate, this.quantité.get(iTomate)+nouvelleQuantité);
	}
	
	public Tomates getTomates() {
		return this.tomates;
	}
	
	public List<Integer> getQuantité() {
		return this.quantité;
	}
	
}
