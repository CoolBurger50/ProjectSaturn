public class Runner {
    public static void Main() {
        setup();
        System.out.print("Everything is working!!");
        System.out.println(Courses.getAllCourses());
    }

    private static void setup() {
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        Students.generateStudents(5000);
        Enrollments.generateEnrollments(100);

    }
}