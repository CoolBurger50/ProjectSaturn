public class Testing {
    public static void main(String[] args) {
        Students s1 = new Students("Mark","Grayson",11);
        Students s2 = new Students("Mark","Grayson",11);
        Students s3 = new Students("Omni","Man",12);
        System.out.println(s1.getStudentID());
        System.out.println(s2.getStudentID());
        System.out.println(s3.getStudentID());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        Enrollments e1 = new Enrollments(s1,1);
        Enrollments e2 = new Enrollments(s3, 5);
        System.out.println(e1);
        System.out.println(e2);
    }
}
