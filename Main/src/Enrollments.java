import java.util.ArrayList;

public class Enrollments {
    private ArrayList<Students> studentsEnrolled;
    private static final ArrayList<ArrayList<Enrollments>> allEnrollments=new ArrayList<>();
    private final int enrollmentID;
    private static int enrollmentCounter =1;

    public Enrollments(ArrayList<Students> students) {
        this.enrollmentID= enrollmentCounter++;
        this.studentsEnrolled=students;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public ArrayList<Students> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public static ArrayList<ArrayList<Enrollments>> getAllEnrollments() {
        return allEnrollments;
    }

    public static String createInserts() {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO Enrollments (section_id, student_id) VALUES\n");
        int count=0;
        int total=0;
        for(ArrayList<Enrollments> period:allEnrollments) {
            for(Students student : period) {
                total+=student.size();
            }
        }

        for (ArrayList<Sections> periods : Sections.getAllSections()) {
            for (Sections section : periods){
                int section_id = section.getSectionID();
                for (Students student : section.getEnrollment().studentsEnrolled) {
                    sb.append("(")
                            .append(section_id)
                            .append(student.getStudentID()).append(")");
                    count++;
                }
            }
        }

        /*
        for(ArrayList<Enrollments> period:allEnrollments) {
            total+=period.size();
        }
        for(ArrayList<Enrollments> period:allEnrollments) {
            for(Enrollments enrollment:period) {
                sb.append("(")
                        .append(enrollment.enrollmentID)
                        .append(")");
                count++;
                if(count<total) {
                    sb.append(",\n");
                } else {
                    sb.append(";");
                }
            }
        }
        */
        return sb.toString();
    }

    public static void generateEnrollments(int amount) {
        for(int i=0;i<10;i++) {
            ArrayList<Enrollments> enrollments=new ArrayList<>();
            ArrayList<Students> allStudents=new ArrayList<>(Students.getAllStudents());
            int totalStudentCount=allStudents.size();
            int numberOfClasses=totalStudentCount/amount;
            for(int n=0;n<numberOfClasses;n++) {
                ArrayList<Students> temp=new ArrayList<>();
                for(int j=0;j<amount;j++) {
                    int randomIndex=(int)(Math.random()*allStudents.size());
                    Students chosenStudent=allStudents.remove(randomIndex);
                    temp.add(chosenStudent);
                }
                Enrollments currentEnrollment=new Enrollments(temp);
                enrollments.add(currentEnrollment);
            }
            allEnrollments.add(enrollments);
        }
    }
}