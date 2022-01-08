package ExerciceNio;

import ExerciceNio.metier.IServiceVille;
import ExerciceNio.metier.ServiceVilles;

import java.io.*;
import java.nio.file.Paths;

/**
 * @author <h2 style="color:red;">AOUKACH EL MEHDI, OUSSAMA ER-RZIKI</h2>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
        service.lireBDVilles_NIO().forEach(System.out::println);
        service.trierVilles(service.lireBDVilles_NIO());
    }
}
