public class Runner {
    public static void Main() {
        setup();
        System.out.println("Everything is working!!");
//        Enrollments.getStudent();
        createInsertsAll();
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

    private static void createInsertsAll() {
        System.out.println(Rooms.createInserts());
        System.out.println(Departments.createInserts());
        System.out.println(Teachers.createInserts());
        System.out.println(Courses.createInserts());
        System.out.println(Students.createInserts());
        System.out.println(Enrollments.createInserts());
        System.out.println(Sections.createInserts());
        System.out.println(Assignments.createInserts());
        System.out.println(Grades.createInserts());
    }
}