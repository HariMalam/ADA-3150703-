import java.util.Random;
import java.util.Scanner;

public class linear_search {
    public static int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
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
            arr[i]=r.nextInt(size*5);
        }

        for (int a: arr){
            System.out.print(a +" ");
        }
        System.out.println();

        System.out.print("Which Element you want to find :");
        int num = sc.nextInt();

        sc.close();

        long startTime = System.nanoTime();
        int index = linearSearch(arr, num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        if (index == -1) {
            System.out.println("Element not found in given list !");
        } else {
            System.out.println("Element found at index " + index);
        }
        System.out.println("\nExecution time = " + executionTime);
    }
}
