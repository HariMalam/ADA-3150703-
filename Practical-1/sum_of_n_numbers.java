import java.util.Scanner;

public class sum_of_n_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long starttime, endtime, executionTime, sum;
        System.out.print("Enter number :");
        int num = sc.nextInt();
        sc.close();

        starttime = System.nanoTime();
        sum = sum_using_loop(num);
        endtime = System.nanoTime();
        executionTime = endtime - starttime;
        System.out.println("sum of 1 to " + num + " = " + sum);
        System.out.println("\nExecution Time (Loop)= " + executionTime + " ns");

        starttime = System.nanoTime();
        sum = sum_using_equation(num);
        endtime = System.nanoTime();
        executionTime = endtime - starttime;
        System.out.println("Execution Time (Equation)= " + executionTime + " ns");

        starttime = System.nanoTime();
        sum = sum_using_recursion(num);
        endtime = System.nanoTime();
        executionTime = endtime - starttime;
        System.out.println("Execution Time (Recursion)= " + executionTime + " ns");

    }

    public static int sum_using_loop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int sum_using_equation(int n) {
        return n * (n + 1) / 2;
    }

    public static int sum_using_recursion(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sum_using_recursion(n - 1);
        }
    }
}
