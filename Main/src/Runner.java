public class Runner {
    public static void Main() {
        setup();
        System.out.print("Everything is working!!");
        System.out.println(Assignments.getAllAssignments());
    }

    private static void setup() {
        Rooms.generateRooms();
        Teachers.generateTeachers();
        Students.generateStudents(5000);
        Assignments.generateAssignments(15, 2);
    }
}