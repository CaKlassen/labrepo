package q1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import static java.io.File.separator;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Collects data from a text file and uses it to perform a number of
 * income-related tasks.
 * 
 * @author Christofer Klassen
 * @version 1.0
 * 
 */
public class Survey {

    /** The cutoff of a one-member household. */
    public static final int CUTOFF_ONE = 22229;
    /** The cutoff of a two-member household. */
    public static final int CUTOFF_TWO = 27674;
    /** The cutoff of a three-member household. */
    public static final int CUTOFF_THREE = 34022;
    /** The cutoff of a four-member household. */
    public static final int CUTOFF_FOUR = 41307;
    /** The cutoff of a five-member household. */
    public static final int CUTOFF_FIVE = 46850;
    /** The cutoff of a six-member household. */
    public static final int CUTOFF_SIX = 52838;
    /** The cutoff of a seven-member household. */
    public static final int CUTOFF_SEVEN = 58827;
    /** The largest cutoff index. */
    public static final int CUTOFF_MAX = 6;
    /** The value added to each cutoff beyond the max. */
    public static final int CUTOFF_ADDITIONAL = 5989;
    /** A constant representing the number 3. */
    public static final int MEM_THREE = 3;
    /** A constant representing the number 4. */
    public static final int MEM_FOUR = 4;
    /** A constant representing the number 5. */
    public static final int MEM_FIVE = 5;
    /** A constant representing the number 6. */
    public static final int MEM_SIX = 6;
    /** A constant representing the number 7. */
    public static final int MEM_SEVEN = 7;

    /**
     * Creates an ArrayList of households, which is then used to determine which
     * homes are above the average income, and which homes are below the LICO
     * level.
     * 
     * @param args
     *            Unused
     * @throws IOException
     *             if file does not exist
     */
    public static void main(String[] args) throws IOException {
        int avgIncome = 0;
        int households = 0;
        int homesBelow = 0;
        double percentBelow = 0;
        ArrayList<Household> homes = new ArrayList<Household>();

        // checks to see if the file exists, if not
        // throw an exception, otherwise continue
        // as normal
        try {
            Scanner scan = new Scanner(
                    new File("q1" + separator + "survey.txt"));

            // adds received data to an ArrayList
            while (scan.hasNextLine()) {
                homes.add(new Household(scan.nextInt(), scan.nextInt(), scan
                        .nextInt()));
                households++;
            }

            // prints received data in a 3 column table
            System.out.println("Households included in survey: ");
            System.out.println("ID \tIncome \tMembers");
            for (int i = 0; i < households; i++) {
                System.out.print(homes.get(i));
                System.out.println();

                // calculates the average income
                avgIncome += homes.get(i).getIncome();
            }

            avgIncome /= households;

            // prints the average income
            System.out.println();
            System.out.println("The average income is: " + avgIncome);
            System.out.println("The following households exceed the"
                    + " average income: ");

            // prints out the households that exceed the average income
            System.out.println("ID \tIncome");
            for (int i = 0; i < households; i++) {
                if (homes.get(i).getIncome() > avgIncome) {
                    System.out.print(homes.get(i).getID() + "\t");
                    System.out.print(homes.get(i).getIncome() + "\t");
                    System.out.println();
                }
            }

            // determines the households below the LICO level
            System.out.println();
            System.out.println("Households below the LICO level: ");

            for (int i = 0; i < households; i++) {

                switch (homes.get(i).getMembers()) {
                case 1:
                    if (homes.get(i).getIncome() <= CUTOFF_ONE) {
                        homesBelow++;
                    }
                    break;
                case 2:
                    if (homes.get(i).getIncome() <= CUTOFF_TWO) {
                        homesBelow++;
                    }
                    break;
                case MEM_THREE:
                    if (homes.get(i).getIncome() <= CUTOFF_THREE) {
                        homesBelow++;
                    }
                    break;
                case MEM_FOUR:
                    if (homes.get(i).getIncome() <= CUTOFF_FOUR) {
                        homesBelow++;
                    }
                    break;
                case MEM_FIVE:
                    if (homes.get(i).getIncome() <= CUTOFF_FIVE) {
                        homesBelow++;
                    }
                    break;
                case MEM_SIX:
                    if (homes.get(i).getIncome() <= CUTOFF_SIX) {
                        homesBelow++;
                    }
                    break;
                case MEM_SEVEN:
                    if (homes.get(i).getIncome() <= CUTOFF_SEVEN) {
                        homesBelow++;
                    }
                    break;
                default:
                    // calculate the cutoff cost for the outlying households
                    if (homes.get(i).getIncome() <= CUTOFF_SEVEN
                            + CUTOFF_ADDITIONAL
                            * (homes.get(i).getMembers() - CUTOFF_MAX + 1)) {
                        homesBelow++;
                        break;
                    }
                }
            }

            // calculate the percent of homes below the LICO
            percentBelow = (double) homesBelow / households;
            System.out.println(percentBelow);

            scan.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
    }
}
