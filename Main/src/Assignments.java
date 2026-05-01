public class Assignments {

    private static int globalAssignmentID = 1;
    private int localAssignmentID;
    private int sectionID;
    private String assignmentName;
    private String assignmentType;

    public Assignments(int sectionID){
        String[] assignmentTypes = {"Regents", "Elective", "AP"};
        this.sectionID = sectionID;
        assignmentType = assignmentTypes[(int) (Math.random() * 3)];

        localAssignmentID = globalAssignmentID;
        globalAssignmentID++;
    }
}
