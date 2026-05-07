import javax.xml.stream.events.EndDocument;
import java.util.*;

public class Enrollments extends ArrayList<Enrollments> {
    private static ArrayList<Students> studentsEnrolled = new ArrayList<>();; // Students in that Enrollment
    private static final ArrayList<ArrayList<Enrollments>> allEnrollments = new ArrayList<>(); // All enrollments at said period
    private final int enrollmentID;
    private static int counter = 1;

    // Constructor Method
    public Enrollments(ArrayList<Students> students) {
        enrollmentID=counter++;
        studentsEnrolled=students;
    }

    // Getter Methods
    public static ArrayList<Students> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public static ArrayList<ArrayList<Enrollments>> getAllEnrollments() {
        return allEnrollments;
    }

    public static int getEnrollmentSize() {
        return allEnrollments.getFirst().size();
    }

    // Arraylist Generation
    public static void generateEnrollments(int amount) {
        for (int i = 0; i < 10; i++) {
            ArrayList<Enrollments> enrollments = new ArrayList<>();
            ArrayList<Students> allStudents = new ArrayList<>(Students.getAllStudents());
            int totalStudentCount = allStudents.size();
            int numberOfClasses = totalStudentCount / amount;
            for (int n = 0; n < numberOfClasses; n++) {
                ArrayList<Students> temp = new ArrayList<>();
                for (int j = 0; j < amount; j++) {
                    int randomIndex = (int)(Math.random() * allStudents.size());
                    Students chosenStudent = allStudents.remove(randomIndex);
                    temp.add(chosenStudent);
                }
                Enrollments currentEnrollment = new Enrollments(temp);
                enrollments.add(currentEnrollment);
            }
            allEnrollments.add(enrollments);
        }
    }

    // Used for testing
    @Override
    public String toString() {
        return "\n\nEnrollmentID: " + enrollmentID + "\nNumber of Students:" + (getEnrollmentSize());
    }
}
