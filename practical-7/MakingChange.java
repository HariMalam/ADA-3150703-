public class MakingChange {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 8}; // Example denominations
        int amount = 11; // Example amount to make change for

        int[][] C = makeChange(denominations, amount);

        System.out.println("Minimum number of coins required: " + C[denominations.length][amount]);
        System.out.println("Denominations used:");

        int i = denominations.length;
        int j = amount;

        while (i > 0 && j > 0) {
            if (j >= denominations[i - 1] && C[i][j] == 1 + C[i][j - denominations[i - 1]]) {
                System.out.println(denominations[i - 1]);
                j -= denominations[i - 1];
            } else {
                i--;
            }
        }
    }

    public static int[][] makeChange(int[] denominations, int amount) {
        int n = denominations.length;
        int[][] C = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            C[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 1 && j < denominations[i - 1]) {
                    C[i][j] = Integer.MAX_VALUE;
                } else if (i == 1) {
                    C[i][j] = 1 + C[i][j - denominations[i - 1]];
                } else if (j < denominations[i - 1]) {
                    C[i][j] = C[i - 1][j];
                } else {
                    C[i][j] = Math.min(C[i - 1][j], 1 + C[i][j - denominations[i - 1]]);
                }
            }
        }

        System.out.println("Matrix C:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
        return C;
    }
}
