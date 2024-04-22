package main.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortIter {

    public static void main(String[] args) {
        int[] array = new Random().ints(6, 0, 20).toArray();
        Arrays.stream(array).forEach(System.out::println);
        mergeSort(array);
        System.out.println("############### Sorted ###############");
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void mergeSort(int[] array) {
        int start = 0;
        int end = array.length;
        int nElementsToMerge = 1; // will take values: 1, 2, 4, 8, 16, 32, ...
        // check that we are not yet finished
        while(nElementsToMerge < end) {
            // k = start index
            // build two arrays: first [k, k+nElementsToMerge[; second [k + nElementsToMerge, k + 2 * nElementsToMerge[
            for(int k = start; k < end; k += nElementsToMerge * 2) {
                merge(array, Math.min(end, k + nElementsToMerge), k, Math.min(end, k + 2 * nElementsToMerge));
            }
            nElementsToMerge = nElementsToMerge * 2;
        }
    }

    private static void merge(int[] array, int mid, int start, int end) {
        int[] left = Arrays.copyOfRange(array, start, mid);
        int[] right = Arrays.copyOfRange(array, mid, end);

        int leftCursor = 0;
        int rightCursor = 0;

        for(int i = start; i < end; i++) {
            if(leftCursor < left.length && (rightCursor >= right.length || left[leftCursor] <= right[rightCursor])) {
                array[i] = left[leftCursor];
                leftCursor++;
            } else {
                array[i] = right[rightCursor];
                rightCursor++;
            }
        }
    }

}
