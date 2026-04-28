
import java.util.ArrayList;
import java.util.Set;

public class SudokuSolver {

    /**
     *
     * main recursive solver method
     *
     * @param table Sudoku table.
     * @param size Size of sudoku table.
     * @param i Row index
     * @param j Column index
     * @param resultSet Set of results.
     * @throws Exception If sudoku table is invalid.
     *
     */
    public static void Solver(int[][] table, int size, int i, int j, Set<int[][]> resultSet) throws Exception {

        // check for sudoku table is valid.
        if (size % 3 != 0 || table.length != table[0].length || table.length != size) {

            throw new Exception("invalid sudoku table!!");

        } //
        // check for revers end condition.
        else if (i == size) {

            // get copy of solution table
            int[][] copy = new int[size][size];

            for (int y = 0; y < size; y++) {

                copy[y] = table[y].clone();

            }

            // add solution to result set
            resultSet.add(copy);

        } else {

            // is blank check 
            if (table[i][j] > 0 && table[i][j] < 10) {

                int ii = i + (j + 1 - (j + 1) % size) / size;
                int jj = (j + 1) % size;

                // next step
                Solver(table, size, ii, jj, resultSet);

            } else {

                // get local valid numbers
                ArrayList<Integer> temp = privateAllowed(table, i, j);

                // check each valid number
                for (int number : temp) {

                    // public number validation
                    if (isPublicAllowed(table, size, i, j, number)) {

                        // set number
                        table[i][j] = number;

                        int ii = i + (j + 1 - (j + 1) % size) / size;
                        int jj = (j + 1) % size;

                        // next step
                        Solver(table, size, ii, jj, resultSet);

                        table[i][j] = 0;

                    }

                }

            }

        }

    }

    /**
     *
     * get local valid numbers
     *
     * @param table Sudoku table.
     * @param i Row index
     * @param j Column index
     *
     * @return List of local valid number.
     */
    public static ArrayList<Integer> privateAllowed(int[][] table, int i, int j) {

        ArrayList<Integer> out = new ArrayList<>();

        // add numbers between 1 to 9 to out list
        for (int k = 1; k < 10; k++) {

            out.add(k);

        }

        // calculate start indexes
        int rowIndex = (i - i % 3);
        int columnIndex = (i - i % 3);

        // check each
        for (int y = rowIndex; y < rowIndex + 3; y++) {

            for (int x = columnIndex; x < columnIndex + 3; x++) {

                int temp = table[y][x];

                // if is not blank remove exist number from list.
                if (temp > 0 && temp < 10) {

                    out.remove(out.indexOf(temp));

                }

            }

        }

        return out;
    }

    /**
     *
     * public number validation method
     *
     * @param table Sudoku table.
     * @param size Size of sudoku table.
     * @param i Row index
     * @param j Column index
     * @param number Local valid number for public checking.
     *
     * @return True if number is valid.
     */
    public static boolean isPublicAllowed(int[][] table, int size, int i, int j, int number) {

        for (int x = 0; x < j; x++) {

            if (table[i][x] == number) {

                return false;

            }

        }

        for (int x = j + 1; x < size; x++) {

            if (table[i][x] == number) {

                return false;

            }

        }

        for (int y = 0; y < i; y++) {

            if (table[y][j] == number) {

                return false;

            }

        }

        for (int y = i + 1; y < size; y++) {

            if (table[y][j] == number) {

                return false;

            }

        }

        return true;
    }
}
