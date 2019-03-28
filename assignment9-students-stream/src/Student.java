public class Student {
    int studentID;
    String name;
    double gps;
    int creditHours;

    public Student(int studentID, String name, double gps, int creditHours) {
        this.studentID = studentID;
        this.name = name;
        this.gps = gps;
        this.creditHours = creditHours;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getGps() {
        return gps;
    }

    public int getCreditHours() {
        return creditHours;
    }
}
