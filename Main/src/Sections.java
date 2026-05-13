import java.util.*;

public class Sections {
    private final Teachers teacher;
    private final Rooms room;
    private final Enrollments enrollment;
    private final Courses course;
    private final int sectionID;
    private static int counter = 1;
    private static final ArrayList<ArrayList<Sections>> allSections = new ArrayList<>();

    // Constructor Method
    public Sections(Teachers teacher, Rooms room, Enrollments enrollment, Courses course){
        this.teacher = teacher;
        this.room = room;
        this.enrollment = enrollment;
        this.course = course;
        sectionID=counter++;
    }

    // Getter Methods
    public int getSectionID() {
        return sectionID;
    }

    public static ArrayList<ArrayList<Sections>> getAllSections() {
        return allSections;
    }

    // Arraylist Generation
    public static void generateSections() {
        int numOfCourses = Courses.getAllCourses().size();
        int numOfEnrollments = Enrollments.getAllEnrollments().size();
        int numOfSectionsPerCourse = numOfCourses/numOfEnrollments;
        int leftoverSections = numOfCourses%numOfEnrollments;

        // for each period in enrollments
        for (ArrayList<Enrollments> enrollments: Enrollments.getAllEnrollments()) {
            ArrayList<Rooms> allRooms = Rooms.getAllRooms();
            ArrayList<Courses> allCourses = Courses.getAllCourses();
            ArrayList<Teachers> allTeachers = Teachers.getAllTeachers();
            ArrayList<Sections> sections = new ArrayList<>();
            // for each enrollment
            for (Enrollments enrollment : enrollments) {
                    // get random section info
                    Courses randomCourse = allCourses.get((int)(Math.random() * allCourses.size()));
                    Teachers randomTeacher = allTeachers.remove((int)(Math.random() * allTeachers.size()));
                    Rooms randomRoom = allRooms.remove((int)(Math.random() * allRooms.size()));
                    Sections currentSection = new Sections(randomTeacher, randomRoom, enrollment , randomCourse);
                    sections.add(currentSection);

            }
            allSections.add(sections);

        }
    }

    // Used for testing
    @Override
    public String toString() {
        return "\n\nSectionID: " + sectionID + "\nTeacherID: " + teacher + "\nRoom: " + room + "\nEnrollment: " + enrollment;
    }
}