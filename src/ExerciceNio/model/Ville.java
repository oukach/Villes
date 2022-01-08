package ExerciceNio.model;
/**
 * @author <h2 style="color:red;">AOUKACH EL MEHDI, OUSSAMA ER-RZIKI</h2>

 */
public class Ville {
    private final String id;
    private final String nom;
    private final String population;
    private final String region;

    public Ville(String id, String nom, String region ,String population) {
        this.id = id;
        this.nom = nom;
        this.population = population;
        this.region = region;
    }
    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPopulation() {
        return population;
    }
    public String getRegion() {
        return region;
    }

    /**
     * toString pour afficher objet courant
     * @return affichage selon le format : [id-nom-population-region]
     */
    @Override
    public String toString() {
        return
                "[" + id +
                        "-\t " + nom  +
                "-\t " + population +
                "-\t" + region  +
                ']';
    }

}
