package q3;

import java.util.Random;

/**
 * Tests the functionality of the Student and Address classes.
 *
 * @author Christofer Klasssen
 * @version 1.0
 */
public class TestStudent {
    /**
     * Uses all of the new Student methods to ensure that they
     * work properly.
     *
     * @param args is unused
     */
    public static void main(String[] args) {
    
        Random gen = new Random();
        
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
        Student student2 = new Student();
        
        //prints out the two students
        System.out.println("Student 1:");
        System.out.println("====================");
        System.out.println(student1);
        System.out.println();
        
        System.out.println("Student 2:");
        System.out.println("====================");
        System.out.println(student2);
        
        //sets up student 2
        student2.setFirstName("Jonathan");
        student2.setLastName("Magicpants");
        student2.setHomeAddress(address3);
        student2.setSchoolAddress(address2);
        student2.setTestScore(1, gen.nextInt(Student.MAX_SCORE + 1));
        student2.setTestScore(2, gen.nextInt(Student.MAX_SCORE + 1));
        student2.setTestScore(Student.MAX_TESTS, 
                gen.nextInt(Student.MAX_SCORE + 1));
        
        System.out.println("Student 2's second test score: " 
                + student2.getTestScore(2));
        
        //prints out the two averages of the students
        System.out.println("Student 1's average: " + student1.average());
        System.out.println("Student 2's average: " + student2.average());
        
    }

};
