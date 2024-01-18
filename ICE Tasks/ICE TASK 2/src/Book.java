enum Genre{
    FICTION, 
    SCIENCE_FICTION,
    MYSTERY,
    FANTASY, 
    ROMANCE
}

public class Book{
    String title, author; 
    Genre genre; 

    public Book(){};

    public Book(String title, String author, Genre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre;
    }
}