package q3;

import java.text.DecimalFormat;

/**
 * Represents a college student.
 * 
 * @author Christofer Klassen
 * @version 1.0
 */
public class Student {

    /** Constant representing the max number of tests. */
    public static final int MAX_TESTS = 3;
    /** Constant representing the max mark on a test. */
    public static final int MAX_SCORE = 100;
    /** Constant for the number 3. */
    public static final int NUM_THREE = 3;
    /** First name of this student. */
    private String firstName;
    /** Last name of this student. */
    private String lastName;
    /** Home address of this student. */
    private Address homeAddress;
    /** School address of this student. Can be shared by other students */
    private Address schoolAddress;
    /** first test score. */
    private double testScore1;
    /** second test score. */
    private double testScore2;
    /** third test score. */
    private double testScore3;
    /** Decimal format for percent structure. */
    private DecimalFormat fmt = new DecimalFormat("0.00");

    /**
     * Constructor: Sets up this student with the specified values.
     * 
     * @param first
     *            The first name of the student
     * @param last
     *            The last name of the student
     * @param home
     *            The home address of the student
     * @param school
     *            The school address of the student
     * @param score1
     *            The first test's mark
     * @param score2
     *            The second test's mark
     * @param score3
     *            The third test's mark
     */
    public Student(String first, String last, Address home, Address school,
            double score1, double score2, double score3) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;

        //checks to make sure that the scores entered are valid
        if (score1 <= MAX_SCORE && score1 >= 0 
                && score2 <= MAX_SCORE && score2 >= 0 
                && score3 <= MAX_SCORE && score3 >= 0) {    
            testScore1 = score1;
            testScore2 = score2;
            testScore3 = score3;
        } else {
            throw new IllegalArgumentException("Invalid score input.");
        }
    }

    /**
     * Constructor: Creates the student object with placeholder variables for
     * the name and test scores.
     */
    public Student() {
        firstName = "UNKNOWN";
        lastName = "UNKNOWN";

        testScore1 = 0;
        testScore2 = 0;
        testScore3 = 0;
    }

    /**
     * Sets the score of a particular test.
     * 
     * @param testNum
     *            The test number.
     * @param score
     *            The mark for that test.
     */
    public void setTestScore(int testNum, double score) {
        switch (testNum) {
        case 1:
            testScore1 = score;
            break;
        case 2:
            testScore2 = score;
            break;
        case NUM_THREE:
            testScore3 = score;
            break;
        default:
            throw new IllegalArgumentException("Inalid score input.");
        }
    }

    /**
     * Sets the first name of the student.
     * @param fname The first name of the student.
     */
    public void setFirstName(String fname) {
        firstName = fname;
    }
    
    /**
     * Sets the last name of the student.
     * @param lname The last name of the student.
     */
    public void setLastName(String lname) {
        lastName = lname;
    }
    
    /**
     * Sets the home address of the student.
     * @param addHome The home address of the student.
     */
    public void setHomeAddress(Address addHome) {
        homeAddress = addHome;
    }

    /**
     * Sets the school address of the student.
     * @param addSchool The school address of the student.
     */
    public void setSchoolAddress(Address addSchool) {
        schoolAddress = addSchool;
    }

    /**
     * Returns the test score of a particular test.
     * 
     * @param testNum
     *            The test in question.
     * @return the value of the mark.
     */
    public String getTestScore(int testNum) {
        double num = 0;
        switch (testNum) {
        case 1:
            num = testScore1;
            break;
        case 2:
            num = testScore2;
            break;
        case NUM_THREE:
            num = testScore3;
            break;
        default:
            throw new IllegalArgumentException("Invalid input.");
        }

        return fmt.format(num);
    }

    /**
     * Computes and returns the average of all 3 tests.
     * 
     * @return the average.
     */
    public String average() {

        double avg = (testScore1 + testScore2 + testScore3) / MAX_TESTS;
        return fmt.format(avg);
    }

    /**
     * Returns a string description of this Student object.
     * 
     * @return formatted name and addresses of student
     */
    public String toString() {
        String result;

        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test One:\n" + fmt.format(testScore1) + "\n";
        result += "Test Two:\n" + fmt.format(testScore2) + "\n";
        result += "Test Three:\n" + fmt.format(testScore3) + "\n";
        result += "Average:\n" + average();

        return result;
    }
}
