import java.util.*;
import java.io.*;

public class Teachers {
    private String firstName;
    private String lastName;
    private static int counter = 1;
    private int teacherID;
    private int departmentID;
    private static HashMap<Teachers, Boolean> allTeachers = new HashMap<>();

    // Constructor Methods
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

//    @Override
//    public String toString (){
//        return "" + getTeacherID() + " " + getDepartmentID();
//       // return getFirstName() + " " + getLastName() + ", " + getTeacherID() + " " + getDepartmentID() ;
//    }


    // Hashmap Generation
    public static void generateTeachers (){
        ArrayList<String> bio_teachers = getFileData("Main/Names/bio_teachers.txt");
        for (int i = 0; i < bio_teachers.size(); i++){
            String current = bio_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 1);
            allTeachers.put(t1, true);
        }
        ArrayList<String> chem_teachers = getFileData("Main/Names/chem_teachers.txt");
        for (int i = 0; i < chem_teachers.size(); i++){
            String current = chem_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 2);
            allTeachers.put(t1, true);
        }
        ArrayList<String> cte_teachers = getFileData("Main/Names/cte_teachers.txt");
        for (int i = 0; i < cte_teachers.size(); i++){
            String current = cte_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 3);
            allTeachers.put(t1, true);
        }
        ArrayList<String> english_teachers = getFileData("Main/Names/english_teachers.txt");
        for (int i = 0; i < english_teachers.size(); i++){
            String current = english_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 4);
            allTeachers.put(t1, true);
        }
        ArrayList<String> health_pe_teachers = getFileData("Main/Names/health_pe_teachers.txt");
        for (int i = 0; i < health_pe_teachers.size(); i++){
            String current = health_pe_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 5);
            allTeachers.put(t1, true);
        }
        ArrayList<String> math_teachers = getFileData("Main/Names/math_teachers.txt");
        for (int i = 0; i < math_teachers.size(); i++){
            String current = math_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 6);
            allTeachers.put(t1, true);
        }
        ArrayList<String> physics_teachers = getFileData("Main/Names/physics_teachers.txt");
        for (int i = 0; i < physics_teachers.size(); i++){
            String current = physics_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 7);
            allTeachers.put(t1, true);
        }
        ArrayList<String> social_studies_teachers = getFileData("Main/Names/social_studies_teachers.txt");
        for (int i = 0; i < social_studies_teachers.size(); i++){
            String current = social_studies_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 8);
            allTeachers.put(t1, true);
        }
        ArrayList<String> special_education_teachers = getFileData("Main/Names/special_education_teachers.txt");
        for (int i = 0; i < special_education_teachers.size(); i++){
            String current = special_education_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 9);
            allTeachers.put(t1, true);
        }
        ArrayList<String> visual_art_teachers = getFileData("Main/Names/visual_art_teachers.txt");
        for (int i = 0; i < visual_art_teachers.size(); i++){
            String current = visual_art_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 10);
            allTeachers.put(t1, true);
        }
        ArrayList<String> world_language_teachers = getFileData("Main/Names/world_language_teachers.txt");
        for (int i = 0; i < world_language_teachers.size(); i++){
            String current = world_language_teachers.get(i);
            String first_name = current.split(" ")[0];
            String last_name = current.split(" ")[1];
            Teachers t1 = new Teachers(first_name, last_name, 11);
            allTeachers.put(t1, true);
        }
    }

    // Get Return HashMap
    public static HashMap<Teachers, Boolean> getAllTeachers() {
        return allTeachers;
    }

    // Object-ID translation
    //wip
//    public Teachers fromTeacherID(int teacherID) {
//        for (Map.Entry<Teachers, Boolean> teachers : allTeachers.entrySet()) {
//            return ;
//        }
//    }

    public boolean checkAvailability (int teacherID) {
        return true;
    }

    public void setTaken () {}


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
