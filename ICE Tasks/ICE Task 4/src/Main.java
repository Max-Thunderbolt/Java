import java.util.ArrayList;

public class Main {
    public static void testCheckOut() throws ItemAlreadyCheckedOutException {
        System.out.println("Testing checkout method\n--------------------------------------------------");

        DVD dvd1 = new DVD("Hans Zimmer", "Superman Sound Track", true);
        DVD dvd2 = new DVD("Mozart", "5th Symphony" , true);
        Book book1 = new Book("Craig Higgins", "The Dream House", true);
        Book book2 = new Book("J.R Tolkien", "Lord of the rings", true);

        ArrayList<LibraryItem> library = new ArrayList<LibraryItem>();
        library.add(dvd1);
        library.add(dvd2);
        library.add(book1);
        library.add(book2);
        LibraryItem test = new LibraryItem();

        try{
            test.checkOutItem("The Dream House", library);
        } catch (ItemAlreadyCheckedOutException e){}
        System.out.println("\nTrying to checkout same book again");
        try{
            test.checkOutItem("The Dream House", library);
        } catch(ItemAlreadyCheckedOutException e){
            System.out.println(e.getMessage());
        }
    }

    public static void testReturnItem(){
        System.out.println("\n\nTesting return method\n--------------------------------------------------");

        DVD dvd1 = new DVD("Hans Zimmer", "Superman Sound Track", true);
        DVD dvd2 = new DVD("Mozart", "5th Symphony" , true);
        Book book1 = new Book("Craig Higgins", "The Dream House", true);
        Book book2 = new Book("J.R Tolkien", "Lord of the rings", true);

        ArrayList<LibraryItem> library = new ArrayList<LibraryItem>();
        library.add(dvd1);
        library.add(dvd2);
        library.add(book1);
        library.add(book2);
        LibraryItem test = new LibraryItem();

        try{
            test.checkOutItem("Superman Sound Track", library);
            test.returnItem("Superman Sound Track", library);
            System.out.println("\nTrying to return the same item a 2nd time");
            test.returnItem("Superman Sound Track", library);
        } catch (ItemAlreadyCheckedOutException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws ItemAlreadyCheckedOutException {
        testCheckOut();
        testReturnItem();
    }
}