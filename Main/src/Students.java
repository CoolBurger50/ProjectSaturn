import java.util.ArrayList;

public class Students {
    private final String firstName;
    private final String lastName;
    private static int studentCounter = 1;
    private final int studentID;
    private static final ArrayList<Students> allStudents = new ArrayList<>();

    public Students(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        studentID = studentCounter++;
    }

    public int getStudentID() {
        return studentID;
    }

    public static ArrayList<Students> getAllStudents(){
        return allStudents;
    }

    public static void generateStudents(int amount) {
        String basePath = HelperMethods.getPathLocation() + "Main/Files/student";

        String firstNamePath = basePath + "/student_first_names.txt";
        String lastNamePath = basePath + "/student_last_names.txt";

        ArrayList<String> allFirstNames = HelperMethods.getFileData(firstNamePath);
        ArrayList<String> allLastNames = HelperMethods.getFileData(lastNamePath);

        for (int i = 0; i <= amount; i++) {
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
}
