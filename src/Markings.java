/**
 * A Markings class that will help define if a cell is occupied by H, Cha, or Ord
 */
public class Markings {
    // A String that stores the name of a property
    private String name;

    /**
     * A Markings constructor that will set the name property
     * @param name - a string that will be the name of the marking
     */
    public Markings(String name) {
        setName(name);
    }

    /**
     * The setter for the name property
     * @param name - a String that will be stored in the name property
     * @throws IllegalArgumentException thrown when the name is not H, Cha, or Ord
     */
    public void setName(String name) {
        if (!(name.equals("H") || name.equals("Cha") || name.equals("Ord"))) {
            throw new IllegalArgumentException("Invalid marking name");
        }

        this.name = name;
    }

    /**
     * The getter for the name property
     * @return a reference to name
     */
    public String getName() {
        return this.name;
    }
}