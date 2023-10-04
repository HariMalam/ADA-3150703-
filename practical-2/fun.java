public class fun {
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements at the left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move indices towards each other
            left++;
            right--;
        }
    }
    public static void print(int[] arr){
        for(int a: arr){
            System.out.print(a + " ");
        }
    }
}
