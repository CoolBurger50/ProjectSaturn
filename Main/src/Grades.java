import java.util.ArrayList;

public class Grades {
    private final int assignmentID;
    private final int studentID;
    private final int grade;
    private final int gradeID;
    private static int gradeCounter = 1;
    private static final ArrayList<Grades> allGrades=new ArrayList<>();

    public Grades(int studentID,int assignmentID) {
        this.studentID=studentID;
        this.assignmentID=assignmentID;
        this.grade=(int)(Math.random()*26)+75;
        this.gradeID=gradeCounter++;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getGrade() {
        return grade;
    }

    public int getGradeID() {
        return gradeID;
    }

    public static ArrayList<Grades> getAllGrades() {
        return allGrades;
    }

    public static void generateGrades() {
        for (ArrayList<Sections> sectionsOutsideLoop : Sections.getAllSections()){
            for (Sections sectionInsideLoop : sectionsOutsideLoop){
                int courseNumber = sectionInsideLoop.getCourse().getCourseID();

                ArrayList<Students> studentList = sectionInsideLoop.getEnrollment().getStudentsEnrolled();
                for (Students student : studentList){
                    int studentNumber = student.getStudentID();

                    ArrayList<Assignments> assignments = new ArrayList<>();
                    for (Assignments assignment : Assignments.getAllAssignments()) {
                        if (assignments.size() == 15 || assignment.getCourseID() != courseNumber) {
                            continue;
                        }
                        assignments.add(assignment);
                        Grades grade = new Grades(studentNumber, assignment.getAssignmentID());
                        allGrades.add(grade);
                    }

                }
            }
        }
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Grades (grade_id, assignment_id, student_id, grade) VALUES\n");
        int count=0;
        int total=allGrades.size();

        for(Grades grade:allGrades) {
            sb.append("(")
                    .append(grade.getGradeID()).append(", ")
                    .append(grade.getAssignmentID()).append(", ")
                    .append(grade.getStudentID()).append(", ")
                    .append(grade.getGrade()).append(")");
            count++;
            if(count<total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }

        return sb.toString();
    }

}