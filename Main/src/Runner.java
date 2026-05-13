public class Runner {
    public static void Main() {
        setup();
        System.out.print("Everything is working!!");
        System.out.println(Sections.getAllSections());
    }

    private static void setup() {
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        Students.generateStudents(1000);
        Enrollments.generateEnrollments();
        Sections.generateSections();
    }
}