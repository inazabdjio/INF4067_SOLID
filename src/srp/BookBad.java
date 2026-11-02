package srp;

public class BookBad {
    private String title;
    private String author;
    private String content;


    public BookBad(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;

    }

    // Responsabilite 1 : Gerer les donnees du livre
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
    


    // Responsabilite 2 : Afficher le livre (presentation)

public void printToScreen() {

    System.out.println("Titre : " + title);
    System.out.println("Author : " + author);
    System.out.println("Content : " + content);

}    

// Responsabilite 3 :  Sauvegarder le livre (persistance)
public void saveToDatabase(){
    System.out.println("Sauvegarde du livre '" + title +"' en base de donnees...");
}

// Responsabilite 4 : (logique metier)

public void emprunter(String lecteur) {
    System.out.println("Emprunt du livre '" + title + "' par " + lecteur);
}


// Utilisation

public static void main (String[] args) {
    BookBad book = new BookBad("Les pricipes SOLID", "Etudiant de M1-GL", "Revision des principes SOLID");
    book.printToScreen();
    book.saveToDatabase();
    book.emprunter("Marcial");
}

}


 