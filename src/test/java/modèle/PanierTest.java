package modèle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class PanierTest {
	
    private static Panier panier;
    private static Tomate tomateEnStock;
    private static Tomate tomateEnRupture;

    @BeforeClass
    public static void setUp() throws Exception {
        Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
        tomateEnRupture = tomates.getTomate("Tomate Chair de Boeuf « Beefsteak »");
        tomateEnStock = tomates.getTomate("Tomate Joie de la Table");
        panier  = new Panier();
    }
    
    @Test
    public void testAjoutTomate() {
        panier.ajouterTomate(tomateEnStock, 1);
        assertEquals(4.95F, panier.total(), 0.1F);
    }
}
