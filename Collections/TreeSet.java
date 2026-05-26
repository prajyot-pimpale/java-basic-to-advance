import java.util.TreeSet;

public class TreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5); ts.add(1); ts.add(8); ts.add(3); ts.add(1);
        System.out.println(ts);          // [1, 3, 5, 8] ← sorted

        System.out.println(ts.first());  // 1
        System.out.println(ts.last());   // 8
        System.out.println(ts.headSet(5)); // [1, 3]    → less than 5
        System.out.println(ts.tailSet(5)); // [5, 8]    → 5 and above
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