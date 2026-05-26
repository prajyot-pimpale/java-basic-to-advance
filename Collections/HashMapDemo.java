import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<String, Integer> marks = new HashMap<>();

        // Put (add/update)
        marks.put("Alice", 95);
        marks.put("Bob",   80);
        marks.put("Charlie", 75);
        marks.put("Alice", 98);   // updates existing key
        System.out.println(marks); // {Bob=80, Alice=98, Charlie=75}

        // Get
        System.out.println(marks.get("Alice"));        // 98
        System.out.println(marks.get("Unknown"));      // null
        System.out.println(marks.getOrDefault("X", 0)); // 0

        // Check
        System.out.println(marks.containsKey("Bob"));    // true
        System.out.println(marks.containsValue(75));     // true

        // Remove
        marks.remove("Charlie");
        System.out.println(marks);

        // Size
        System.out.println(marks.size());  // 2

        // Iterate keys
        for (String key : marks.keySet()) {
            System.out.println(key + " → " + marks.get(key));
        }

        // Iterate key-value pairs
        for (var entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Iterate values only
        for (int val : marks.values()) {
            System.out.println(val);
        }
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