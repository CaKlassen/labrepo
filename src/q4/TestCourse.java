package q4;

import q3.Address;
import q3.Student;
import java.util.Random;

/**
 * A program that tests the methods of the Course class.
 * 
 * @author Christofer Klassen
 * @version 1.0
 */
public class TestCourse {
    /**
     * Creates a dummy course and tests its methods.
     * @param args is unused.
     */
    public static void main(String[] args) {
        Random gen = new Random();
        Course course1 = new Course("Math");
        
        Address address1 = new Address("3773 Lam Drive", "Richmond", 
                "British Columbia", "V7C 5T4");
        Address address2 = new Address("BCIT", "Burnaby", 
                "British Columbia", "V5T 5D1");
        Address address3 = new Address("2520 Lockhart Street", "Richmond", 
                "British Columbia", "V7T 2C9");
        
        Student student1 = new Student("Chris", "Klassen", address1, 
                address2, gen.nextInt(Student.MAX_SCORE + 1), 
                gen.nextInt(Student.MAX_SCORE + 1), 
                gen.nextInt(Student.MAX_SCORE + 1));
        Student student2 = new Student("Jimothy", "Smotherback", address3, 
                address2, gen.nextInt(Student.MAX_SCORE + 1), 
                gen.nextInt(Student.MAX_SCORE + 1), 
                gen.nextInt(Student.MAX_SCORE + 1));
        Student student3 = new Student("Pretend", "Person", address2, 
                address1, gen.nextInt(Student.MAX_SCORE + 1),
                gen.nextInt(Student.MAX_SCORE + 1),
                gen.nextInt(Student.MAX_SCORE + 1));
        
        //adds two students to the course
        course1.addStudent(student1);
        course1.addStudent(student2);
        
        //prints out all the students
        System.out.println("Roll call #1: ");
        System.out.println("==============================");
        System.out.println(course1.roll());
        System.out.println();
        
        //adds more students to the course
        course1.addStudent(student3);
        course1.addStudent(student3);
        course1.addStudent(student3);
        course1.addStudent(student3);
        
        //reprints the student list
        System.out.println("Roll call #2: ");
        System.out.println("==============================");
        System.out.println(course1.roll());
        System.out.println();
        
        //prints the class average
        System.out.println("Class average: ");
        System.out.println("==============================");
        System.out.println(course1.average());
        
        
    }
}
