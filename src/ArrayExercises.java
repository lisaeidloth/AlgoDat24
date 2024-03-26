import java.util.Arrays;

// a small warmup
// for more Array exercises, see: https://codingbat.com/java/Array-1
public class ArrayExercises {
    public static void main(String[] args) {
        // initialize array (inline)
        String[] array = new String[]{"a", "b", "c", "d", "e", "f"};
        String[] array_ = {"a", "b", "c", "d", "e", "f"};

        /* initialize array and fill it (inline) with numbers
         without having to do it one by one */
        int[] nums = initArray(20);
        int[] nums2 = initArray(20, 5);
        int[] nums3 = initArray(21, 5, 3);

        print(nums);
        print(nums2);
        print(nums3);

        // array iteration; print elements to standard out
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // another way to iterate
        for (String s : array) {
            System.out.println(s);
        }
        // yet another way...
        Arrays.stream(array).forEach(elem -> System.out.println(elem));

        // count even numbers in array
        int counter = 0;
        for (int a: nums) {
            if(a % 2 == 0) counter++;
            // the same, but different
            // counter += a % 2 == 0? 1 : 0;
        }
        System.out.println("Count even numbers: " + counter);

        // count primes in array
        counter = 0;
        for (int a: nums) {
            boolean hasDivisor = false;
            for(int i = 2; i <= a/2; i++) {
                hasDivisor = a % i == 0;
                if(hasDivisor) {
                    break;
                }
            }
            if(!hasDivisor && a > 1) {
                counter++;
                System.out.println("Prime: " + a);
            }
        }
    }

    // fill array
    public static int[] initArray(int max) {
        int[] nums = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        return nums;
    }

    public static int[] initArray(int max, int min) {
        int[] nums = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + min;
        }
        return nums;
    }

    public static int[] initArray(int max, int min, int step) {
        int[] nums = new int[(max-min)/step + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * step + min;
        }
        return nums;
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
