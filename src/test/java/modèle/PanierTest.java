package modèle;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class PanierTest{
    
    private static Tomates tomates;
    
    //faut ajouter des gets petinents pour les tests (faire aussi fonction vider  dans panier)
    
    @BeforeClass
    public static void setUp() {
        tomates = OutilsBaseDonneesTomates.générationBaseDeTomates(
                "src/main/resources/data/tomates.json");
    }
    
    @Test
    public void testPrixTotPanierVide() {
        Panier panier = new Panier();
        assertEquals(0.0f, panier.getPrixTotal(), 0.01f);
    }
    
    @Test
    public void testPrixTotPanierNonVide() {
        Panier panier= new Panier();
        panier.ajouterTomate(tomates.getTomate(TOMATE_ANANAS), 1);
        assertEquals(PRIX_ANANAS, panier.getPrixTotal(), 0.01f);
    }

    @Test
    public void testAjouterTomatePanierVide() {
        Panier panier= new Panier();
        panier.ajouterTomate(tomates.getTomate(TOMATE_ANANAS), 1);
        assertEquals(1, panier.getListeDeTomates().size());
    }

    @Test
    public void testAjouterTomateDeuxFois() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);

        panier.ajouterTomate(ananas, 1);
        assertEquals(1, panier.getQuantités().size());
        assertEquals(Integer.valueOf(1), panier.getQuantités().get(0));

        panier.ajouterTomate(ananas, 1);
        assertEquals(1, panier.getQuantités().size());
        assertEquals(Integer.valueOf(2), panier.getQuantités().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterTomatePlusQueStock() {
        Panier panier= new Panier();
        panier.ajouterTomate(tomates.getTomate(TOMATE_ANANAS), STOCK_ANANAS + 1);
    }

    @Test
    public void testSupprimerTomatePanierNonVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        panier.ajouterTomate(ananas, 2);
        panier.ajouterTomate(brandywine, 2);
        assertEquals(2, panier.getListeDeTomates().size());
        panier.supprimerTomate(brandywine);
        assertEquals(1, panier.getListeDeTomates().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupprimerTomatePanierVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.supprimerTomate(ananas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnleverTomatePanierVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.enleverUneTomate(ananas);
    }

    @Test
    public void testEnleverTomatePanierNonVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 2);
        assertEquals(2, panier.getQuantités(ananas).intValue());
        panier.enleverUneTomate(ananas);
        assertEquals(1, panier.getQuantités(ananas).intValue());
    }

    @Test
    public void testEnleverTomateSupprTomate() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 1);
        assertEquals(1, panier.getQuantités().size());
        panier.enleverUneTomate(ananas);
        assertEquals(0, panier.getQuantités().size());
    }

    @Test
    public void testGetPrixTotalParTomatePanierVide() {
        Panier panier= new Panier();
        List<Float> liste = panier.getPrixTotalParTomate();
        assertTrue(liste.isEmpty());
    }

    @Test
    public void testGetPrixTotalParTomatePanierNonVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 1);

        List<Float> liste = panier.getPrixTotalParTomate();

        assertFalse(liste.isEmpty());
        assertEquals(1, liste.size());
        assertEquals(PRIX_ANANAS, liste.get(0), 0.001f);
    }

    @Test
    public void testEstVide() {
        Panier panier= new Panier();
        assertTrue(panier.estVide());
    }

    @Test
    public void testVider() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 1);
        panier.vider();
        assertTrue(panier.estVide());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterTomateQuantiteNulle() {
        Panier panier= new Panier();
        panier.ajouterTomate(tomates.getTomate(TOMATE_ANANAS), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterTomateQuantiteNegative() {
        Panier panier= new Panier();
        panier.ajouterTomate(tomates.getTomate(TOMATE_ANANAS), -1);
    }

    @Test
    public void testSupprimerTomateNonPresente() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 1);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        panier.supprimerTomate(brandywine); 
        assertEquals(1, panier.getListeDeTomates().size());
    }

    @Test
    public void testAjouterPlusieursTomates() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        
        panier.ajouterTomate(ananas, 2);
        panier.ajouterTomate(brandywine, 3);
        
        assertEquals(2, panier.getQuantités(ananas).intValue());
        assertEquals(3, panier.getQuantités(brandywine).intValue());
        assertEquals(2 + 3, panier.getListeDeTomates().size());
    }

    @Test
    public void testPrixTotalAvecPlusieursTomates() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        
        panier.ajouterTomate(ananas, 2);
        panier.ajouterTomate(brandywine, 1); 
        float expectedTotal = (2 * PRIX_ANANAS) + 4.0f;
        panier.ajouterTomate(brandywine, 1); 
        float expectedTotal = (2 * PRIX_ANANAS) + 4.0f; 
        assertEquals(expectedTotal, panier.getPrixTotal(), 0.01f);
    }

    @Test
    public void testQuantitesAvecPlusieursTomates() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        
        panier.ajouterTomate(ananas, 2);
        panier.ajouterTomate(brandywine, 3);
        
        assertEquals(2, panier.getQuantités(ananas).intValue());
        assertEquals(3, panier.getQuantités(brandywine).intValue());
    }

    @Test
    public void testViderPanierNonVide() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        panier.ajouterTomate(ananas, 1);
        assertFalse(panier.estVide());
        panier.vider();
        assertTrue(panier.estVide());
    }

    @Test
    public void testGetListeDeTomates() {
        Panier panier= new Panier();
        Tomate ananas = tomates.getTomate(TOMATE_ANANAS);
        Tomate brandywine = tomates.getTomate(TOMATE_BRANDYWINE);
        
        panier.ajouterTomate(ananas, 1);
        panier.ajouterTomate(brandywine, 1);
        
        List<Tomate> liste = panier.getListeDeTomates();
        assertEquals(2, liste.size());
        assertTrue(liste.contains(ananas));
        assertTrue(liste.contains(brandywine));
    }
}


