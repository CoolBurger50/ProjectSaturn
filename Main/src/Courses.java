import java.util.ArrayList;

public class Courses {
    private final String courseName;
    private final String courseType;
    private static int courseCounter = 1;
    private final int courseID;
    private final int departmentID;
    private static final ArrayList<Courses> allCourses = new ArrayList<>();

    public Courses (String courseName, int departmentID, String courseType){
        this.courseName = courseName;
        this.courseType = courseType;
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
            ArrayList<String> courseList = HelperMethods.getFileData(path);
            for (String current : courseList) {
                String courseType = "";
                if (current.indexOf("AP") != -1){
                    courseType = "AP";
                } else if (current.indexOf("Regents") != -1) {
                    courseType = "Regents";
                } else {
                    int r = (int) (Math.random() * 2);
                    if (r == 0){
                        courseType = "Regents";
                    } else {
                        courseType = "Elective";
                    }
                }
                Courses currentCourse = new Courses(current, departmentID, courseType);
                allCourses.add(currentCourse);
            }
        }
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Courses (course_name, course_type, department_id) VALUES\n");
        int count=0;
        int total=allCourses.size();
        for(Courses course:allCourses) {
            sb.append("('")
                    .append(course.courseName).append("', '")
                    .append(course.courseType).append("', ")
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
