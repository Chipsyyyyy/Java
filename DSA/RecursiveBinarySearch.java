package DSA;


public class RecursiveBinarySearch {
    
    public static int binarySearch(int[] input, int target, int start, int end) {
        if (start >= end) {
            return -1; //If the input was an empty list, exit the loop
        } else {
            int mid = start + (end - start) / 2;

            if (target < input[mid]) {
                return binarySearch(input, target, start, mid-1); //If the target is less than the midpoint call the binarySearch method however changing the end paramater to be the midpoint - 1
            } else if (target > input[mid]) {
                return binarySearch(input, target, mid+1, end); //If the target is greater than the midpoint call the binarySearch method however change the start parameter to be the midpoint + 1
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args){
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = binarySearch(numbers, 10, 0, 10);
        System.out.println("Target found at index " + result);
    }
}

