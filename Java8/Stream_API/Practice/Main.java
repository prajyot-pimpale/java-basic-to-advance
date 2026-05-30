public class Main{
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice",   20, 95.5),
            new Student("Bob",     22, 42.0),
            new Student("Charlie", 21, 88.0),
            new Student("Diana",   23, 76.5),
            new Student("Eve",     20, 55.0)
        );

        // Filter passing students
        List<Student> passing = students.stream()
            .filter(s -> s.getMarks() >= 60)
            .collect(Collectors.toList());
        System.out.println("Passing: " + passing);
        // [Alice(95.5), Charlie(88.0), Diana(76.5)]

        // Sort by marks descending
        List<Student> ranked = students.stream()
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .collect(Collectors.toList());
        System.out.println("Ranked : " + ranked);

        // Get names of top 3
        List<String> top3 = students.stream()
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .limit(3)
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Top 3  : " + top3);  // [Alice, Charlie, Diana]

        // Average marks
        double avg = students.stream()
            .mapToDouble(Student::getMarks)
            .average().getAsDouble();
        System.out.printf("Average: %.2f%n", avg);  // 71.40

        // Group by age
        Map<Integer, List<Student>> byAge = students.stream()
            .collect(Collectors.groupingBy(Student::getAge));
        byAge.forEach((age, list) ->
            System.out.println("Age " + age + ": " + list));
    }
}