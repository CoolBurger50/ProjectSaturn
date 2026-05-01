import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
        Students.makeStudents(5000);
        for (Students student : Students.getAllStudents()){
            String firstName = student.getFirstName();
            if (firstName.equals("Gary") || firstName.equals("Jesus") || firstName.equals("Wallter")){
                System.out.println(student);
            }
        }
    }
}
