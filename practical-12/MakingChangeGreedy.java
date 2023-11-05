import java.util.Arrays;

public class MakingChangeGreedy {
    public static void main(String[] args) {
        int[] denominations = {25, 10, 5, 1}; // Example denominations in descending order
        int amount = 63; // Example amount to make change for

        int[] change = makeChange(denominations, amount);

        System.out.println("Minimum number of coins required: " + Arrays.stream(change).sum());
        System.out.println("Denominations used:");
        for (int i = 0; i < denominations.length; i++) {
            if (change[i] > 0) {
                System.out.println(denominations[i] + " cents: " + change[i]);
            }
        }
    }

    public static int[] makeChange(int[] denominations, int amount) {
        int n = denominations.length;
        int[] change = new int[n];

        for (int i = 0; i < n; i++) {
            while (amount >= denominations[i]) {
                change[i]++;
                amount -= denominations[i];
            }
        }

        return change;
    }
}
