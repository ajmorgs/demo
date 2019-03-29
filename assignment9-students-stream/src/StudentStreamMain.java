
import java.io.IOException;
import java.lang.reflect.Array;
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

        //do stream processes to get requested data
        //1. Count the students with 3.7 GPA and higher.
        long above37 = students.stream()
                .filter(n -> (n.getGpa()) > 3.6)
                .count();
        System.out.println(above37);

        // 2. List the students with 4.0 GPA.
        students.stream()
                .filter(n -> (n.getGpa()) == 4.0)
                .forEach(w -> System.out.println(w.name));



       /* 1. Count the students with 3.7 GPA and higher.
        2. List the students with 4.0 GPA.
        3. Out of the 4.0 Students who’s taking more classes?
        4. What’s the Average GPA for this set of data?
                5. What’s the lowest GPA?
        6. Use the IntSummaryStatistics Class to show statistics on the number of Credit Hours (CR)
        students are taking.*/

      /*  for (Student z:students
             ) {
            System.out.println(z.studentID + ": " +z.name);
        }*/
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
