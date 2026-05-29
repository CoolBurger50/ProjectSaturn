import java.util.ArrayList;

public class Courses {
    private final String courseName;
    private static int courseCounter = 1;
    private final int courseID;
    private final int departmentID;
    private static final ArrayList<Courses> allCourses = new ArrayList<>();

    public Courses (String courseName, int departmentID){
        this.courseName = courseName;
        this.departmentID = departmentID;
        courseID = courseCounter++;
    }

    public int getCourseID() {
        return courseID;
    }

    public static ArrayList<Courses> getAllCourses() {
        return allCourses;
    }

    public static void generateCourses() {
        String basePath = HelperMethods.getPathLocation() + "Main/Files/";

        String[] subjects = {"bio", "chem", "cte", "english", "health_pe", "math", "physics", "social_studies", "world_language"};

        for (String subject : subjects) {
            int departmentID = Departments.getDepartmentID(subject);
            String path = basePath + subject + "/courses.txt";
            ArrayList<String> teachersList = HelperMethods.getFileData(path);
            for (String current : teachersList) {
                Courses currentCourse = new Courses(current, departmentID);
                allCourses.add(currentCourse);
            }
        }
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Courses (course_name, department_id) VALUES\n");
        int count=0;
        int total=allCourses.size();
        for(Courses course:allCourses) {
            sb.append("('")
                    .append(course.courseName).append("', ")
                    .append(course.departmentID).append(")");
            count++;

            if(count<total) {
                sb.append(",\n");
            } else {
                sb.append(";\n");
            }
        }
        return sb.toString();
    }
}
