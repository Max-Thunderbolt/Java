import java.util.ArrayList;

public class Library extends Book {
    
    public Library(String string, String string2, Genre mystery) {
        super(string, string2, mystery);
    }

    public static void main(String[] args) {
        // Create an ArrayList of Book objects
        ArrayList<Book> books = new ArrayList<Book>();

        // Populate ArrayList with books
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION));
        books.add(new Book("The Da Vinci Code", "Dan Brown", Genre.MYSTERY));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", Genre.FANTASY));

        // Print out each book in the ArrayList
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
