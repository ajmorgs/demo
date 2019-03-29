
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamMain {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList myList =new ArrayList();
    public static List<String> listOfString = null;
    public static void main(String[] args) {

        String filename = System.getProperty("user.dir") + "\\src\\StudentsGrades.csv";
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {

            listOfString=lineStream.skip(1).collect(Collectors.toList());

            for (String f:listOfString
                 ) {

                makeStudent(f);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        for (Student z:students
             ) {
            System.out.println(z.studentID + ": " +z.name);
        }
    }

    public static void makeStudent(String x) {
       if(x!="") {
           var tmp = x.split(",");
           String id = "";
           String name = "";
           double gpa = 0;
           int credits = 0;
           for (int i = 0; i < tmp.length; i++) {
               id = tmp[0];
               name = tmp[1];
               gpa = Double.parseDouble(tmp[2]);
               credits = Integer.parseInt(tmp[3]);
           }
           Student student = new Student(id, name, gpa, credits);
           System.out.println(student.name);
           students.add(student);
       }
    }
}
