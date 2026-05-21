import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 9, 2};

        // ToString
        System.out.println(Arrays.toString(arr)); // [5, 3, 8, 1, 9, 2]

        // Sort
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));   // [1, 2, 3, 5, 8, 9]

        // Binary Search (array must be sorted)
        int idx = Arrays.binarySearch(arr, 8);
        System.out.println("8 at index: " + idx);   // 4

        // Fill
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled)); // [7, 7, 7, 7, 7]

        // Copy
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(copy));  // [5, 3, 8, 1, 9, 2]

        // Copy Of Range
        int[] copyRange = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(copyRange));  // [3, 8, 1]

        // Compare
        System.out.println(Arrays.equals(arr, copy));  // true

        // Deep To String
        int[][] matrix = {
                    {1, 2},
                    {3, 4}
                };

        System.out.println(Arrays.deepToString(matrix)); // [[1, 2], [3, 4]]
    }
}

/*
+--------------------------+------------------------------+
| Method                   | Purpose                      |
+--------------------------+------------------------------+
| Arrays.toString()        | Convert array to string      |
| Arrays.sort()            | Sort array                   |
| Arrays.binarySearch()    | Search element               |
| Arrays.equals()          | Compare arrays               |
| Arrays.fill()            | Fill array                   |
| Arrays.copyOf()          | Copy array                   |
| Arrays.copyOfRange()     | Copy specific range          |
| Arrays.deepToString()    | Print multidimensional array |
+--------------------------+------------------------------+
*/ 