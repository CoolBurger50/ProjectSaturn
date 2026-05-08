import java.util.*;

public class Departments {
    private final String departmentName;
    private static int counter = 1;
    private final int departmentID;
    private static final ArrayList<Departments> allDepartments = new ArrayList<>();

    // Constructor Method
    public Departments (String departmentName){
        this.departmentName = departmentName;
        departmentID = counter++;
    }

    // Getter Methods
    public static int getDepartmentID(String departmentName) {
        for (Departments department : allDepartments) {
            if (department.departmentName.equals(departmentName)) {
                return department.departmentID;
            }
        }
        return 0;
    }

    public static ArrayList<Departments> getAllDepartments() {
        return allDepartments;
    }

    // Arraylist Generation
    public static void generateDepartments() {
        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "special_education", "visual_art", "world_language"};
        for (String department : subjects) {
            Departments currentDepartment = new Departments(department);
            allDepartments.add(currentDepartment);
        }
    }

    // Creates Inserts Statements [NOT COMPLETE] [TOBE EDITED]
    public static String createInserts() {
        return null;
    }

    // Used for testing
    @Override
    public String toString(){
        return "\nName: " + departmentName + "\nDeptID: " + departmentID + "\n";
    }
}
