
public class Sorts {

    // Insertion:
    // RL one by one swap
    public static int[] InsertionSort_1(int[] Array) {
        int[] A = Array.clone();

        for (int i = 1; i < A.length; i++) {

            int temp = A[i];
            int j = i - 1;

            for (; (j > -1 && temp < A[j]); --j) {
                A[j + 1] = A[j];
            }

            A[j + 1] = temp;
        }

        return A;
    }

    // LR one by one swap
    public static int[] InsertionSort_2(int[] Array) {
        int[] A = Array.clone();

        for (int i = A.length - 1; i > -1; i--) {

            int temp = A[i];
            int j = i + 1;

            for (; (j < A.length && temp > A[j]); ++j) {
                A[j - 1] = A[j];
            }

            A[j - 1] = temp;
        }

        return A;
    }

    // R find min swap
    public static int[] InsertionSort_3(int[] Array) {
        int[] A = Array.clone();

        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int index = i;

            for (int j = 1 + i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    index = j;
                }
            }

            A[index] = A[i];
            A[i] = min;
        }

        return A;
    }

    // L find max swap
    public static int[] InsertionSort_4(int[] Array) {
        int[] A = Array.clone();

        for (int i = A.length - 1; i > -1; i--) {
            int max = A[i];
            int index = i;

            for (int j = i - 1; j > -1; j--) {
                if (A[j] > max) {
                    max = A[j];
                    index = j;
                }
            }

            A[index] = A[i];
            A[i] = max;
        }

        return A;
    }

    // Bubble:
    // R
    public static int[] BubbleSort_1(int[] Array) {
        int[] A = Array.clone();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        return A;
    }

    // L
    public static int[] BubbleSort_2(int[] Array) {
        int[] A = Array.clone();

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - i - 1; j > 0; j--) {
                if (A[j - 1] > A[j]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }

        return A;
    }

}
