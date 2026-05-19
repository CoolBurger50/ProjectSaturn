import java.util.*;
import java.io.*;

public class Teachers {
    private final String firstName;
    private final String lastName;
    private static int teacherCounter = 1;
    private final int teacherID;
    private final int departmentID;
    private static final ArrayList<Teachers> allTeachers = new ArrayList<>();

    // Constructor Method
    public Teachers (String firstName, String lastName, int departmentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        teacherID = teacherCounter++;
    }

    // Getter Methods
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

    // Arraylist Generation
    public static void generateTeachers() {
        String basePath = "Main/Files/";

        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "world_language"};

        for (String subject : subjects) {
            int departmentID = Departments.getDepartmentID(subject);
            String path = basePath + subject + "/teachers.txt";
            ArrayList<String> teachersList = getFileData(path);
            for (String current : teachersList) {
                String[] parts = current.split(" ");
                String first_name = parts[0];
                String last_name = parts[1];

                Teachers currentTeacher = new Teachers(first_name, last_name, departmentID);
                allTeachers.add(currentTeacher);
            }
        }
    }

    // Creates Inserts Statements
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

    // Simple getFileData Method
    private static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
