package main.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,8,1,4,2};
        int[] sortedArr = selectionSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] selectionSort(int[] array) {

        int n = array.length;
        int i, j, smallest;

        // looping through array and stopping at array.length - 1 as the last number must already be sorted
        // as we checked everything before it and determined it to be smaller than the last number
        for(j = 0; j < n-1; j++) {
            smallest = j;
            // loop through the "rest" (from j on forward)
            for (i = j + 1; i < n; i++) {
                // check if current number at array[i] is smaller than what we compare it to (smallest)
                if(array[i] < array[smallest]) {
                    // if so, make store it in "smallest"
                    smallest = i;
                }
            }
            // here we should have found the smallest number
            // swap it!
            swap(array, j, smallest);
        }
        return array;
    }

    private static void swap(int[] aArray, int aIdx1, int aIdx2) {
        int temp = aArray[aIdx1];
        aArray[aIdx1] = aArray[aIdx2];
        aArray[aIdx2] = temp;
    }

}
