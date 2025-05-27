package modèle;

public class Panier {

	private Tomates tomates;
	
	public Panier() {
		this.tomates = new Tomates(); //un nouveau panier est considéré comme vide
	}
	
	public float total() {
		float resultat = 0.0F;
		for (Tomate tomate : this.tomates.getTomates()) {
			resultat += tomate.getPrixTTC();
		}
		return resultat;
	}
	
}
