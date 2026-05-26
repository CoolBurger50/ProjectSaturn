import java.util.ArrayList;

public class Teachers {
    private final String firstName;
    private final String lastName;
    private static int teacherCounter = 1;
    private final int teacherID;
    private final int departmentID;
    private static final ArrayList<Teachers> allTeachers = new ArrayList<>();

    public Teachers (String firstName, String lastName, int departmentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        teacherID = teacherCounter++;
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

    public static ArrayList<Teachers> getAllTeachers() {
        return allTeachers;
    }

    public static void generateTeachers() {
        String basePath = HelperMethods.getPathLocation() + "Main/Files/";

        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "world_language"};

        for (String subject : subjects) {
            int departmentID = Departments.getDepartmentID(subject);
            String path = basePath + subject + "/teachers.txt";
            ArrayList<String> teachersList = HelperMethods.getFileData(path);
            for (String current : teachersList) {
                String[] parts = current.split(" ");
                String first_name = parts[0];
                String last_name = parts[1];

                Teachers currentTeacher = new Teachers(first_name, last_name, departmentID);
                allTeachers.add(currentTeacher);
            }
        }
    }

    public static String createInserts() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Teachers (first_name, last_name, department_id) VALUES\n");

        int count = 0;
        int total = allTeachers.size();

        for (Teachers teacher : allTeachers) {
            sb.append("('")
                    .append(teacher.getFirstName()).append("', '")
                    .append(teacher.getLastName()).append("', ")
                    .append(teacher.getDepartmentID()).append(")");

            count++;
            if (count < total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }

        return sb.toString();
    }
}
