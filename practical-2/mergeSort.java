import java.util.Random;
import java.util.Scanner;

public class mergeSort {
    public static long executionTimeNano;
    public static int elements;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        sc.close();

        System.out.print("Enter number of elements :");
        elements = sc.nextInt();
        int[] arr = new int[elements];
        for (int i = 0; i < elements; i++) {
            arr[i] = random.nextInt(1000000);
        }

        long startTime = System.nanoTime();
        MergeSort(arr, 0, elements-1);
        long endTime = System.nanoTime();

        executionTimeNano = endTime - startTime;
        System.out.println("Execution time: " + executionTimeNano + " ns");

    }

    public static void MergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = p + (r - p) / 2;
            MergeSort(arr, p, q);
            MergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[q + j + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }
}