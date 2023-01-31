import java.util.Scanner;

/**
 * @see Player
 */
public class Cha extends Player {
    public Cha() {
        super("Cha");
    }

    public void move(Board b, Scanner s) {
        int row = -1, col = -1;
        Boolean valid = false;

        // allow Cha to select a free cell that is not occupied by itself, H, or Ord
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
            } else {
                System.out.println("Invalid inputs. Try again.");
                row = -1;
                col = -1;
            }
        }

        b.setCell(row, col, this.name);
    }

    public Boolean checkWin(Board b) {
        // the set W containing Cha's winning conditions
        final int[][][] W = {
            {{1, 4}, {2, 4}, {3, 4}},
            {{2, 2}, {3, 3}, {4, 4}},
            {{2, 3}, {3, 2}, {4, 1}},
            {{4, 2}, {4, 3}, {4, 4}}
        };

        // cycle through W and check if Cha has met the win conditions
        for (int i = 0; i < W.length; i++) {
            if (b.getCell(W[i][0][0], W[i][0][1]) != null &&
                b.getCell(W[i][1][0], W[i][1][1]) != null &&
                b.getCell(W[i][2][0], W[i][2][1]) != null) {
                if (b.getCell(W[i][0][0], W[i][0][1]).getName().equals("Cha") &&
                    b.getCell(W[i][1][0], W[i][1][1]).getName().equals("Cha") &&
                    b.getCell(W[i][2][0], W[i][2][1]).getName().equals("Cha"))
                return true;
            }
        }

        return false;
    }
}