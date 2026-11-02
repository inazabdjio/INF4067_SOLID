package couplage;

import java.util.List;

// Classe factice pour simuler la connexion MYSQL du support

class MysqlConnection {
    public MysqlConnection(String host, String user, String pwd){}
    public void executerRequete(String req){System.out.println(req); }
}

public class CommandeBad {
    private List<Double> prixItems;
    private double total;

    public CommandeBad(List<Double> prixItems) {
        this.prixItems = prixItems;
    }

    // BON : Logique metier propre a la commande

public void calculerTotal() {
    this.total = prixItems.stream().mapToDouble(Double::doubleValue).sum();
}
    // MAUVAIS : faible cohesion (melange metier et technique)
    // MAUVAIS : fort couplage (figer sur MYSQL, impossible de changer facilement)

public void sauvegarderDansBaseMysql() {
    MysqlConnection connexion = new MysqlConnection("localhost", "root", "password");
    String requete = "INSERT INTO commandes (total) VALUES (" + this.total + ")";
    connexion.executerRequete(requete);
}    


public static void main(String[] args) {
    // Creation d'une liste de prix

    List<Double> mesPrix = List.of(10.5, 20.0, 5.0);

    //Instanciation de la commande

    CommandeBad maCommande = new CommandeBad(mesPrix);
    //Calcul total

    maCommande.calculerTotal();

    //Tentative de sauvegarde

    maCommande.sauvegarderDansBaseMysql();
}
    
}
