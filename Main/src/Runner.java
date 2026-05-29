import java.io.IOException;
import java.io.PrintWriter;

public class Runner {
    public static void Main() {
        System.out.println("Runner is running !!");
        setup();
        createInsertFile();
        System.out.println("Everything is working !!");
    }

    private static void setup() {
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        Students.generateStudents(5000);
        Enrollments.generateEnrollments(30);
        Sections.generateSections();
        Assignments.generateAssignments();
        Grades.generateGrades();
    }

    private static void createInsertFile() {
        try (PrintWriter out = new PrintWriter(HelperMethods.getPathLocation() + "Main/sql/InsertStatements.sql")) {
            out.println(inserts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String inserts(){
        return Rooms.createInserts() + Departments.createInserts() +
                Teachers.createInserts() + Courses.createInserts() +
                Students.createInserts() + Sections.createInserts() +
                Enrollments.createInserts() + Assignments.createInserts() +
                Grades.createInserts();
    }
}