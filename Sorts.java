
import java.util.Random;

public class Sorts {

    // Insertion:
    // RL one by one swap
    public static void InsertionSort_1(int[] Array) {

        for (int i = 1; i < Array.length; i++) {

            int temp = Array[i];
            int j = i - 1;

            for (; (j > -1 && temp < Array[j]); --j) {
                Array[j + 1] = Array[j];
            }

            Array[j + 1] = temp;
        }

    }

    // LR one by one swap
    public static void InsertionSort_2(int[] Array) {

        for (int i = Array.length - 1; i > -1; i--) {

            int temp = Array[i];
            int j = i + 1;

            for (; (j < Array.length && temp > Array[j]); ++j) {
                Array[j - 1] = Array[j];
            }

            Array[j - 1] = temp;
        }

    }

    // Selection:
    // R find min swap
    public static void SelectionSort_1(int[] Array) {

        for (int i = 0; i < Array.length; i++) {
            int min = Array[i];
            int index = i;

            for (int j = 1 + i; j < Array.length; j++) {
                if (Array[j] < min) {
                    min = Array[j];
                    index = j;
                }
            }

            Array[index] = Array[i];
            Array[i] = min;
        }

    }

    // L find max swap
    public static void SelectionSort_2(int[] Array) {

        for (int i = Array.length - 1; i > -1; i--) {
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

    }

    // Bubble:
    // R
    public static void BubbleSort_1(int[] Array) {

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length - i - 1; j++) {
                if (Array[j + 1] < Array[j]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        }

    }

    // L
    public static void BubbleSort_2(int[] Array) {

        for (int i = 0; i < Array.length; i++) {
            for (int j = Array.length - i - 1; j > 0; j--) {
                if (Array[j - 1] > Array[j]) {
                    int temp = Array[j];
                    Array[j] = Array[j - 1];
                    Array[j - 1] = temp;
                }
            }
        }

    }

    // Quick:
    public static void QuickSort(int[] Array, int l, int u) {
        if (l < u) {

            int place = place(Array, l, u);
            QuickSort(Array, l, place - 1);
            QuickSort(Array, place + 1, u);
        }
    }

    private static int place(int[] Array, int l, int u) {
        int left = l;
        int right = u;

        while (left < right) {

            while ((Array[left] <= Array[l]) && (left < u)) {
                ++left;
            }

            while ((Array[right] > Array[l]) && (right > l)) {
                --right;
            }

            if (left < right) {
                int temp = Array[right];
                Array[right] = Array[left];
                Array[left] = temp;

            }
        }

        int temp = Array[l];
        Array[l] = Array[right];
        Array[right] = temp;

        return right;
    }

    // Merge"
    public static void MergeSort(int[] Array) {
        if (Array.length <= 1) {
            return;
        }

        int mid = Array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[Array.length - mid];

        System.arraycopy(Array, 0, left, 0, mid);
        System.arraycopy(Array, mid, right, 0, Array.length - mid);

        MergeSort(left);
        MergeSort(right);

        Merge(Array, left, right);
    }

    private static void Merge(int[] Array, int[] left, int[] right) {

        int i, j, k;
        i = j = k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {

                Array[k++] = left[i++];

            } else {

                Array[k++] = right[j++];

            }

        }

        while (i < left.length) {

            Array[k++] = left[i++];

        }

        while (j < right.length) {

            Array[k++] = right[j++];

        }

    }

    public static void main(String[] args) {
        Random r = new Random();

        int[] a = new int[20];

        for (int i = 0; i < 20; i++) {
            a[i] = r.nextInt(0, 100);
        }

        for (int l : a) {
            System.out.print(l + " ");
        }
        System.out.println("");

        MergeSort(a);

        for (int l : a) {
            System.out.print(l + " ");
        }

    }
}
