package ExerciceNio.metier;
import ExerciceNio.model.Ville;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
        /**
         * @author <h2 style="color:red;">AOUKACH EL MEHDI, OUSSAMA ER-RZIKI</h2>
         */

public class ServiceVilles implements IServiceVille{
        /**
         * Path est une variable pour declarer le chemin vers le fichier villes qu'on va utiliser dans cet exercice
         */
    Path source;

        /**
         * Constructeur de la classe ServiceVilles avec lequel on va accéder à toutes les méthodes déclarées
         * @param source : Path du fichier qu'on va utiliser
         */
    public ServiceVilles(Path source){
        this.source=source;
    }

        /**
         * Générer un fichier villeTriNom oû les villes sont triés par nom
         * @param Villes : Tableau de type villes
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         */
    public void trierVilleNom(List<Ville> Villes) throws IOException{
        Path fichierTrierParNom = Paths.get("xSortedFiles\\villesTriNom");
        Comparator<Ville> TrieparNom = Comparator.comparing(ExerciceNio.model.Ville::getNom);
        Villes.sort(TrieparNom);
        Files.write(fichierTrierParNom , "ID      NOM     POPULATION     REGION".getBytes());
        Files.write(fichierTrierParNom,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
        Villes.forEach(s->{
            try {Files.write(fichierTrierParNom,s.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(fichierTrierParNom,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

        /**
         * Générer un fichier villeTriPopulation oû les villes sont triés par population
         * @param Villes : Tableau de type villes
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         * */
    public void trierVillePopulation(List<Ville> Villes) throws IOException{
        Path fichierTrierParPopulation = Paths.get("xSortedFiles\\villesTriPopulation");
        Comparator<Ville> fichierTrierPopulation = Comparator.comparing(ExerciceNio.model.Ville::getPopulation);
        Villes.sort(fichierTrierPopulation);
        Files.write(fichierTrierParPopulation , "ID      NOM     POPULATION     REGION".getBytes());
        Files.write(fichierTrierParPopulation,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
        Villes.forEach(s->{
            try {Files.write(fichierTrierParPopulation,s.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(fichierTrierParPopulation,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
        /**
         * Générer un fichier villeTriRegion oû les villes sont triés par région
         * @param Villes : Tableau de type villes
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         * */
    public void trierVilleRegion(List<Ville> Villes) throws IOException {
        Path fichierTrierParRegion = Paths.get("xSortedFiles\\villesTriRegion");
        Comparator<Ville> fichierTrierPopulation = Comparator.comparing(ExerciceNio.model.Ville::getRegion);
        Villes.sort(fichierTrierPopulation);
        Files.write(fichierTrierParRegion , "ID      NOM     POPULATION     REGION".getBytes());
        Files.write(fichierTrierParRegion,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
        Villes.forEach(s->{
            try {Files.write(fichierTrierParRegion,s.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(fichierTrierParRegion,"\n".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

        /**
         * Lire un fichier en utilisant la bibliothèque IO et placer le fichier ligne par ligne dans un tableau objets Villes
         * en utilisant objet StringTokenizer
         * @return List des objets de type Ville
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         */
    @Override
    public List<Ville> lireBDVilles_IO() throws IOException {
        List<Ville> ListVille = new ArrayList<>();
        List<String> ListV = new ArrayList<>();

        InputStream fis ;
        fis = new BufferedInputStream(new FileInputStream(source.toFile()));

        StringBuilder line= new StringBuilder();
        while (fis.read() !=-1){
            char c = (char) fis.read();
            System.out.print((char) fis.read());
            if(c == '\n'){
                    ListV.add(line.toString());
                    line= new StringBuilder();
                }
                else line.append(c);
            }

       ListV.forEach(s-> {
            StringTokenizer st = new StringTokenizer(s, "\t");
            while (st.hasMoreTokens()) {
                String idVille = st.nextToken();
                String nomVille = st.nextToken();
                String regionVille = st.nextToken();
                String populationVille = st.nextToken();
                Ville v = new Ville(idVille, nomVille, populationVille, regionVille);
                ListVille.add(v);
            }
        });
        return ListVille;
    }
        /**
         * Lire un fichier en utilisant la bibliothèque NIO et placer le fichier ligne par ligne dans un tableau objets Villes
         * en utilisant objet StringTokenizer
         * @return List des objets de type Ville
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         */
    @Override
    public List<Ville> lireBDVilles_NIO() throws IOException {
        List<String> liste ;
        List<Ville> ListeVilles = new ArrayList<>();
        liste = Files.readAllLines(source);
        liste.forEach(s-> {
            StringTokenizer st = new StringTokenizer(s, "#");
            while (st.hasMoreTokens()) {
                String idVille = st.nextToken();
                String nomVille = st.nextToken();
                String regionVille = st.nextToken();
                String populationVille = st.nextToken();
                Ville v = new Ville(idVille, nomVille, populationVille, regionVille);
                ListeVilles.add(v);
            }
        });
        return ListeVilles;
    }
        /**
         * Lire un fichier en utilisant la bibliothèque SCANNER et placer le fichier ligne par ligne dans un tableau objets Villes
         * en utilisant objet StringTokenizer
         * @return List des objets de type Ville
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         */
    @Override
    public List<Ville> lireBDVilles_Scanner() throws IOException {
        ArrayList<Ville> listVilles = new ArrayList<>();
        Scanner fis = new Scanner(source.toFile());
        fis.nextLine();
        while (fis.hasNextLine()){
            StringTokenizer st = new StringTokenizer(fis.nextLine(), "\t");
            while (st.hasMoreTokens()){
                String idVille = st.nextToken();
                String nomVille= st.nextToken();
                String regionVille = st.nextToken();
                String populationVille= st.nextToken();
                Ville v= new Ville(idVille,nomVille, populationVille,regionVille);
                listVilles.add(v);
            }
        }

        return listVilles;
    }

        /**
         * La méthode que regroupe tout les méthodes du tri en haut
         * @param Villes : Tableau de type Ville
         * @throws IOException : Declarer la possibilité de rencontré une exception de type IOException
         */
    @Override
    public void trierVilles(List<Ville> Villes) throws IOException {
        trierVilleNom(Villes);
        trierVillePopulation(Villes);
        trierVilleRegion(Villes);
    }

    @Override
    public void writeToFile(String texte) throws IOException {
        Files.write(source,texte.getBytes(),StandardOpenOption.APPEND);
    }

    @Override
    public void clearFille() throws IOException {
                Files.write(source,"".getBytes(StandardCharsets.UTF_8));
            }

        }
