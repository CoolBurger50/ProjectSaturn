

public class Sections {

    private static int globalSectionID = 1;
    private int localSectionID;
    private int courseID;
    private int roomID;
    private int teacherID;
    private int periodNumber;

    public Sections(int courseID, int roomID, int teacherID, int periodNumber){
        this.courseID = courseID;
        this.roomID = roomID;
        this.teacherID = teacherID;
        this.periodNumber = periodNumber;
        this.localSectionID = globalSectionID;
        globalSectionID++;
    }

    public int getSectionID() {
        return localSectionID;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public int getPeriodNumber() {
        return periodNumber;
    }
}