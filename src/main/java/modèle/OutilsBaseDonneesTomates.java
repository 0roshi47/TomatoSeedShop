package modèle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OutilsBaseDonneesTomates {

    public static Tomates générationBaseDeTomates(String cheminFichier) {
        List<Tomate> tomates = lectureTomatesDepuisJson(cheminFichier);
        ajoutAléatoireTomatesApparentées(tomates);
        Tomates base = new Tomates();
        base.addTomates(tomates);
        return base;
    }

    public static void sauvegarderBaseDeTomates(Tomates base, String cheminFichier) {
        écritureTomatesVersJson(base.getTomates(), cheminFichier);
    }

    private static void ajoutAléatoireTomatesApparentées(List<Tomate> tomates) {
        for (Tomate t : tomates) {
            if (t.getTomatesApparentées().isEmpty()) { 
                int tentatives = 0;
                while (t.getTomatesApparentées().size() < 4 && tentatives < 20) {
                    int random = (int) (tomates.size() * Math.random());
                    t.addTomateApparentée(tomates.get(random));
                    tentatives++;
                }
            }
        }
    }

    private static List<Tomate> lectureTomatesDepuisJson(String cheminFichier) {
        List<Tomate> tomates = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(cheminFichier)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                
                TypeTomate type = TypeTomate.getTypeTomate(obj.getString("type"));
                if(type == null) type = TypeTomate.TOMATES; 
                
                Couleur couleur = Couleur.getCouleur(obj.getString("couleur"));
                if(couleur == null) couleur = Couleur.ROUGE;

                Tomate tomate = new Tomate(
                        type,
                        couleur,
                        obj.getString("désignation"),
                        obj.getString("sousTitre"),
                        obj.getString("nomImage"),
                        obj.getString("description"),
                        obj.getInt("stock"),
                        obj.getInt("nbGrainesParSachet"),
                        (float) obj.getDouble("prixTTC")
                );
                tomates.add(tomate);
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture JSON: " + e.getMessage());
        }
        return tomates;
    }

    private static void écritureTomatesVersJson(List<Tomate> tomates, String cheminFichier) {
        JSONArray jsonArray = new JSONArray();
        for (Tomate tomate : tomates) {
            JSONObject obj = new JSONObject();
            obj.put("type", tomate.getType().getDénomination());
            obj.put("couleur", tomate.getCouleur().getDénomination());
            obj.put("désignation", tomate.getDésignation());
            obj.put("sousTitre", tomate.getSousTitre());
            obj.put("nomImage", tomate.getNomImage());
            obj.put("description", tomate.getDescription());
            obj.put("stock", tomate.getStock());
            obj.put("nbGrainesParSachet", tomate.getNbGrainesParSachet());
            obj.put("prixTTC", tomate.getPrixTTC());
            jsonArray.put(obj);
        }
        try {
            Files.write(Paths.get(cheminFichier), jsonArray.toString(4).getBytes());
            System.out.println("Base de données sauvegardée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}