import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {
        
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5); nums.add(2); nums.add(8); nums.add(1); nums.add(9);

        // Sort ascending
        Collections.sort(nums);
        System.out.println(nums);  // [1, 2, 5, 8, 9]

        // Sort descending
        Collections.sort(nums, Collections.reverseOrder());
        System.out.println(nums);  // [9, 8, 5, 2, 1]

        // Min and Max
        System.out.println(Collections.min(nums));  // 1
        System.out.println(Collections.max(nums));  // 9

        // Shuffle
        Collections.shuffle(nums);
        System.out.println(nums);  // random order

        // Frequency
        nums.add(5);
        System.out.println(Collections.frequency(nums, 5));  // 2

        // Clear
        nums.clear();
        System.out.println(nums.isEmpty());  // true

    }
}
/*
    ┌────────────────┬──────────┬────────────┬────────────┬────────────┐
    │ Collection     │  Order   │ Duplicates │ Null       │ Thread Safe│
    ├────────────────┼──────────┼────────────┼────────────┼────────────┤
    │ ArrayList      │ Insertion│ ✅ Yes     │ ✅ Yes     │ ❌ No      │
    │ LinkedList     │ Insertion│ ✅ Yes     │ ✅ Yes     │ ❌ No      │
    │ HashSet        │ No order │ ❌ No      │ ✅ One null│ ❌ No      │
    │ LinkedHashSet  │ Insertion│ ❌ No      │ ✅ One null│ ❌ No      │
    │ TreeSet        │ Sorted   │ ❌ No      │ ❌ No      │ ❌ No      │
    │ HashMap        │ No order │ Keys: ❌   │ ✅ Yes     │ ❌ No      │
    │ LinkedHashMap  │ Insertion│ Keys: ❌   │ ✅ Yes     │ ❌ No      │
    │ TreeMap        │ Sorted   │ Keys: ❌   │ ❌ No      │ ❌ No      │
    └────────────────┴──────────┴────────────┴────────────┴────────────┘
*/