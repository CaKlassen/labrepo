package q4;

import q3.Student;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A class representing a course that students can take. The class holds up to 5
 * students.
 * 
 * @author Christofer Klassen
 * @version 1.0
 */
public class Course {

    /** A constant representing the maximum number of students in the class. */
    public static final int MAX_STUDENTS = 5;
    /** An array that holds all of the students. */
    private ArrayList<Student> students = new ArrayList<Student>();
    /** The number of students in the class. */
    private int numStudents;
    /** The name of the class. */
    private String name;
    /** The class average. */
    private double avg;
    /** A decimal format representing the percent structure. */
    private DecimalFormat fmt = new DecimalFormat("0.00");

    /**
     * Constructor: Sets the name of the course.
     * 
     * @param courseName
     *            the name of the course.
     */
    public Course(String courseName) {
        name = courseName;
    }

    /**
     * Adds a student to the class if there is space.
     * 
     * @param student1
     *            the student to add
     */
    public void addStudent(Student student1) {

        // checks to see if the course is full, if it is
        // throw an exception.
        if (numStudents < MAX_STUDENTS) {
            students.add(student1);
            numStudents++;
        } else {
            throw new IllegalArgumentException("Course is full.");
        }
    }

    /**
     * Computes and returns the average of all enrolled students.
     * 
     * @return the average.
     */
    public String average() {

        avg = 0;

        if (numStudents > 0) {
            for (int i = 0; i < numStudents; i++) {
                avg += Double.parseDouble(students.get(i).average());
            }
    
            return fmt.format(avg / numStudents);
        } else {
            throw new ArithmeticException("Dividing by zero.");
        }
    }

    /**
     * Prints out all enrolled students.
     * @return A list of all enrolled students.
     */
    public String roll() {
        String response = "";

        for (int i = 0; i < numStudents; i++) {
            response += "Student " + (i + 1) + "\n";
            response += "==================== \n";
            response += students.get(i) + "\n";
            response += "\n";
        }

        return response;
    }
}
