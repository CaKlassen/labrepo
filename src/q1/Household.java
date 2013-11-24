package q1;


/**
 * A class representing a household. It contains variables that
 * hold values for the house ID, income and number of members.
 * 
 * @author Christofer Klassen
 * @version 1.0
 */
public class Household {

    /** The ID of the household. */
    private int id;
    /** The income of the household. */
    private int income;
    /** the number of members in the household. */
    private int numMembers;
    
    /** The constructor for household. It accepts information on
     * the id, income and number of memories.
     * 
     * @param identification - the ID of the household.
     * @param money - the income of the household.
     * @param mem - the number of members of the household.
     */
    public Household(int identification, int money, int mem) {
        id = identification;
        if (money >= 0 && mem >= 0) {
            income = money;
            numMembers = mem;
        } else {
            throw new IllegalArgumentException("Invalid household data.");
        }
    }
            
    /**
     * Returns the ID of the household.
     * @return id
     */
    public int getID() {
        return id;
    }
    
    /**
     * Returns the income of the household.
     * @return income
     */
    public int getIncome() {
        return income;
    }
    
    /**
     * Returns the number of members.
     * @return numMembers
     */
    public int getMembers() {
        return numMembers;
    }
    
    /**
     * Overrides the default to string with information
     * on the id, income and number of members of the household.
     * 
     * @return a string with info on the household
     */
    public String toString() {
        
        return id + "\t" + income + "\t" + numMembers;
    }
}
