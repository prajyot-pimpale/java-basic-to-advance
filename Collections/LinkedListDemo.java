import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        // Add
        list.add("B");
        list.addFirst("A");   // add at beginning
        list.addLast("C");    // add at end
        System.out.println(list);  // [A, B, C]

        // Get
        System.out.println(list.getFirst());  // A
        System.out.println(list.getLast());   // C
        System.out.println(list.get(1));      // B

        // Remove
        list.removeFirst();
        list.removeLast();
        System.out.println(list);  // [B]

        // Use as Queue (FIFO)
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println(queue.poll());  // First  (removes)
        System.out.println(queue.peek());  // Second (just looks)

        // Use as Stack (LIFO)
        LinkedList<String> stack = new LinkedList<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        System.out.println(stack.pop());   // Three  (removes top)
        System.out.println(stack.peek());  // Two    (just looks)
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