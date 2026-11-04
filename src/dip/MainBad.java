package dip;

class MySQLDatabaseBad {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class OrderProcessorBad {
    private MySQLDatabaseBad database;

    public OrderProcessorBad() {
        // MAUVAIS DESIGN : Couplage fort
        // La classe de haut niveau instancie directement une classe concrète de bas niveau
        this.database = new MySQLDatabaseBad();
    }

    public void processOrder(String order) {
        database.save(order);
    }
}

public class MainBad {
    public static void main(String[] args) {
        OrderProcessorBad order = new OrderProcessorBad();
        order.processOrder("'Données à sauvegarder'");
    }
}