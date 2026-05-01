import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {

    private static int globalStudentID = 1;
    private int localStudentID;
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private static ArrayList<Students> allStudents = new ArrayList<Students>();

    public Students(String firstName, String lastName, int gradeLevel, int localStudentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        this.localStudentID = localStudentID;
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

    public static ArrayList<Students> getAllStudents(){
        return allStudents;
    }

    public static void makeStudents(int amount){
        for (int i = 0; i < amount; i++){
            ArrayList<String> allFirstNames = getFileData("Main/Names/student_first_names.txt");
            String firstName = allFirstNames.get((int)(Math.random() * 1000));
            ArrayList<String> allLastNames = getFileData("Main/Names/student_last_names.txt");
            String lastName = allLastNames.get((int)(Math.random() * 1000));
            int gradeLevel = (int) (Math.random() * 4) + 9;
            int localStudentID = globalStudentID;
            globalStudentID++;
            Students tempStudent = new Students(firstName,lastName,gradeLevel,localStudentID);
            allStudents.add(tempStudent);
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
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

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + localStudentID;
    }
}
