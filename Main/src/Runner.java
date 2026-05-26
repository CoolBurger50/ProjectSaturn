import java.io.IOException;
import java.io.PrintWriter;

public class Runner {
    public static void Main() {
        setup();
        createInsertFile();
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

    private static void createInsertFile() {
        try (PrintWriter out = new PrintWriter("Main/InsertStatements")) {
            out.println(inserts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String inserts(){
        return Rooms.createInserts() + Departments.createInserts() +
                Teachers.createInserts() + Courses.createInserts() +
                Students.createInserts() + Enrollments.createInserts() +
                Sections.createInserts() + Assignments.createInserts() +
                Grades.createInserts();
    }
}