public class Enrollments {

    private int studentID;
    private int sectionID;

    //TODO try to put section object instead of an int id when section class is coded
    public Enrollments(Students student, int sectionID){
        this.studentID = student.getStudentID();
        this.sectionID = sectionID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getSectionID() {
        return sectionID;
    }

    @Override
    public String toString(){
        return "INSERT INTO Enrollments (student_id, section_id) VALUES (" + studentID + ", " + sectionID + ")";
    }
}
