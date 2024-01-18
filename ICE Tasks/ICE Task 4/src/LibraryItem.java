import java.util.ArrayList;

class ItemAlreadyCheckedOutException extends Throwable {
    public ItemAlreadyCheckedOutException(String message){
        super(message);
    }
}

class ItemNotCheckedOutException extends Throwable{
   public ItemNotCheckedOutException(String message){
       super(message);
   }
}

public class LibraryItem {

    private String title;
    private boolean availability;

    public LibraryItem(){}

    public LibraryItem(String title, boolean availability){
        this.title = title;
        this.availability = availability;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAvailability(boolean av){
        this.availability = av;
    }

    public boolean getAvailability(){
        return this.availability;
    }

    public void checkOutItem(String title, ArrayList<LibraryItem> library) throws ItemAlreadyCheckedOutException {
        boolean found = false;
        try {
            for (LibraryItem items : library) {
                if (items.getTitle().equals(title)) {
                    if (items.getAvailability()) {
                        found = true;
                        System.out.println("Checking out\n" + items.toString());
                        items.setAvailability(false);
                    } else {
                        throw new ItemAlreadyCheckedOutException("Item has already been checked out.");
                    }
                }
            }
            if(!found){
                System.out.println("Item not found.");
            }
        } catch (ItemAlreadyCheckedOutException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnItem(String title, ArrayList<LibraryItem> library){
        try{
            for (LibraryItem item : library){
                if (item.getTitle().equals(title)){
                    if (item.getAvailability()){
                        throw new ItemNotCheckedOutException("Cannot return an item that has not been checkout.");
                    } else {
                        System.out.println("Returning\n" + item.toString());
                        item.setAvailability(true);
                    }
                }
            }
        } catch (ItemNotCheckedOutException e) {
            System.out.println(e.getMessage());
        }
    }
}
