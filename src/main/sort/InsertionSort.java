package main.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,8,1,4,12};
        int[] sortedArr = sort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] sort(int[] elements) {
        // iterate over array
        for (int i = 0; i < elements.length; i++) {
            // get the number at position i
            int elementToSort = elements[i];
            // store the index in a new variable called 'pointer'
            int pointer = i;
            // as long as the elementToSort is smaller than the element at position pointer-1,
            // put the element at pos. pointer-1 one pos. to the right
            while (pointer > 0 && elementToSort < elements[pointer - 1]) {
                // System.out.println("elementToSort: " + elementToSort);
                // System.out.println("elements[pointer]: " + elements[pointer]);
                elements[pointer] = elements[pointer - 1];
                pointer--;
            }
            elements[pointer] = elementToSort;
        }
        return elements;
    }
}
