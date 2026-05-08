import java.util.*;

///  REWORKING SOON
///  ADD COMMENTS

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

    // Arraylist Generation
    public static void generateSections() {
        for (int i = 0; i < Enrollments.getAllEnrollments().size(); i++) {
//            COURSES MUST BE COMPLETED FIRST
        }
    }
}