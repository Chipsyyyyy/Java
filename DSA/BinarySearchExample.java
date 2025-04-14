package DSA;

public class BinarySearchExample {
    public static Integer binarySearch(int[] input, int target) {
        int first = 0;
        int last = input.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;

            if (input[mid] == target) {
                return mid; //If the midpoint == the target the exit the loop and return the index of where the target is
            } else if (input[mid] < target) {
                first = mid + 1; // If the midpoint is less than the target, reassign first (The first index of the list) to the midpoint + 1 and continue through the while loop
            } else {
                last = mid - 1; //If the midpoint is greater than the target, reassign last (The last index of the list) to the midpoint - 1 and continue through the while loop
            }
        }

        return null;
    }
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = binarySearch(numbers, 5);
        System.out.println(result);
    }
}
