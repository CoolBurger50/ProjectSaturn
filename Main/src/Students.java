import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    private final String firstName;
    private final String lastName;
    private static int counter = 1;
    private final int studentID;
    private static final ArrayList<Students> allStudents = new ArrayList<>();

    // Constructor Method
    public Students(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        studentID = counter++;
    }

    // Getter Methods
    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static ArrayList<Students> getAllStudents(){
        return allStudents;
    }

    // ArrayList Generation
    public static void generateStudents(int amount) {
        String basePath = "Main/Files/student";

        String firstNamePath = basePath + "/student_first_names.txt";
        String lastNamePath = basePath + "/student_last_names.txt";

        ArrayList<String> allFirstNames = getFileData(firstNamePath);
        ArrayList<String> allLastNames = getFileData(lastNamePath);

        for (int i = 0; i < amount; i++) {
            String firstName = allFirstNames.get((int)(Math.random() * allFirstNames.size()));
            String lastName = allLastNames.get((int)(Math.random() * allLastNames.size()));

            Students currentStudent = new Students(firstName, lastName);
            allStudents.add(currentStudent);
        }
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Students (first_name, last_name) VALUES\n");
        int count=0;
        int total=allStudents.size();
        for(Students student:allStudents) {
            sb.append("('")
                    .append(student.firstName).append("', '")
                    .append(student.lastName).append("')");
            count++;
            if(count<total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    // Simple getFileData Method
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

    // Used for testing
    @Override
    public String toString(){
        return "\nName: " + firstName + " " + lastName + "\nStudentID: " + studentID + "\n";
    }
}
