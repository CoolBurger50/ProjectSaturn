/// REWORK SOON

import java.util.ArrayList;

public class Assignments {

    private static int globalAssignmentID = 1;
    private int localAssignmentID;
    private int courseID;
    private String assignmentName;
    private String assignmentType;
    private static ArrayList<Assignments> allAssignments = new ArrayList<Assignments>();

    public Assignments(int courseID){
        this.courseID = courseID;
        localAssignmentID = globalAssignmentID;
        assignmentName = "assignment " + localAssignmentID;
        if (localAssignmentID % 5 == 0){
            assignmentType = "Major";
        } else {
            assignmentType = "Minor";
        }
        globalAssignmentID++;
    }

    public int getAssignmentID() {
        return localAssignmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public static ArrayList<Assignments> getAllAssignments() {
        return allAssignments;
    }

    public static void generateAssignments(int amount, int courseID){
        for (int i = 0; i < amount; i++){
            Assignments assignment = new Assignments(courseID);
            allAssignments.add(assignment);
        }
    }

    @Override
    public String toString(){
        return assignmentName + " " + assignmentType;
    }
}
