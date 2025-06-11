package modèle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TomateTest {

    private static Tomates tomates;
    private Tomate ananas;
    private Tomate banane;

    private static final String NOM_ANANAS = "Tomate Ananas";
    private static final String NOM_BANANE = "Tomate Banana Legs";
    private static final int STOCK_INIT = 5;

    @BeforeClass
    public static void setUpClass() {
        tomates = OutilsBaseDonneesTomates.générationBaseDeTomates(
                "src/main/resources/data/tomates.json");
    }

    @Before
    public void setUp() {
        ananas = tomates.getTomate(NOM_ANANAS);
        banane = tomates.getTomate(NOM_BANANE);
    }

    @Test
    public void testSetStock() {
        ananas.setStock(10);
        assertEquals(10, ananas.getStock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStockInfZero() {
        ananas.setStock(-10);
    }

    @Test
    public void testSetStockZero() {
        ananas.setStock(0);
        assertEquals(0, ananas.getStock());
    }

    @Test
    public void testGetType() {
        assertEquals("Autres Tomates (47)", ananas.getType().getDénomination());
    }

    @Test
    public void testGetCouleur() {
        assertEquals("Jaune", ananas.getCouleur().getDénomination());
    }

    @Test
    public void testGetSousTitre() {
        assertEquals("", ananas.getSousTitre());
    }

    @Test
    public void testHashCode() {
        assertNotEquals(ananas.hashCode(), banane.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(ananas.equals(ananas));
        assertFalse(ananas.equals(banane));
        assertFalse(ananas.equals(null));
        assertFalse(ananas.equals("not a Tomate"));
    }

    @Test
    public void testEqualsOverloaded() {
        assertFalse(ananas.equals(banane));
    }

    @Test
    public void testToString() {
        String expectedString = "Tomate Ananas [stock=" + STOCK_INIT + ", type=Autres Tomates (47), couleur=Jaune]";
        assertEquals(expectedString, ananas.toString());
    }
}
