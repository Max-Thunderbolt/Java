import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class underAgeException extends Exception {
    public underAgeException(String messageString) {
        super(messageString);
    }
}

public class Student {
    static Scanner sc = new Scanner(System.in);

    // Object array
    private String name, email, course;
    private int id, age;

    static ArrayList<Student> studentList = new ArrayList<Student>();

    // Default constructor
    public Student() {
    }

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int CheckAge(String input) {
        int age = 0;
        try {
            while (age < 16) {
                if (Character.isLetter(input.charAt(0))) {
                    throw new InputMismatchException(
                            "You have entered an incorrect student age!!!\nPlease re-enter the student age >> ");
                }
                if (Character.isDigit(input.charAt(0))) {
                    if (Integer.parseInt(input) < 16) {
                        throw new underAgeException(
                                "You have entered an incorrect student age!!!\nPlease re-enter the student age >> ");
                    }
                }
                age = Integer.parseInt(input);
            }
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
            CheckAge(sc.next());
            // System.out.println("");

        } catch (underAgeException e) {
            System.out.print(e.getMessage());
            CheckAge(sc.next());
            // System.out.println("");

        } catch (Exception e) {
            System.out.print(e.getMessage());
            CheckAge(sc.next());
            // System.out.println("");
        }
        return age;
    }

    public static Student SaveStudent() {
        Student students = new Student();

        // capture ID
        System.out.print("Enter the student ID: ");
        students.setID(sc.nextInt());
        System.out.println("");

        // capture name
        System.out.print("Enter the student name: ");
        students.setName(sc.next());
        System.out.println("");

        // capture age
        System.out.print("Enter the student age: ");
        students.setAge(CheckAge(sc.next()));

        // capture email
        System.out.print("Enter the student email: ");
        students.setEmail(sc.next());
        System.out.println("");

        // capture course
        System.out.print("Enter the student course: ");
        students.setCourse(sc.next());
        System.out.println("");

        Student student = new Student(students.getID(), students.getName(), students.getAge(), students.getEmail(),
                students.getCourse());
        studentList.add(student);
        System.out.println("Student details successfully saved");

        return student;
    }

    public Student saveStudent(Student student) {
        // The purpose of this method is to test if the save student method will work if
        // instead a student object is passed in.

        int numCorrectFields = 0; // if this is == 5 then all fields are correct, and thus student can be added to
        // the array.
        if (student.getID() > 0) {
            numCorrectFields++;
        }
        if (!student.getName().isBlank()) {
            numCorrectFields++;
        }
        if (student.getAge() > 15) {
            numCorrectFields++;
        } else {
            System.out.println("You have entered an incorrect student age!!!\nPlease re-enter the student age >> ");
            /*
             * This is where the user would be prompted to re-enter the student age.
             * However, since this is a test, the user will not be prompted to re-enter the
             * student age.
             */
        }
        if (!student.getEmail().isBlank()) {
            numCorrectFields++;
        }
        if (!student.getCourse().isBlank()) {
            numCorrectFields++;
        }
        if (numCorrectFields == 5) {
            studentList.add(student);
            return student;
        } else {
            return null;
        }
    }

    public static void SearchStudent(int ID) {
        if (studentList.isEmpty()) {
            System.out.println("There are no students in the system.");
        } else {
            for (Student students : studentList) {
                if (students.getID() == ID) {
                    System.out.println("STUDENT " + (studentList.indexOf(students) + 1)
                            + "\n-------------------------------------------"
                            + "\nSTUDENT ID: " + students.getID()
                            + "\nSTUDENT NAME: " + students.getName()
                            + "\nSTUDENT AGE: " + students.getAge()
                            + "\nSTUDENT EMAIL: " + students.getEmail()
                            + "\nSTUDENT COURSE: " + students.getCourse()
                            + "\n-------------------------------------------");
                } else {
                    System.out.println("Student with ID " + ID + " was not found!");
                }
            }
        }
    }

    public Student searchStudent(int ID) {
        if (!studentList.isEmpty()) {
            for (Student students : studentList) {
                if (students.getID() == ID) {
                    return students;
                } else {
                    System.out.println("Student with ID " + ID + " was not found!");
                }
            }
        }
        return null;
    }

    public static Student DeleteStudent(int ID) {
        if (!studentList.isEmpty()) {
            for (Student students : studentList) {
                if (students.getID() == ID) {
                    System.out.println("Are you sure you want to delete student " + ID + " from the system? (y/n)");
                    if (sc.next().equals("y")) {
                        studentList.remove(students);
                        System.out.println(
                                "Student with student ID " + students.getID() + " has been deleted from the system.");
                        return students;
                    } else {
                        System.out.println("Student with student ID " + ID + " has not been deleted from the system.");
                    }
                }
            }
        }
        return null;
    }

    public static Student deleteStudent(int ID) {
        /*
         * This method will not prompt the user to confirm whether they wish to proceed
         * with deletion/
         * Other than this modification this method functions the exact same as the
         * previous method.
         * The reason for this is to make unit testing easier.
         */
        if (!studentList.isEmpty()) {
            for (Student students : studentList) {
                if (students.getID() == ID) {
                    studentList.remove(students);
                    System.out.println(
                            "Student with student ID " + students.getID() + " has been deleted from the system.");
                    return students;
                }
            }
        }
        return null;
    }

    public static void StudentReport() {
        if (studentList.isEmpty()) {
            System.out.println("There are no students in the system.");
        }
        for (Student students : studentList) {
            System.out.println(
                    "STUDENT " + (studentList.indexOf(students) + 1) + "\n-------------------------------------------"
                            + "\nSTUDENT ID: " + students.getID()
                            + "\nSTUDENT NAME: " + students.getName()
                            + "\nSTUDENT AGE: " + students.getAge()
                            + "\nSTUDENT EMAIL: " + students.getEmail()
                            + "\nSTUDENT COURSE: " + students.getCourse()
                            + "\n-------------------------------------------");
        }
    }

    public static void ExitStudentApplication() {
        System.exit(0);
    }
}