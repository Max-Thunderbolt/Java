import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTest {

    Student test = new Student();
    Student student1 = new Student(1, "Max", 21, "email", "BCAD"); // <-- valid student
    Student student2 = new Student(2, "John", 15, "email", "CS"); // <-- invalid student

    @Test
    public void TestSaveStudent() {
        Student result1 = test.saveStudent(student1);
        Student result2 = test.saveStudent(student2);
        Scanner sc = new Scanner("15");
        student2.setAge(sc.nextInt());
        Student expected1 = student1;
        Student expected2 = null;
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }

    @Test
    public void TestSearchStudent() {
        test.saveStudent(student1);
        Student result1 = test.searchStudent(1);
        Student expected1 = student1;
        Assert.assertEquals(expected1, result1);
    }

    @Test
    public void TestSearchStudent_StudentNotFound() {
        test.saveStudent(student1);
        Student result1 = test.searchStudent(2);
        Student expected1 = null;
        Assert.assertEquals(expected1, result1);
    }

    @Test
    public void TestDeleteStudent() {
        test.saveStudent(student1);
        Student result = Student.deleteStudent(1);
        Student expected = student1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        Student result = Student.DeleteStudent(0);
        Student expected = null;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestStudentAge_StudentAgeValid() throws underAgeException {
        String age = "16";
        int result = Student.CheckAge(age);
        int expected = 16;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid(){
        String age = "15";
        try{
            Student.CheckAge(age);
        } catch (Exception e){
            Assert.fail("Exception: " + e.getMessage());
        }

    }

    @Test(expected = InputMismatchException.class)
    public void TestStudent_StudentAgeInvalidCharacter() {
        String age = "a";
        try{
            Student.CheckAge(age);
        } catch (Exception e){
            Assert.fail("Exception: " + e.getMessage());
        }
    }
}

// Generated with love by TestMe :) Please report issues and submit feature
// requests at: https://weirddev.com/forum#!/testme