import java.util.ArrayList;

public class LibraryItem {
    private String title, identifier;
    private int publicationYear;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    LibraryItem() {
    }

    LibraryItem(String title, String identifier, int publicationYear) {
        this.title = title;
        this.identifier = identifier;
        this.publicationYear = publicationYear;
    }

}

class Book extends LibraryItem {

    private int numberOfPages;

    Book(String title, String identifier, int publicationYear) {
        super(title, identifier, publicationYear);
    }

    public void setNumberOfPages(int numPages) {
        this.numberOfPages = numPages;
    }

    public int getNUmberOfPages() {
        return this.numberOfPages;
    }
}

class DVD extends LibraryItem {

    private int durationInMinutes;

    DVD(String title, String identifier, int publicationYear) {
        super(title, identifier, publicationYear);
    }

    public void setDurationInMinutes(int minutes) {
        this.durationInMinutes = minutes;
    }

    public int getDurationInMinutes() {
        return this.durationInMinutes;
    }
}

class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Book 1", "Book", 2002);
        book1.setNumberOfPages(100);
        Book book2 = new Book("Book 2", "Book", 1997);
        book2.setNumberOfPages(150);

        DVD dvd1 = new DVD("NOW THAT'S WHAT I CALL NOISE!", "DVD", 2015);
        dvd1.setDurationInMinutes(120);
        DVD dvd2 = new DVD("NOW THAT'S WHAT I CALL NOISE! Vol. 2", "DVD", 2016);
        dvd2.setDurationInMinutes(115);

        ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();
        items.add(book1);
        items.add(book2);
        items.add(dvd1);
        items.add(dvd2);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdentifier().equals("Book")) {
                System.out.println("Type: " + items.get(i).getIdentifier() + "\nTitle: "
                        + items.get(i).getTitle() + "\nPages: "
                        + ((Book) items.get(i)).getNUmberOfPages());
            } else {
                System.out.println("Type: " + items.get(i).getIdentifier() + "\nTitle: "
                        + items.get(i).getTitle() + "\nDuration: "
                        + ((DVD) items.get(i)).getDurationInMinutes());
            }
        }
    }

    // hello copilot

}