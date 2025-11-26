package modèle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tomate {

    private TypeTomate type;
    private Couleur couleur;
    private String désignation;
    private String sousTitre;
    private String nomImage;
    private String description;
    private int stock;
    private int nbGrainesParSachet;
    private float prixTTC;
    private List<Tomate> tomatesApparentées;

    public Tomate(TypeTomate type, Couleur couleur, String désignation,
            String sousTitre, String nomImage, String description, int stock,
            int nbGrainesParSachet, float prixTTC) {
        this.type = type;
        this.couleur = couleur;
        this.désignation = désignation;
        this.sousTitre = sousTitre;
        this.nomImage = nomImage;
        this.description = description;
        this.stock = stock;
        this.nbGrainesParSachet = nbGrainesParSachet;
        this.prixTTC = prixTTC;
        this.tomatesApparentées = new ArrayList<>();
    }

   public boolean diminuerStock(int quantiteAchetee) {
        if (this.stock >= quantiteAchetee) {
            this.stock -= quantiteAchetee;
            return true;
        }
        return false;
    }

    public TypeTomate getType() { return this.type; }
    public Couleur getCouleur() { return this.couleur; }
    public String getDésignation() { return this.désignation; }
    public void setStock(int v) { this.stock = v; }
    public String getSousTitre() { return this.sousTitre; }
    public String getNomImage() { return this.nomImage; }
    public String getDescription() { return this.description; }
    public int getStock() { return this.stock; }
    public int getNbGrainesParSachet() { return this.nbGrainesParSachet; }
    public float getPrixTTC() { return this.prixTTC; }
    public List<Tomate> getTomatesApparentées() { return this.tomatesApparentées; }

    public void addTomateApparentée(Tomate tomate) {
        if (tomate != null && this != tomate && this.type.equals(tomate.type) && !this.tomatesApparentées.contains(tomate)) {
            this.tomatesApparentées.add(tomate);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(couleur, désignation, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tomate)) return false;
        Tomate other = (Tomate) obj;
        return Objects.equals(this.désignation, other.désignation);
    }

    @Override
    public String toString() {
        return "Tomate [désignation=" + désignation + ", stock=" + stock + ", prix=" + prixTTC + "]";
    }
}