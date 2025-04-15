package DSA;
import java.util.*;
import java.util.Arrays;

public class Merge_Sort {

    // Main function that sorts arr[l..r] using merge()
    public static void sort(int[] arr) {
        if (arr.length > 1) {
            // Split the array into two halves
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            // Recursively sort both halves
            sort(left);
            sort(right);

            // Merge the sorted halves
            merge(arr, left, right);
        }
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++]; // Assign result[k] to left[i] then increment both i and k
            } else {
                result[k++] = right[j++]; // Assign result[k] to right[j] then increment both j and k
            }
        }

        // Copy remaining elements
        while (i < left.length) result[k++] = left[i++]; // Account for the situation where the right list is shorter than the left
        while (j < right.length) result[k++] = right[j++]; // Account for the situation where the left list is shorter than the right
    }

    public static boolean verifySorted(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        return arr[0] < arr[1] && verifySorted(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        sort(arr);
        int[] unsorted = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(arr));
        System.out.println(verifySorted(arr));
    }
}
