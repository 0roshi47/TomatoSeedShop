package modèle;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class PanierTest {
    
    private static Tomates baseTomates;
    
    @BeforeClass
    public static void setUp() {
        // Chargement de la base pour avoir des vrais objets Tomate à tester
        baseTomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
    }
    
    @Test
    public void testAjouterTomate() {
        Panier panier = new Panier();
        // On prend la première tomate de la base
        Tomate tomate = baseTomates.getTomates().get(0);
        
        panier.ajouterTomate(tomate, 1);
        
        Map<Tomate, Integer> contenu = panier.getContenu();
        
        assertEquals("Le panier doit contenir 1 élément", 1, contenu.size());
        assertTrue("Le panier doit contenir la tomate ajoutée", contenu.containsKey(tomate));
        assertEquals("La quantité doit être de 1", (Integer) 1, contenu.get(tomate));
    }

    @Test
    public void testAjouterQuantitéCumulée() {
        Panier panier = new Panier();
        Tomate tomate = baseTomates.getTomates().get(0);
        
        // Ajout en deux fois
        panier.ajouterTomate(tomate, 1);
        panier.ajouterTomate(tomate, 2); // Devrait faire 1 + 2 = 3
        
        Map<Tomate, Integer> contenu = panier.getContenu();
        
        assertEquals("Le panier ne doit toujours contenir qu'une seule ligne (la même tomate)", 1, contenu.size());
        assertEquals("La quantité totale doit être 3", (Integer) 3, contenu.get(tomate));
    }
    
    @Test
    public void testTotal() {
        Panier panier = new Panier();
        
        Tomate t1 = baseTomates.getTomates().get(0);
        Tomate t2 = baseTomates.getTomates().get(1);
        
        // On s'assure que ce sont des tomates différentes pour le test
        assertNotEquals(t1, t2);
        
        panier.ajouterTomate(t1, 2); // 2 fois la tomate 1
        panier.ajouterTomate(t2, 1); // 1 fois la tomate 2
        
        float attendu = (t1.getPrixTTC() * 2) + (t2.getPrixTTC() * 1);
        
        assertEquals(attendu, panier.total(), 0.01);
    }
    
    @Test
    public void testViderPanier() {
        Panier panier = new Panier();
        Tomate tomate = baseTomates.getTomates().get(0);
        panier.ajouterTomate(tomate, 5);
        
        assertFalse("Le panier ne devrait pas être vide au début", panier.getContenu().isEmpty());
        
        panier.viderPanier(); // Appel de la méthode, pas de new Panier()
        
        assertTrue("Le panier devrait être vide après viderPanier()", panier.getContenu().isEmpty());
        assertEquals("Le total doit être 0", 0.0f, panier.total(), 0.01);
    }
    
    @Test
    public void testRetirerTomate() {
        Panier panier = new Panier();
        Tomate t1 = baseTomates.getTomates().get(0);
        Tomate t2 = baseTomates.getTomates().get(1);
        
        panier.ajouterTomate(t1, 1);
        panier.ajouterTomate(t2, 1);
        
        panier.retirerTomate(t1);
        
        assertFalse("T1 ne devrait plus être dans le panier", panier.getContenu().containsKey(t1));
        assertTrue("T2 devrait toujours être là", panier.getContenu().containsKey(t2));
    }

    /**
     * Teste la nouvelle fonctionnalité critique : 
     * Vérifie que le stock de l'objet Tomate diminue quand on valide le panier.
     */
    @Test
    public void testValidationCommandeEtStock() {
        Panier panier = new Panier();
        Tomate tomate = baseTomates.getTomates().get(2); // On prend une tomate au hasard
        
        int stockInitial = tomate.getStock();
        int quantiteAchetee = 2;
        
        // On s'assure qu'il y a assez de stock pour le test
        if (stockInitial < quantiteAchetee) {
            tomate.setStock(10);
            stockInitial = 10;
        }

        panier.ajouterTomate(tomate, quantiteAchetee);
        
        // Action : Validation de la commande (ce qui déclenche la baisse de stock)
        panier.validerLaCommande();
        
        // Vérification
        assertEquals("Le stock aurait dû diminuer de " + quantiteAchetee, 
                stockInitial - quantiteAchetee, 
                tomate.getStock());
    }
}