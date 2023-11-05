public class ChainMatrixMultiplication {
    public static void main(String[] args) {
        int[] dimensions = {5, 4, 6, 2}; // Example matrix dimensions
        int n = dimensions.length - 1;

        int[][] m = new int[n][n]; // Minimum multiplication counts
        int[][] s = new int[n][n]; // Split indices for optimal parenthesization

        matrixChainOrder(dimensions, m, s);

        System.out.println("Minimum number of multiplications: " + m[0][n - 1]);
        System.out.println("Optimal Parenthesization:");
        printOptimalParenthesization(s, 0, n - 1);
    }

    public static void matrixChainOrder(int[] dimensions, int[][] m, int[][] s) {
        int n = dimensions.length - 1;

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParenthesization(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParenthesization(s, i, s[i][j]);
            printOptimalParenthesization(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}

