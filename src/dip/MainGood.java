package dip;

// 1. Abstraction (Interface commune)
interface Database {
    public void save(String data);
}

// 2. Implémentations concrètes interchangeables
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

// 3. Module de haut niveau dépendant de l'abstraction (Injection de dépendance)
class OrderProcessor {
    private Database database;

    public OrderProcessor(Database database) {
        this.database = database; // Faible couplage : on reçoit une interface, pas une classe concrète
    }

    public void processOrder(String order) {
        database.save(order);
    }
}

// 4. Classe principale conforme au cours (pages 43-44)
public class MainGood {
    public static void main(String[] args) {
        Database database;

        // Utilisation avec MySQL
        database = new MySQLDatabase();
        OrderProcessor order = new OrderProcessor(database);
        order.processOrder("'Données à sauvegarder'");

        // Utilisation avec MongoDB (sans modifier OrderProcessor)
        database = new MongoDBDatabase();
        OrderProcessor order1 = new OrderProcessor(database);
        order1.processOrder("'Données à sauvegarder'");
    }
}