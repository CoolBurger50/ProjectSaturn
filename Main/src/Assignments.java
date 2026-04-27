public class Assignments {

    private static int globalGradeID = 1;
    private int localGradeID;
    private int assignmentID;
    private int studentID;
    private int grade;

    //TODO replace assignmentID with assignment object when the class is coded
    public Assignments(Students student, int assignmentID, int grade){
        this.studentID = student.getStudentID();
        this.assignmentID = assignmentID;
        this.grade = grade;
        localGradeID = globalGradeID;
        globalGradeID++;
    }

    public int getGradeID() {
        return localGradeID;
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

    @Override
    public String toString(){
        return "INSERT INTO Grades (assignment_id, student_id, grade) VALUES (" + assignmentID + ", " + studentID + ", " + grade + ")";
    }
}
