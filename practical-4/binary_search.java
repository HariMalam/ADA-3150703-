import java.util.Random;
import java.util.Scanner;

public class binary_search {
    public static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements :");
        int size = sc.nextInt();
        Random r = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(1000);
        }

        int[] arr2 = new int[size];
        arr2 = arr.clone();

        System.out.println("arr1:");
        help.printArray(arr);
        System.out.println("\narr2:");
        help.printArray(arr2);
        System.out.println("\nsorted arr1:");
        help.quick(arr, 0, size - 1);
        help.printArray(arr);
        System.out.println("\n");

        System.out.print("Which Element you want to find :");
        int num = sc.nextInt();
        sc.close();

        long startTime = System.nanoTime();
        int bindex = binarySearch(arr, num);
        long endTime = System.nanoTime();
        long binaryExecutionTime = endTime - startTime;

        startTime = System.nanoTime();
        int lindex = help.linearSearch(arr2, num);
        endTime = System.nanoTime();
        long linearExecutionTime = endTime - startTime;

        if (bindex == -1 && lindex == -1) {
            System.out.println("Element not found in given list !");
        } else {
            System.out.println("Element found at index (Binary-sorted) :" + bindex);
            System.out.println("Element found at index (Linear) :" + lindex);
        }

        System.out.println("\nExecution time (BinarySearch)= " + binaryExecutionTime);
        System.out.println("Execution time (LinearSearch)= " + linearExecutionTime);
    }

}

class help {
    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
