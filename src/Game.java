import java.util.Scanner;

/**
 * The main game loop that runs the game logic
 */
public class Game {
    // A Boolean that is true if the game is over
    private Boolean over;

    // A Scanner that handles user input
    private Scanner scanner;

    // A Board that contains the sets Free, Cha and Ord
    private Board board;

    // A Player array that stores the players Cha and Ord
    private Player[] players;

    // A Boolean that is true when Cha is in play and false if Ord is in play
    private Boolean turn;


    /**
     * Constructs a Game that initializes the properties scanner, board, and players
     */
    public Game() {
        this.scanner = new Scanner(System.in);
        board = new Board();
        players = new Player[2];
        players[0] = new Cha();
        players[1] = new Ord();
    }

    /**
     * Initializes over to false and turn to true then runs the game
     */
    public void start() {
        this.over = false;
        this.turn = true;
        run();
    }

    /**
     * Runs the game loop and will exit only if over is true
     */
    public void run() {
        while (!over) {
            // prints board every loop cycle
            board.printBoard();

            // if turn is true then Cha is in play and if turn is false then Ord is in play
            if (turn) {
                System.out.println("Cha to move.");
                players[0].move(this.board, this.scanner);
                this.turn = !this.turn;

            } else {
                System.out.println("Ord to move.");
                players[1].move(this.board, this.scanner);
                this.turn = !this.turn;
            }

            // if a player meets win condition then announce the winner and set over to true
            if (players[0].checkWin(this.board)) {
                System.out.println("Cha wins!");
                board.printBoard();
                over = true;
            } else if (players[1].checkWin(this.board)) {
                System.out.println("Ord wins!");
                board.printBoard();
                over = true;
            }
        }

        stop();
    }

    /**
     * Outputs to screen the game end prompt and closes all input streams
     */
    public void stop() {
        System.out.println("Thanks for playing!");
        this.scanner.close();
    }
}
