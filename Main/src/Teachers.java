import java.util.*;
import java.io.*;

public class Teachers {
    private final String firstName;
    private final String lastName;
    private static int counter = 1;
    private final int teacherID;
    private final int departmentID;
    private static final HashMap<Teachers, Boolean> allTeachers = new HashMap<>();

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
        String basePath = "Main/Names/";

        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "special_education", "visual_art", "world_language"};

        for (int i = 0; i < subjects.length; i++) {
            String path = basePath + subjects[i] + "_teachers.txt";
            ArrayList<String> teachersList = getFileData(path);

            for (String current : teachersList) {
                String[] parts = current.split(" ");
                String first_name = parts[0];
                String last_name = parts[1];

                Teachers t = new Teachers(first_name, last_name, i + 1);
                allTeachers.put(t, true);
            }
        }
    }

    // Object-ID translation
    public Teachers fromTeacherID(int teacherID) {
        for (Teachers teachers : allTeachers.keySet()) {
            if (teachers.getTeacherID() == teacherID) {
                return teachers;
            }
        }
        return null;
    }

    // Check HashMap value for said teacherID
    public boolean checkAvailability (int teacherID) {return allTeachers.get(fromTeacherID(teacherID));}

    // Set the value for said Teacher ID to false
    public void setTaken (int teacherID) {allTeachers.replace(fromTeacherID(teacherID), false);}

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
