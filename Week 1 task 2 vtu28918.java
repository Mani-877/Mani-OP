import java.util.Scanner;

public class BinarySearchExample {

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int result = binarySearch(arr, key);

        if (result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found.");

        sc.close();
    }
}

Output

Enter the element to search: 23
Element found at index 5
