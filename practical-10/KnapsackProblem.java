public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int knapsackCapacity = 5;

        int n = weights.length;
        int[][] V = new int[n + 1][knapsackCapacity + 1];

        // Solve the binary knapsack problem
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= knapsackCapacity; j++) {
                if (i == 0 || j == 0) {
                    V[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    V[i][j] = Math.max(V[i - 1][j], values[i - 1] + V[i - 1][j - weights[i - 1]]);
                } else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }

        // Print the maximum value
        System.out.println("Maximum value: " + V[n][knapsackCapacity]);

        // Find and print the selected items
        int[] selectedWeights = new int[n];
        int[] selectedValues = new int[n];
        traceKnapsack(V, weights, values, knapsackCapacity, selectedWeights, selectedValues);

        System.out.println("Selected items:");
        for (int i = 0; i < n; i++) {
            if (selectedWeights[i] > 0) {
                System.out.println("Item " + (i + 1) + " - Weight: " + selectedWeights[i] + ", Value: " + selectedValues[i]);
            }
        }
    }

    public static void traceKnapsack(int[][] V, int[] weights, int[] values, int M, int[] selectedWeights, int[] selectedValues) {
        int n = weights.length;
        int i = n;
        int j = M;

        while (i > 0 && j > 0) {
            if (V[i][j] != V[i - 1][j]) {
                selectedWeights[i - 1] = weights[i - 1];
                selectedValues[i - 1] = values[i - 1];
                j -= weights[i - 1];
            }
            i--;
        }
    }
}
