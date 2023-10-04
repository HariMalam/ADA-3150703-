import java.util.ArrayList;
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {

        ArrayList<Long> fibseries = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        sc.close();

        long startTime = System.nanoTime();
        fibseries = fibLoop(n);
        long endTime = System.nanoTime();

        System.out.println();
        long executionTime = endTime - startTime;
        System.out.println("Execution Time (Loop)= " + executionTime + " ns");

        startTime = System.nanoTime();
        fibrec(n);
        endTime = System.nanoTime();

        executionTime = endTime - startTime;
        System.out.println("Execution Time (Recursion)= " + executionTime + " ns");

        System.out.println();
        print(fibseries);
    }

    public static void print(ArrayList<Long> array) {
        for (long a : array) {
            System.out.print(a + " ");
        }
    }

    public static ArrayList<Long> fibLoop(int n) {
        ArrayList<Long> fibseries = new ArrayList<>();
        long f0 = 1;
        long f1 = 1;
        long i = 2;

        if (n == 1 || n == 2) {
            fibseries.add(1l);
        }

        fibseries.add(1l);
        fibseries.add(1l);
        while (i < n) {
            long f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
            i++;
            fibseries.add(f2);
        }
        return fibseries;
    }

    public static int fibrec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int sum = fibrec(n - 1) + fibrec(n - 2);
            return sum;
        }
    }
}
