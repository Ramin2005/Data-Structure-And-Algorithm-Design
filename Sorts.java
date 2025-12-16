
public class Sorts {

    // Insertion:
    // RL one by one swap
    public static int[] InsertionSort_1(int[] Array) {

        for (int i = 1; i < A.length; i++) {

            int temp = Array[i];
            int j = i - 1;

            for (; (j > -1 && temp < Array[j]); --j) {
                Array[j + 1] = Array[j];
            }

            Array[j + 1] = temp;
        }

        return A;
    }

    // LR one by one swap
    public static int[] InsertionSort_2(int[] Array) {

        for (int i = A.length - 1; i > -1; i--) {

            int temp = Array[i];
            int j = i + 1;

            for (; (j < A.length && temp > Array[j]); ++j) {
                Array[j - 1] = Array[j];
            }

            Array[j - 1] = temp;
        }

        return A;
    }

    // R find min swap
    public static int[] InsertionSort_3(int[] Array) {

        for (int i = 0; i < A.length; i++) {
            int min = Array[i];
            int index = i;

            for (int j = 1 + i; j < A.length; j++) {
                if (Array[j] < min) {
                    min = Array[j];
                    index = j;
                }
            }

            Array[index] = Array[i];
            Array[i] = min;
        }

        return A;
    }

    // L find max swap
    public static int[] InsertionSort_4(int[] Array) {

        for (int i = A.length - 1; i > -1; i--) {
            int max = Array[i];
            int index = i;

            for (int j = i - 1; j > -1; j--) {
                if (Array[j] > max) {
                    max = Array[j];
                    index = j;
                }
            }

            Array[index] = Array[i];
            Array[i] = max;
        }

        return A;
    }

    // Bubble:
    // R
    public static int[] BubbleSort_1(int[] Array) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (Array[j + 1] < Array[j]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        }

        return A;
    }

    // L
    public static int[] BubbleSort_2(int[] Array) {

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - i - 1; j > 0; j--) {
                if (Array[j - 1] > Array[j]) {
                    int temp = Array[j];
                    Array[j] = Array[j - 1];
                    Array[j - 1] = temp;
                }
            }
        }

        return A;
    }

    // Quick:
    public 
}
