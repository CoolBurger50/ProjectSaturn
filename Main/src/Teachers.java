public class Teachers {
    private String firstName;
    private String lastName;
    private static int counter = 1;
    private int teacherID;
    private int departmentID;
    public Teachers (String firstName, String lastName, int departmentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        teacherID = counter++;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    @Override
    public String toString (){
        return "INSERT INTO Teachers (first_name, last_name, department_id) VALUES ('" + firstName + "', '" + lastName + "', " + departmentID + ");";
    }
}
