public class Students {

    private static int globalStudentID = 1;
    private int localStudentID;
    private String firstName;
    private String lastName;
    private int gradeLevel;

    public Students(String firstName, String lastName, int gradeLevel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        localStudentID = globalStudentID;
        globalStudentID++;
    }

    public int getStudentID() {
        return localStudentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public String toString(){
        return "INSERT INTO Students (first_name, last_name, grade_level) VALUES ('" + firstName + "', '" + lastName + "', " + gradeLevel + ");";
    }
}
