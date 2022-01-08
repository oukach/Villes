package ExerciceNio.metier;

import ExerciceNio.model.Ville;
import java.io.IOException;
import java.util.List;
/**
 * @author <h2 style="color:red;">AOUKACH EL MEHDI, OUSSAMA ER-RZIKI</h2>
 */
public interface IServiceVille {
    List<Ville> lireBDVilles_IO() throws IOException;
    List<Ville> lireBDVilles_NIO() throws IOException;
    List<Ville> lireBDVilles_Scanner() throws IOException;
    void trierVilles(List<Ville> villes) throws IOException;
    void writeToFile(String texte) throws IOException;
    void clearFille() throws IOException;
}
