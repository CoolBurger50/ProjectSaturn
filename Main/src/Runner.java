public class Runner {
    public static void Main() {
        setup();
        Teachers.generateTeachers();

        // Step 2: Print all teachers
        System.out.println("=== ALL TEACHERS ===");
        for (Teachers t : Teachers.getAllTeachers().keySet()) {
            System.out.println(t);
        }

        // Step 3: Pick a teacher ID to test
        int testID = 1;

        Teachers helper = new Teachers("Temp", "User", 0); // helper instance

        // Step 4: Check availability
        boolean available = helper.checkAvailability(testID);
        System.out.println("\nTeacher ID " + testID + " available: " + available);

        // Step 5: Mark teacher as taken
        helper.setTaken(testID);

        // Step 6: Check availability again
        available = helper.checkAvailability(testID);
        System.out.println("Teacher ID " + testID + " available after taking: " + available);

        // Step 7: Test ID lookup
        Teachers found = helper.fromTeacherID(testID);
        if (found != null) {
            System.out.println("\nFound Teacher:");
            System.out.println(found.getFirstName() + " " + found.getLastName());
        } else {
            System.out.println("Teacher not found.");
        }

        // Step 8: Generate SQL inserts
        System.out.println("\n=== SQL INSERT STATEMENT ===");
        System.out.println(Teachers.createInserts());

    }

    private static void setup() {
        Rooms.generateRooms();
        Teachers.generateTeachers();
        Students.generateStudents(5000);
    }
}