package modèle;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ihm.accueil;

public class PanierTest{
    
    private static Tomates tomates;
    
    //faut ajouter des gets petinents pour les tests (faire aussi fonction vider  dans panier)
    
    @BeforeClass
    public static void setUp() {
        tomates = OutilsBaseDonneesTomates.générationBaseDeTomates(
                "src/main/resources/data/tomates.json");
    }
    
    //vérifier le panier (ajout article, suppression, vider panier, get panier)
    
    @Test
    public void testAjouterTomate() {
		Panier panier = new Panier();
		Tomate tomate = tomates.getTomates().get(0);
		panier.ajouterTomate(tomate, 1);
		
		List<Tomate> contenuPanier = panier.getTomates().getTomates();
		assertEquals(1, contenuPanier.size());
		assertEquals(tomate, contenuPanier.get(0));
	}
    @Test
	public void testAjouterQuantité() {
		Panier panier = new Panier();
		Tomate tomate = tomates.getTomates().get(0);
		panier.ajouterTomate(tomate, 1);
		
		panier.ajouterQuantité(tomate, 2);
		
		List<Integer> quantités = panier.getQuantité();
		assertEquals(1, quantités.size());
		assertEquals(3, (int) quantités.get(0));
	}
	
	@Test
	public void testTotal() {
		Panier panier = new Panier();
		Tomate tomate = tomates.getTomates().get(0);
		panier.ajouterTomate(tomate, 2);
		
		float total = panier.total();
		assertEquals(tomate.getPrixTTC() * 2, total, 0.01);
	}
	@Test
	public void testViderPanier() {
		Panier panier = new Panier();
		Tomate tomate = tomates.getTomates().get(0);
		panier.ajouterTomate(tomate, 1);
		
		panier = new Panier();
		
		assertTrue(panier.getTomates().getTomates().isEmpty());
		assertTrue(panier.getQuantité().isEmpty());
	}
	
    
    
}


