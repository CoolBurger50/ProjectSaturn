public class Runner {
    public static void Main() {
        setup();
        System.out.print("Everything is working!!");
    }

    private static void setup() {
        Rooms.generateRooms();
        Teachers.generateTeachers();
        Students.generateStudents(5000);
    }
}