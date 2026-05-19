import java.util.*;

public class Assignments {
    private final int courseID;
    private final String assignmentName;
    private final String assignmentType;
    private static int counter=1;
    private final int assignmentID;
    private static final ArrayList<Assignments> allAssignments=new ArrayList<>();

    public Assignments(int courseID,String assignmentName,String assignmentType) {
        this.courseID=courseID;
        this.assignmentID=counter++;
        this.assignmentName=assignmentName;
        this.assignmentType=assignmentType;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public static ArrayList<Assignments> getAllAssignments() {
        return allAssignments;
    }

    public static void generateAssignments() {
        ArrayList<Courses> allCourses=Courses.getAllCourses();
        for (Courses allCourse : allCourses) {
            int courseID = allCourse.getCourseID();
            int unit = 1;
            int lesson = 1;
            for (int i = 1; i <= 15; i++) {
                String assignmentType;
                String assignmentName;
                if (i % 5 == 0) {
                    assignmentType = "Major";
                    assignmentName = "Unit " + unit + "Test";
                    unit++;
                    lesson = 0;
                } else {
                    assignmentType = "Minor";
                    assignmentName = "Unit " + unit + " Lesson " + lesson;
                    lesson++;
                }
                Assignments currentAssignment = new Assignments(courseID, assignmentName, assignmentType);
                allAssignments.add(currentAssignment);
            }
        }
    }

    public Assignments fromAssignmentID(int assignmentID) {
        for(Assignments assignment:allAssignments) {
            if(assignment.getAssignmentID()==assignmentID) {
                return assignment;
            }
        }
        return null;
    }

    public static String createInserts() {

        StringBuilder sb=new StringBuilder();

        sb.append("INSERT INTO Assignments (course_id, assignment_name, assignment_type) VALUES\n");

        int count=0;
        int total=allAssignments.size();

        for(Assignments assignment:allAssignments) {

            sb.append("(")
                    .append(assignment.getCourseID()).append(", '")
                    .append(assignment.getAssignmentName()).append("', '")
                    .append(assignment.getAssignmentType()).append("')");

            count++;

            if(count<total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return assignmentID+"";
    }
}