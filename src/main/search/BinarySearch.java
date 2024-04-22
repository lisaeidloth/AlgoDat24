package main.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {5, 8, 12, 34, 56, 101};
        System.out.println(iterBinarySearch(array, 12));
        System.out.println(recursiveBinarySearch(array, 12, 0, array.length - 1));
    }

    // returns the index of the number to be found
    private static int iterBinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length -1;

        while (low <= high) {
            // calculate the mid of the array
            int mid = (low + high) / 2;
            // store the actual value at the current mid-position
            int midValue = array[mid];
            // in case the target is the midValue, we have found the target
            if(target == midValue) {
                return mid;
            }
            // in case the target is smaller than our current mid, search on the left
            // by resetting the range inside which the search continues
            if(target < midValue) {
                high = mid -1;
            }
            // in case the target is greater than our current mid, search on the right
            else {
                low = mid + 1;
            }
        }
        // return -1 if target could not be found
        return -1;
    }


    private static int recursiveBinarySearch(int[] array, int target, int low, int high) {
        if (high >= low && low <= array.length - 1) {
            int mid = low + (high - low) / 2;
            int midValue = array[mid];

            if (target == midValue){
                return mid;
            }
            if (target < midValue){
                return recursiveBinarySearch(array, target, low, mid - 1);
            }
            else {
                return recursiveBinarySearch(array, target, mid + 1, high);
            }
        }
        return -1;
    }
}
