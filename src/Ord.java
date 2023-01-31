import java.util.Scanner;

/**
 * @see Player
 */
public class Ord extends Player {
    public Ord() {
        super("Ord");
    }

    public void move(Board b, Scanner s) {
        int row = -1, col = -1, count = 0;
        Boolean valid = false;
        // an array containing the set H
        final int[][] H = { {1, 1}, {1, 2}, {1, 3}, {2, 1}, {3, 1} };

        // Check if Ord has 4 markings in play
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b.getBoard()[i][j] != null) {
                    if (b.getBoard()[i][j].getName().equals("Ord")) count++;
                }
            }
        }

        // Prompt Ord to remove a marking if there are 4 markings in play
        if (count >= 4) {
            System.out.println("Ord can only place 4 markings. Remove one marking.");
            while (!valid) {
            System.out.println("Input row number:");
            while (row < 1 || row > 4) {
                while (!s.hasNextInt()) {
                    s.next();
                }

                row = s.nextInt();
            }

            System.out.println("Input column number:");
            while (col < 1 || col > 4) {
                while (!s.hasNextInt()) {
                    s.next();
                }

                col = s.nextInt();
            }

            if (b.getCell(row, col) != null && b.getCell(row, col).getName().equals("Ord")) {
                valid = true;
            } else {
                System.out.println("Invalid inputs. Try again.");
                row = -1;
                col = -1;
            }
        }

        b.getBoard()[row - 1][col - 1] = null;

        // If Ord removes a marking that occupied a cell belonging to H, 
        // then reset the marking of the cell back to H
        for (int i = 0; i < H.length; i++) {
            if (b.getCell(H[i][0], H[i][1]) == null) {
                b.setCell(H[i][0], H[i][1], "H");
            }
        }

        b.printBoard();
        row = -1;
        col = -1;
        valid = false;
    }

        // Allow Ord to select a cell that is not occupied by itself or Cha
        while (!valid) {
        System.out.println("Input row number:");
        while (row < 1 || row > 4) {
            while (!s.hasNextInt()) {
                s.next();
            }

            row = s.nextInt();
        }

        System.out.println("Input column number:");
        while (col < 1 || col > 4) {
            while (!s.hasNextInt()) {
                s.next();
            }

            col = s.nextInt();
        }

        if (b.getCell(row, col) == null) {
            valid = true;
        } else if (b.getCell(row, col).getName().equals("H")) {
            valid = true;
        } else {
            System.out.println("Invalid inputs. Try again.");
            row = -1;
            col = -1;
        }
    }

    b.setCell(row, col, this.name);
}

    public Boolean checkWin(Board b) {
        // if there are still free spaces left, game continues
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b.getBoard()[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}