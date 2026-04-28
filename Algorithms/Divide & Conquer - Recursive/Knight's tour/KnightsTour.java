
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KnightsTour {

    //f(board, size, startPosition, endPosition, 1, resultSet)
    public static void f(int[][] board, int size, int[] position, int[] endPosition, int move, Set<int[][]> resultSet) {

        if (move == size * size) {

            if (position[0] == endPosition[0] && position[1] == endPosition[1]) {

                int[][] copy = new int[size][size];

                for (int i = 0; i < size; i++) {

                    copy[i] = board[i].clone();

                }

                for (int[] row : copy) {
                    for (int element : row) {
                        System.out.printf("%4d ", element);
                    }
                    System.out.println("");
                }

                System.out.println("");
                resultSet.add(copy);
            }

        } else {

            int x = position[0];
            int y = position[1];

            //1
            if ((x - 2 >= 0) && (y - 1 >= 0) && (x - 2 < size) && (y - 1 < size)) {

                if (board[x - 2][y - 1] == 0) {

                    board[x - 2][y - 1] = move + 1;

                    int[] tempPosition = {x - 2, y - 1};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x - 2][y - 1] = 0;

                }

            }

            //2
            if ((x + 2 >= 0) && (y - 1 >= 0) && (x + 2 < size) && (y - 1 < size)) {

                if (board[x + 2][y - 1] == 0) {

                    board[x + 2][y - 1] = move + 1;

                    int[] tempPosition = {x + 2, y - 1};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x + 2][y - 1] = 0;

                }

            }

            //3
            if ((x - 2 >= 0) && (y + 1 >= 0) && (x - 2 < size) && (y + 1 < size)) {

                if (board[x - 2][y + 1] == 0) {

                    board[x - 2][y + 1] = move + 1;

                    int[] tempPosition = {x - 2, y + 1};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x - 2][y + 1] = 0;

                }

            }

            //4
            if ((x + 2 >= 0) && (y + 1 >= 0) && (x + 2 < size) && (y + 1 < size)) {

                if (board[x + 2][y + 1] == 0) {

                    board[x + 2][y + 1] = move + 1;

                    int[] tempPosition = {x + 2, y + 1};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x + 2][y + 1] = 0;

                }

            }

            //5
            if ((x - 1 >= 0) && (y - 2 >= 0) && (x - 1 < size) && (y - 2 < size)) {

                if (board[x - 1][y - 2] == 0) {

                    board[x - 1][y - 2] = move + 1;

                    int[] tempPosition = {x - 1, y - 2};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x - 1][y - 2] = 0;

                }

            }

            //6
            if ((x + 1 >= 0) && (y - 2 >= 0) && (x + 1 < size) && (y - 2 < size)) {

                if (board[x + 1][y - 2] == 0) {

                    board[x + 1][y - 2] = move + 1;

                    int[] tempPosition = {x + 1, y - 2};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x + 1][y - 2] = 0;

                }

            }

            //7
            if ((x - 1 >= 0) && (y + 2 >= 0) && (x - 1 < size) && (y + 2 < size)) {

                if (board[x - 1][y + 2] == 0) {

                    board[x - 1][y + 2] = move + 1;

                    int[] tempPosition = {x - 1, y + 2};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x - 1][y + 2] = 0;

                }

            }

            //8
            if ((x + 1 >= 0) && (y + 2 >= 0) && (x + 1 < size) && (y + 2 < size)) {

                if (board[x + 1][y + 2] == 0) {

                    board[x + 1][y + 2] = move + 1;

                    int[] tempPosition = {x + 1, y + 2};

                    f(board, size, tempPosition, endPosition, (move + 1), resultSet);

                    board[x + 1][y + 2] = 0;

                }

            }

        }

    }

    public static void main(String[] args) {
        int size;
        int x_1;
        int y_1;
        int x_2;
        int y_2;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of board: ");
            size = sc.nextInt();
            System.out.println("");
            System.out.print("Enter start x position: ");
            x_1 = sc.nextInt();
            System.out.print("Enter start y position: ");
            y_1 = sc.nextInt();
            System.out.println("");
            System.out.print("Enter end x position: ");
            x_2 = sc.nextInt();
            System.out.print("Enter end y position: ");
            y_2 = sc.nextInt();
            System.out.println("");
        }

        int[][] board = new int[size][size];

        board[(x_1 - 1)][(y_1 - 1)] = 1;
        int[] startPosition = {x_1 - 1, y_1 - 1};

        int[] endPosition = {x_2 - 1, y_2 - 1};

        Set<int[][]> resultSet = new HashSet<>();

        f(board, size, startPosition, endPosition, 1, resultSet);

        System.out.println("Number of solutions: " + resultSet.size());

    }
}
