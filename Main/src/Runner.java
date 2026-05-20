import java.io.*;

public class Runner {
    public static void Main() {
        setup();
        System.out.println("Everything is working!!");
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
        try (PrintWriter out = new PrintWriter("Main/Files/InsertStatements")) {
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