import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        double maxValue = fractionalKnapsack(values, weights, capacity);
        System.out.println("Maximum value obtained: " + maxValue);
    }

    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        // Sort the items by value-to-weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble(item -> -((double) item.value / item.weight)));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= remainingCapacity) {
                // Add the entire item to the knapsack
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                // Add a fraction of the item to the knapsack
                double fraction = (double) remainingCapacity / items[i].weight;
                totalValue += fraction * items[i].value;
                break;
            }
        }

        return totalValue;
    }
}
