public class Book extends LibraryItem{

    private String author;

    public Book(String author, String title, boolean availability){
        super(title, availability);
        this.author = author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    @Override
    public String toString(){
        return "Title: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nAvailable: " + getAvailability();
    }
}
