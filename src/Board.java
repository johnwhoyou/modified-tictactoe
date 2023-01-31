/**
 * A Board class that represents the set P and its corresponding subsets of
 * Cha, Ord, and Free
 */
public class Board {
    // A two-dimensional Marking array that represents the set P
    private Markings board[][];

    /**
     * A Board constructor that initializes the Markings array and marks the
     * cells occupied by the set H
     */
    public Board() {
        this.board = new Markings[4][4];
        setCell(1, 1, "H");
        setCell(1, 2, "H");
        setCell(1, 3, "H");
        setCell(2, 1, "H");
        setCell(3, 1, "H");
    }

    /**
     * prints a 4x4 board that represents the set P and the subsets of Free, Cha, and Ord
     */
    public void printBoard() {
        for (int rows = 0; rows < 4; rows++) {
            System.out.println("-----------------");

            for (int cols = 0; cols < 4; cols++) {
                System.out.print("| ");

                // print empty a cell contains nothing, a '#' if it is part of set H,
                // 'C' if it part of set Cha, and 'O' if it is part of set Ord
                if (this.board[rows][cols] == null) {
                    System.out.print(' ');
                } else if (this.board[rows][cols].getName().equals("H")) {
                    System.out.print('#');
                } else if (this.board[rows][cols].getName().equals("Cha")) {
                    System.out.print('C');
                } else if (this.board[rows][cols].getName().equals("Ord")) {
                    System.out.print('O');
                }

                System.out.print(' ');
            }

            System.out.println('|');
        }

        System.out.println("-----------------");
    }

    /**
     * The getter for Markings board[][] property
     * @return the reference to the Markings array
     */
    public Markings[][] getBoard() {
        return this.board;
    }

    /**
     * The getter for a specific cell in the Markings board[][] property
     * @param row - an int representing a row in the Markings array
     * @param column - an int representing a column in the Markings array
     * @return a reference to a Marking
     * @throws ArrayIndexOutOfBoundsException thrown when the row and column are invalid
     */
    public Markings getCell(int row, int column) {
        if (row > 4 || column > 4 || row < 1 || column < 1) {
            throw new ArrayIndexOutOfBoundsException("getCell parameter is out of bounds");
        }

        return this.board[row - 1][column - 1];
    }

    /**
     * The setter for a specific cell in the Markings board[][] property
     * @param row - an int representing a row in the Markings array
     * @param column - an int representing a column in the Markings array
     * @param name - the name of the new marking to be placed in Markings array
     * @throws IllegalArgumentException thrown if the row, column, or name are invalid
     */
    public void setCell(int row, int column, String name) {
        if ((row > 4 || column > 4 || row < 1 || column < 1) ||
            !(name.equals("Cha") || name.equals("Ord") || name.equals("H"))) {
            throw new IllegalArgumentException("Invalid setCell parameter");
        }

        this.board[row - 1][column - 1] = new Markings(name);
    }
}