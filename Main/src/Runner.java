public class Runner {
    public static void Main() {
        setup();
        System.out.print("Everything is working!!");
    }

    private static void setup() {
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        Students.generateStudents(1000);
        Enrollments.generateEnrollments(12);
        Sections.generateSections();
        Assignments.generateAssignments();
        Grades.generateGrades();
    }
}