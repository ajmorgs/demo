public class Student {
    String studentID;
    String name;
    double gpa;
    int credits;

    public Student(String studentID, String name, double gpa, int credits) {
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.credits = credits;
    }

    public Student() {
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getCredits() {
        return credits;
    }
}
