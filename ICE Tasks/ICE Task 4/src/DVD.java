public class DVD extends LibraryItem{

    private String director;

    public DVD(String director, String title, boolean availability){
        super(title, availability);
        this.director = director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){
        return this.director;
    }

    @Override
    public String toString(){
        return "Title: " + getTitle() +
                "\nDirector: " + getDirector() +
                "\nAvailable: " + getAvailability();
    }
}
