import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First String :");
        String s1 = sc.nextLine();

        System.out.print("Enter Second String :");
        String s2 = sc.nextLine();

        sc.close();

        char[] arr1 = new char[s1.length()];
        char[] arr2 = new char[s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            arr1[i] = s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            arr2[i] = s2.charAt(i);
        }

        int x = s1.length() + 1;
        int y = s2.length() + 1;

        int[][] arr = new int[x][y];
        int[][] dir = new int[x][y];

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                // 1 - diagonal
                if (arr1[i - 1] == arr2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    dir[i][j] = 1;
                }
                // 2 - up 
                else if (arr[i - 1][j] >= arr[i][j - 1]) {
                    arr[i][j] = arr[i - 1][j];
                    dir[i][j] = 2;
                }
                // 3 - left 
                else {
                    arr[i][j] = arr[i][j - 1];
                    dir[i][j] = 3;
                }
            }
        }

        System.out.println("\nvalue array:");
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\ndirection array:");
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(dir[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nLCS : ");
        printLCS(dir, arr1, x - 1, y - 1);

    }

    public static void printLCS(int[][] b, char[] arr1, int i, int j) {

        if (i == 0 || j == 0) {
            return;
        }

        // 1 - diagonal
        if (b[i][j] == 1) {
            printLCS(b, arr1, i - 1, j - 1);
            char ch = Character.toUpperCase(arr1[i - 1]);
            System.out.print(ch + " ");           
        } 
        // 2 - up
         else if (b[i][j] == 2) {
            printLCS(b, arr1, i - 1, j);
        }
        // 3 - left 
        else {
            printLCS(b, arr1, i, j - 1);
        }
    }
}
