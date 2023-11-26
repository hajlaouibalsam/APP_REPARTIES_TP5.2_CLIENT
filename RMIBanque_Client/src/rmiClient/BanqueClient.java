package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.IBanque;
import metier.Compte;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            // Accès au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération de l'objet distant depuis le registre
            IBanque banque = (IBanque) registry.lookup("BanqueService");

            // Exemple d'utilisation des méthodes de l'objet distant
            Compte nouveauCompte = new Compte(123, 1000.0, new java.util.Date());
            String resultatCreation = banque.creerCompte(nouveauCompte);
            System.out.println(resultatCreation);

            int codeCompte = 123; // Remplacez par le code du compte réel
            String resultatInfoCompte = banque.getInfoCompte(codeCompte);
            System.out.println(resultatInfoCompte);

        } catch (Exception e) {
            System.err.println("Erreur du client RMI : " + e.toString());
            e.printStackTrace();
        }
    }
}