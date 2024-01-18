import java.util.*;

public class MainScreen extends Student {

    // Scanner to get user input
    public static Scanner sc = new Scanner(System.in);

    public static void Welcome() {
        System.out.println("STUDENT MANAGEMENT APPLICATION" +
                "\n****************************************************" +
                "\nEnter (1) to launch menu or any other key to exit");
        int choice = Integer.parseInt(sc.next());
        if (choice != 1) {
            System.exit(0);
        } else {
            Menu();
        }
    }

    public static void launchMenu() {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int choice = Integer.parseInt(sc.next());
        if (choice != 1) {
            System.exit(0);
        } else {
            Menu();
        }
    }

    public static void Menu() {
        System.out.println("Please select one of the following items: " +
                "\n(1) Capture new student." +
                "\n(2) Search for student." +
                "\n(3) Delete a student." +
                "\n(4) Print student report." +
                "\n(5) Exit application.");
        int choice = Integer.parseInt(sc.next());

        switch (choice) {
            case 1:
                System.out.print("CAPTURE A NEW STUDENT\n**************************************\n");
                SaveStudent();
                launchMenu();
                break;
            case 2:
                System.out.print("Enter the student id to search: ");
                SearchStudent(sc.nextInt());
                launchMenu();
                break;
            case 3:
                System.out.print("Enter the student id to delete:");
                DeleteStudent(sc.nextInt());
                launchMenu();
                break;
            case 4:
                System.out.println("Print student report");
                StudentReport();
                launchMenu();
                break;
            case 5:
                ExitStudentApplication();
                break;
            default:
                System.out.println("Invalid input");
                Menu();
        }
    }
}