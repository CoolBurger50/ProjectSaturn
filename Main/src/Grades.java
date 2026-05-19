import java.util.*;

public class Grades {
    private final int assignmentID;
    private final int studentID;
    private final int grade;
    private final int gradeID;
    private static int counter=1;
    private static final ArrayList<Grades> allGrades=new ArrayList<>();

    public Grades(int studentID,int assignmentID) {
        this.studentID=studentID;
        this.assignmentID=assignmentID;
        this.gradeID=counter++;
        this.grade=(int)(Math.random()*26)+75;
    }

    public int getGradeID() {
        return gradeID;
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

    public static ArrayList<Grades> getAllGrades() {
        return allGrades;
    }

    public static void generateGrades() {
        ArrayList<Students> allStudents=Students.getAllStudents();
        ArrayList<Assignments> allAssignments=Assignments.getAllAssignments();
        for(Students student:allStudents) {
            int studentID=student.getStudentID();
            for(Assignments assignment:allAssignments) {
                Grades currentGrade= new Grades(studentID,assignment.getAssignmentID());
                allGrades.add(currentGrade);
            }
        }
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Grades (assignment_id, student_id, grade) VALUES\n");
        int count=0;
        int total=allGrades.size();

        for(Grades grade:allGrades) {
            sb.append("(")
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