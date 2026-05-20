public class SwitchExpression {
    public static void main(String[] args) {

        int day = 3;

        // Arrow syntax → no fall-through, no break needed
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };

        System.out.println(dayName);  // Wednesday

        // With multiple statements use {}
        int marks = 90;
        String grade = switch (marks / 10) {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default    -> "F";
        };

        System.out.println("Grade: " + grade);  // Grade: B
    }
}