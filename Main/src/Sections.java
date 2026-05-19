import java.util.*;

public class Sections {
    private final Teachers teacher;
    private final Rooms room;
    private final Enrollments enrollment;
    private final Courses course;
    private final int sectionID;
    private static int counter=1;
    private static final ArrayList<ArrayList<Sections>> allSections=new ArrayList<>();

    public Sections(Teachers teacher, Rooms room, Enrollments enrollment, Courses course) {
        this.teacher=teacher;
        this.room=room;
        this.enrollment=enrollment;
        this.course=course;
        this.sectionID=counter++;
    }

    public int getSectionID() {
        return sectionID;
    }

    public static ArrayList<ArrayList<Sections>> getAllSections() {
        return allSections;
    }

    public static void generateSections() {
        for(ArrayList<Enrollments> enrollments:Enrollments.getAllEnrollments()) {
            ArrayList<Rooms> allRooms=new ArrayList<>(Rooms.getAllRooms());
            ArrayList<Courses> allCourses=new ArrayList<>(Courses.getAllCourses());
            ArrayList<Teachers> allTeachers=new ArrayList<>(Teachers.getAllTeachers());
            ArrayList<Sections> sections=new ArrayList<>();
            for(Enrollments enrollment:enrollments) {
                if(allTeachers.isEmpty()||allRooms.isEmpty()) {
                    break;
                }
                Courses randomCourse= allCourses.get((int)(Math.random()*allCourses.size()));
                Teachers randomTeacher= allTeachers.remove((int)(Math.random()*allTeachers.size()));
                Rooms randomRoom= allRooms.remove((int)(Math.random()*allRooms.size()));
                Sections currentSection= new Sections(randomTeacher,randomRoom,enrollment,randomCourse);
                sections.add(currentSection);
            }
            allSections.add(sections);
        }
    }

    public static String createInserts() {

        StringBuilder sb=new StringBuilder();

        sb.append("INSERT INTO Sections (teacher_id, room_id, enrollment_id, course_id) VALUES\n");

        int count=0;
        int total=0;

        for(ArrayList<Sections> period:allSections) {
            total+=period.size();
        }
        for(ArrayList<Sections> period:allSections) {
            for(Sections section:period) {
                sb.append("(")
                        .append(section.teacher.getTeacherID()).append(", ")
                        .append(section.room.getRoomID()).append(", ")
                        .append(section.enrollment.getEnrollmentID()).append(", ")
                        .append(section.course.getCourseID()).append(")");
                count++;
                if(count<total) {
                    sb.append(",\n");
                } else {
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }
}