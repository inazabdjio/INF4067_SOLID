package srp;

//Gerer les donnees
class BookSRP {
    private String title;
    private String author;
    private String content;

    public BookSRP(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
    

    // Methodes pour acceder aux donnees (getters)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

}
    // classe BookPrinter : presentation

    class BookPrinter {
        public void printToScreen(BookSRP book) {
            System.out.println("\n===Print to Screnn=== ");
            System.out.println("Titre : " + book.getTitle());
            System.out.println("Auteur : " + book.getAuthor());
            System.out.println("Contenu : " + book.getContent());

        }
    
    // On peut ajouter d'autres methodes d'affichage sans toucher a BookSR
        
        public void printToHTML(BookSRP book) {
            System.out.println("\n===Print to HTML=== ");
            System.out.println("Titre : " + book.getTitle() + "</h1>");
            System.out.println("Auteur : " + book.getAuthor() + "</h2>");
            System.out.println("Contenu : " + book.getContent() + "</p>");

        } 

    }


    // Classe BookSver : persistance

    class BookSaver {
        public void saveToDatabse(BookSRP book) {
            System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de donnees...");
        }

        // On peut ajouter d'autres facons de sauvegarder
        

    }

    // classe BookBusinessLogic : Logique metier

    class BookBusinessLogic {
        public void emprunter(BookSRP book, String lecteur) {
            System.out.println("\nEmprunt du livre '" + book.getTitle() + "' par " + lecteur);
        }
    }

    public class BookGood {
        public static void main(String[] args){
            BookSRP book  = new BookSRP ("Les pricipes SOLID", "Etudiant de M1-GL", "Revision des principes SOLID");
            new BookPrinter().printToScreen(book);
            new BookSaver().saveToDatabse(book);
            new BookBusinessLogic().emprunter(book, "Marcial");


        }
    }

