import java.util.*;

public class Sections {
    private Teachers teacher;
    private Rooms room;
    private Enrollments enrollment;
    private Courses course;
    private final int sectionID;
    private static int counter = 1;
    private static final ArrayList<Rooms> allRooms = new ArrayList<>();

    // Constructor Method
    public Sections(Teachers teacher, Rooms room, Enrollments enrollment, Courses course){
        sectionID=counter++;
    }

    // Getter Methods
    public int getSectionID() {
        return sectionID;
    }

    // Arraylist Generation
    public static void generateSections() {
        int numOfCourses = Courses.getAllCourses().size();
        int numOfEnrollments = Enrollments.getAllEnrollments().size();
        int numOfSectionsPerCourse = numOfCourses/numOfEnrollments;
        int leftoverSections = numOfCourses%numOfEnrollments;

        // for each period in enrollments
        for (ArrayList<Enrollments> enrollments: Enrollments.getAllEnrollments()) {
            // for each class in enrollments
            for (Enrollments enrollment : enrollments) {

            }
        }
    }

}