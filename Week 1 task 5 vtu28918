import java.util.Arrays;
import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid value of k");
            return;
        }

        Arrays.sort(arr);

        System.out.println("The " + k + "th smallest element is: " + arr[k - 1]);
    }
}

Output

Enter the number of elements: 6
Enter the array elements:
7 10 4 3 20 15
Enter the value of k: 3
The 3th smallest element is: 7
