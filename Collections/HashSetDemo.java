import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Mango");
        set.add("Banana");
        set.add("Apple");     // duplicate → ignored
        set.add("Mango");     // duplicate → ignored

        System.out.println(set);    // [Banana, Apple, Mango] (no order)
        System.out.println(set.size());          // 3
        System.out.println(set.contains("Mango")); // true

        set.remove("Banana");
        System.out.println(set);    // [Apple, Mango]

        // Iterate
        for (String s : set) {
            System.out.print(s + " ");
        }

        // Remove duplicates from List using Set
        ArrayList<Integer> withDups = new ArrayList<>();
        withDups.add(1); withDups.add(2); withDups.add(1);
        withDups.add(3); withDups.add(2);

        HashSet<Integer> unique = new HashSet<>(withDups);
        System.out.println(unique);  // [1, 2, 3]
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