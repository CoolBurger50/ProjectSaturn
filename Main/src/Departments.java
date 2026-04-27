public class Departments {
    private String departmentName;
    private static int counter = 1;
    private int departmentID;
    public Departments (String departmentName){
        this.departmentName = departmentName;
        departmentID = counter++;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    @Override
    public String toString (){
        return "INSERT INTO Departments (department_name) VALUES " + getDepartmentName() + ";";
    }
}
