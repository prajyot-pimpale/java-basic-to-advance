import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {

        // Create
        ArrayList<String> fruits = new ArrayList<>();

        // Add
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");      // duplicates allowed
        System.out.println(fruits); // [Apple, Mango, Banana, Orange, Apple]

        // Add at index
        fruits.add(1, "Grapes");
        System.out.println(fruits); // [Apple, Grapes, Mango, Banana, Orange, Apple]

        // Get
        System.out.println(fruits.get(0));  // Apple
        System.out.println(fruits.get(2));  // Mango

        // Update
        fruits.set(1, "Kiwi");
        System.out.println(fruits); // [Apple, Kiwi, Mango, Banana, Orange, Apple]

        // Remove by index
        fruits.remove(0);
        System.out.println(fruits); // [Kiwi, Mango, Banana, Orange, Apple]

        // Remove by value
        fruits.remove("Banana");
        System.out.println(fruits); // [Kiwi, Mango, Orange, Apple]

        // Size
        System.out.println("Size: " + fruits.size());  // 4

        // Contains
        System.out.println(fruits.contains("Mango"));  // true

        // Index of
        System.out.println(fruits.indexOf("Apple"));   // 3

        // Iterate
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
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