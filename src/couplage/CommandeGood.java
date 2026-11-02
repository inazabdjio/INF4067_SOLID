package couplage;

import java.util.List;
// 1. ABSTRACTION (Pour garantir le faible couplage)
interface BaseDonnees {
    void executer(String requete);
}

// Implementation concrete interchangeable
class MysqlDatabase implements BaseDonnees {
    public void executer(String requete) {
        System.out.println("Execution MySQL: " + requete);
    }
}

// 2. CLASSES AVEC FORTE COHESION
// Cette classe ne gere que les donnees de la classe commande

class Commande {
    private List<Double> prixItems;

    public Commande(List<Double> prixItems) {
        this.prixItems = prixItems;
    }

    // BON : Logique metier propre a la commande

    public double getCalculerTotal() {
        return prixItems.stream().mapToDouble(Double::doubleValue).sum();
    }
}

class CommandeRepository {
    private BaseDonnees db;

    // Injection de dependances

    public CommandeRepository(BaseDonnees db) {
        this.db = db; // Faible couplage
    }

    public void sauvegarder(Commande commande) {
        String requete = "INSERT INTO commandes (total) VALUES (" + commande.getCalculerTotal() +")";
        db.executer(requete);
    }
}

public class CommandeGood {
    public static void main(String[] args) {
        // choix de la base
        BaseDonnees maBaseDeDonnees = new MysqlDatabase();

    
    //Injection daans repository

    CommandeRepository repository = new CommandeRepository(maBaseDeDonnees);

    // Creation d'une commande 
    Commande maCommande = new Commande(List.of(15.0, 30.0, 5.5));

    //Sauvegarde

    repository.sauvegarder(maCommande);
    }
}
