import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new Random().ints(100, 0, 1000).toArray();
        Arrays.stream(array).forEach(System.out::println);
        mergeSort(array);
        System.out.println("############### Sorted ###############");
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private static void mergeSort(int[] array, int start, int end) {
        int mid = (start + end)/2;

        if(start < end-1) {
            mergeSort(array, start, mid);
            mergeSort(array, mid, end);
            merge(array, mid, start, end);
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
