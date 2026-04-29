public class Grades {

    private static int globalGradeID = 1;
    private int localGradeID;
    private int assignmentID;
    private int studentID;
    private int grade;

    //TODO replace assignmentID with assignment object when the class is coded
    public Grades(Students student, int assignmentID){
        this.studentID = student.getStudentID();
        this.assignmentID = assignmentID;
        grade = (int) (Math.random() * 26) + 75;
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
