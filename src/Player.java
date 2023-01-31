import java.util.Scanner;

/**
 * An abstract class that the players Cha and Ord will inherit from
 */
public abstract class Player {
    // A string that will contain the player's name
    protected String name;
    
    /**
     * The Player class constructor that sets the player's name'
     * @param name - a String that will be stored in the name property
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Allows the player to make moves while in play
     * @param b - a Board reference that allows the player to manipulate the state of the board
     * @param s - a Scanner reference that will handle user input
     */
    public abstract void move(Board b, Scanner s);

    /**
     * Checks if the player meets their win conditions
     * @param b - a Board reference used that is used for checking the state of the board
     * @return true if the player meets their win conditions, false otherwise
     */
    public abstract Boolean checkWin(Board b);
}