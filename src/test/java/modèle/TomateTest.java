package modèle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TomateTest {

    private static Tomate tomate;

    @BeforeClass
    public static void setUp() throws Exception {
        Tomates tomates = OutilsBaseDonneesTomates.générationBaseDeTomates("src/main/resources/data/tomates.json");
        Tomate tomateEnStock = tomates.getTomate("Tomate Délice du Jardinier");
        Tomate tomateRupture = tomates.getTomate("Tomate Chair de Boeuf « Beefsteak »");
    }
}
