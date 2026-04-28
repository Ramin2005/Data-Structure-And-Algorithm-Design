/**
 * StrassenMatrixMultiplication - Implements Strassen's matrix multiplication algorithm
 * with automatic padding for rectangular matrices. All identifiers use PascalCase.
 */
public class StrassenMatrixMultiplication {

    /**
     * Help method
     * 
     * Multiplies two matrices using Strassen's algorithm.
     * Handles rectangular matrices by padding with zeros to the next power of two.
     *
     * @param A First matrix (m x n)
     * @param B Second matrix (n x p)
     * @return Result matrix (m x p)
     */
    public static double[][] Multiply(double[][] A, double[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            throw new IllegalArgumentException("Invalid input matrices");
        if (A[0].length != B.length)
            throw new IllegalArgumentException("Columns of A must equal rows of B");

        int M = A.length;       // rows of A
        int N = A[0].length;    // cols of A = rows of B
        int P = B[0].length;    // cols of B

        // Find smallest power of two >= max(M, N, P)
        int Size = Math.max(Math.max(M, N), P);
        int NewSize = 1;
        while (NewSize < Size) NewSize <<= 1;

        // Pad matrices with zeros
        double[][] APad = new double[NewSize][NewSize];
        double[][] BPad = new double[NewSize][NewSize];
        for (int i = 0; i < M; i++)
            System.arraycopy(A[i], 0, APad[i], 0, N);
        for (int i = 0; i < N; i++)
            System.arraycopy(B[i], 0, BPad[i], 0, P);

        // Apply Strassen on padded square matrices
        double[][] CPad = StrassenSquare(APad, BPad);

        // Extract actual result (top-left M x P subMatrix)
        double[][] C = new double[M][P];
        for (int i = 0; i < M; i++)
            System.arraycopy(CPad[i], 0, C[i], 0, P);
        return C;
    }

    /**
     * Main method
     * 
     * Strassen's algorithm for square matrices of size n (n is a power of two).
     */
    private static double[][] StrassenSquare(double[][] X, double[][] Y) {
        int N = X.length;
        // Base case: use standard multiplication for small matrices
        if (N <= 64) {
            return StandardMultiply(X, Y);
        }

        int NewSize = N / 2;
        // Partition X into 4 subMatrices
        double[][] A11 = new double[NewSize][NewSize];
        double[][] A12 = new double[NewSize][NewSize];
        double[][] A21 = new double[NewSize][NewSize];
        double[][] A22 = new double[NewSize][NewSize];
        // Partition Y into 4 subMatrices
        double[][] B11 = new double[NewSize][NewSize];
        double[][] B12 = new double[NewSize][NewSize];
        double[][] B21 = new double[NewSize][NewSize];
        double[][] B22 = new double[NewSize][NewSize];

        SplitMatrix(X, A11, A12, A21, A22);
        SplitMatrix(Y, B11, B12, B21, B22);

        // Compute the 7 Strassen products
        double[][] M1 = StrassenSquare(Add(A11, A22), Add(B11, B22));   // M1 = (A11+A22)*(B11+B22)
        double[][] M2 = StrassenSquare(Add(A21, A22), B11);             // M2 = (A21+A22)*B11
        double[][] M3 = StrassenSquare(A11, Sub(B12, B22));             // M3 = A11*(B12-B22)
        double[][] M4 = StrassenSquare(A22, Sub(B21, B11));             // M4 = A22*(B21-B11)
        double[][] M5 = StrassenSquare(Add(A11, A12), B22);             // M5 = (A11+A12)*B22
        double[][] M6 = StrassenSquare(Sub(A21, A11), Add(B11, B12));   // M6 = (A21-A11)*(B11+B12)
        double[][] M7 = StrassenSquare(Sub(A12, A22), Add(B21, B22));   // M7 = (A12-A22)*(B21+B22)

        // Combine to get the four quadrants of the result
        double[][] C11 = Add(Sub(Add(M1, M4), M5), M7);
        double[][] C12 = Add(M3, M5);
        double[][] C21 = Add(M2, M4);
        double[][] C22 = Add(Sub(Add(M1, M3), M2), M6);

        return MergeMatrices(C11, C12, C21, C22);
    }

    /**
     * Standard O(n^3) matrix multiplication (used for small matrices).
     */
    private static double[][] StandardMultiply(double[][] A, double[][] B) {
        int N = A.length;
        double[][] C = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int k = 0; k < N; k++)
                if (A[i][k] != 0.0)
                    for (int j = 0; j < N; j++)
                        C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    /**
     * Splits a parent matrix into four subMatrices of equal size.
     */
    private static void SplitMatrix(double[][] Parent, double[][] C11, double[][] C12,
                                    double[][] C21, double[][] C22) {
        int NewSize = Parent.length / 2;
        for (int i = 0; i < NewSize; i++) {
            System.arraycopy(Parent[i], 0, C11[i], 0, NewSize);
            System.arraycopy(Parent[i], NewSize, C12[i], 0, NewSize);
            System.arraycopy(Parent[i + NewSize], 0, C21[i], 0, NewSize);
            System.arraycopy(Parent[i + NewSize], NewSize, C22[i], 0, NewSize);
        }
    }

    /**
     * Help method
     * 
     * Merges four subMatrices into a larger matrix.
     */
    private static double[][] MergeMatrices(double[][] C11, double[][] C12,
                                            double[][] C21, double[][] C22) {
        int NewSize = C11.length;
        int Size = NewSize * 2;
        double[][] Result = new double[Size][Size];
        for (int i = 0; i < NewSize; i++) {
            System.arraycopy(C11[i], 0, Result[i], 0, NewSize);
            System.arraycopy(C12[i], 0, Result[i], NewSize, NewSize);
            System.arraycopy(C21[i], 0, Result[i + NewSize], 0, NewSize);
            System.arraycopy(C22[i], 0, Result[i + NewSize], NewSize, NewSize);
        }
        return Result;
    }

    /**
     * Help method
     * 
     * Adds two square matrices element-wise.
     */
    private static double[][] Add(double[][] A, double[][] B) {
        int N = A.length;
        double[][] C = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    /**
     * Help method
     * 
     * Subtracts matrix B from matrix A element-wise.
     */
    private static double[][] Sub(double[][] A, double[][] B) {
        int N = A.length;
        double[][] C = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    // ==================== Example usage ====================
    public static void main(String[] args) {
        // Example 1: Rectangular matrices (2x3 and 3x2)
        double[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        double[][] C = Multiply(A, B);
        System.out.println("Result of 2x3 * 3x2:");
        PrintMatrix(C);
        // Expected: [[58, 64], [139, 154]]

        // Example 2: Square matrix 4x4
        double[][] D = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        double[][] E = Multiply(D, D);
        System.out.println("\nSquare 4x4 * 4x4:");
        PrintMatrix(E);
    }

    private static void PrintMatrix(double[][] M) {
        for (double[] Row : M) {
            System.out.println(java.util.Arrays.toString(Row));
        }
    }
}