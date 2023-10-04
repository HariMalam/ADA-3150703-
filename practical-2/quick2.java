import java.util.Random;
import java.util.Scanner;

public class quick2 {
    public static long executionTimeNano;
    public static int elements;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of elements :");
        elements = sc.nextInt();

        sc.close();

        int[] arr = new int[elements];

        for (int i = 0; i < elements; i++) {
            arr[i] = random.nextInt(1000000);
        }
        
        fun.print(arr);
        System.out.println();
        long startTime = System.nanoTime();
        quick(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
                fun.print(arr);
        System.out.println();

        executionTimeNano = (endTime - startTime);
        System.out.println("Execution time: " + executionTimeNano + " ns");
    }

    public static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low+1;

        for (int j = low+1; j <= high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i-1];
        arr[i-1] = arr[low];
        arr[low] = temp;

        return i-1;
    }
}
