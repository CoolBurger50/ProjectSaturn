import java.security.AllPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Teachers {
    private final String firstName;
    private final String lastName;
    private static int counter = 1;
    private final int teacherID;
    private final int departmentID;
    private static final HashMap<Teachers, Boolean> allTeachers = new LinkedHashMap<>();

    // Constructor Method
    public Teachers (String firstName, String lastName, int departmentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        teacherID = counter++;
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

    public static HashMap<Teachers, Boolean> getAllTeachers() {
        return allTeachers;
    }

    // Hashmap Generation
    public static void generateTeachers() {
        String basePath = "Main/Files/";

        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "special_education", "visual_art", "world_language"};

        for (int i = 0; i < subjects.length; i++) {
            String path = basePath + subjects[i] + "/teachers.txt";
            ArrayList<String> teachersList = getFileData(path);
            for (String current : teachersList) {
                String[] parts = current.split(" ");
                String first_name = parts[0];
                String last_name = parts[1];

                Teachers currentTeacher = new Teachers(first_name, last_name, i + 1);
                allTeachers.put(currentTeacher, true);
            }
        }
    }

    // Object -> ID translation
    public Teachers fromTeacherID(int teacherID) {
        for (Teachers teacher : allTeachers.keySet()) {
            if (teacher.getTeacherID() == teacherID) {
                return teacher;
            }
        }
        return null;
    }

    // Check HashMap value for said teacherID
    public boolean checkAvailability (int teacherID) {return allTeachers.get(fromTeacherID(teacherID));}

    // Set the value for said Teacher ID to false
    public void setTaken (int teacherID) {allTeachers.replace(fromTeacherID(teacherID), false);}

    // Creates Inserts Statements
    public static String createInserts() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Teachers (first_name, last_name, department_id) VALUES\n");

        int count = 0;
        int total = allTeachers.size();

        for (Teachers teacher : allTeachers.keySet()) {
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

    // Used for testing
    @Override
    public String toString() {
        return "\n\nName: " + firstName + lastName + "\nTeacherID: " + teacherID + "\nDepartID: " + departmentID + "\nAvailability";
    }
}
