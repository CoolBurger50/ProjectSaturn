import java.util.ArrayList;

public class Sections {
    private Teachers teacher;
    private Rooms room;
    private final Enrollments enrollment;
    private final Courses course;
    private final int sectionID;
    private static int sectionCounter =1;
    private static final ArrayList<ArrayList<Sections>> allSections=new ArrayList<>();

    public Sections(Enrollments enrollment, Courses course) {
        teacher = null;
        room = null;
        this.enrollment=enrollment;
        this.course=course;
        this.sectionID= sectionCounter++;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher=teacher;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Enrollments getEnrollment() {
        return enrollment;
    }

    public int getSectionID() {
        return sectionID;
    }

    public static ArrayList<ArrayList<Sections>> getAllSections() {
        return allSections;
    }

    public Courses getCourse() {
        return course;
    }

    public static void generateSections() {
        for(ArrayList<Enrollments> enrollments:Enrollments.getAllEnrollments()) {
            ArrayList<Courses> allCourses=new ArrayList<>(Courses.getAllCourses());
            ArrayList<Sections> sections=new ArrayList<>();
            for(Enrollments enrollment:enrollments) {
                Courses randomCourse= allCourses.get((int)(Math.random()*allCourses.size()));
                Sections currentSection= new Sections(enrollment,randomCourse);
                sections.add(currentSection);
            }
            allSections.add(sections);
        }
        for (ArrayList<Sections> sections : allSections) {
            ArrayList<Teachers> allTeachers=new ArrayList<>(Teachers.getAllTeachers());
            ArrayList<Rooms> allRooms=new ArrayList<>(Rooms.getAllRooms());
            for (Sections section : sections) {
                if (!allTeachers.isEmpty()) {
                    Teachers randomTeacher= allTeachers.remove((int)(Math.random()*allTeachers.size()));
                    section.setTeacher(randomTeacher);
                }
                if (!allRooms.isEmpty()) {
                    Rooms randomRoom= allRooms.remove((int)(Math.random()*allRooms.size()));
                    section.setRoom(randomRoom);
                }
            }
        }
    }

    public static String createInserts() {

        StringBuilder sb=new StringBuilder();

        sb.append("INSERT INTO Sections (course_id, room_id, teacher_id, period_number) VALUES\n");

        int count=0;
        int total=0;

        for(ArrayList<Sections> period:allSections) {
            total+=period.size();
        }
        for(ArrayList<Sections> period:allSections) {
            for(Sections section:period) {
                sb.append("(")
                        .append(section.course.getCourseID()).append(", ")
                        .append(section.room.getRoomID()).append(", ")
                        .append(section.teacher.getTeacherID()).append(", ")
                        .append(allSections.indexOf(period)+1).append(")");
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