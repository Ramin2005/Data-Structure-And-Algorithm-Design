
public class Sorts {

    public static long[] InsertionSort_1(long[] Array) {
        long[] A = Array.clone();

        for (int i = 1; i < A.length; i++) {

            long temp = A[i];
            int j = i - 1;

            for (; (j > -1 && temp < A[j]); --j) {
                A[j + 1] = A[j];
            }

            A[j + 1] = temp;
        }

        return A;
    }

    public static void main(String[] args) {
        long[] b = {705, 50, 1, 8, 23, 1000, 99999999};

        long[] a = InsertionSort_1(b);

        for (long l : a) {
            System.out.print(l + " ");
        }
    }
}
