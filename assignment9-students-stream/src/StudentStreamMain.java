
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamMain {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static List<String> listOfString = null;

    public static void main(String[] args) {

        String filename = System.getProperty("user.dir") + "\\src\\StudentsGrades.csv";
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {

            listOfString = lineStream.skip(1).collect(Collectors.toList());

            for (String f : listOfString
            ) {

                makeStudent(f);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //1. Count the students with 3.7 GPA and higher.
        long above37 = students.stream()
                .filter(n -> (n.getGpa()) > 3.6)
                .count();
        System.out.println("* Number of students with 3.7 and above: " + above37);

        System.out.println("* Students with 4.0 GPA are:");
        // 2. List the students with 4.0 GPA.
        students.stream()
                .filter(n -> (n.getGpa()) == 4.0)
                .forEach(w -> System.out.println("     - " + w.name));

//3. Out of the 4.0 Students who’s taking more classes?
        students.stream()
                .filter(n -> (n.getGpa()) == 4.0)
                .sorted(Comparator.comparing(Student::getCredits).reversed())
                .limit(1)
                .forEach(w -> System.out.println("* Out of them, (" + w.name + ") was the taking more classes with a number of CR equal to " + w.getCredits()));

        // 4. What’s the Average GPA for this set of data?
        double avg = (double) students.stream()
                .mapToDouble(w -> w.getCredits())
                .average()
                .orElse(0);
        System.out.println("* The average GPA is: " + avg);

        //5. What’s the lowest GPA?
        double lowgpa = students.stream()
                .mapToDouble(w -> w.getGpa())
                .min()
                .orElse(0);
        System.out.println("* The lowest GPA is: " + lowgpa);

        /*6. Use the IntSummaryStatistics Class to show statistics on the number of Credit Hours (CR)
        students are taking.*/
        System.out.println("* Statistics about the CR taken by students:");
        IntSummaryStatistics stats = students.stream()
                .collect(Collectors.summarizingInt(Student::getCredits));
        System.out.println(stats);

      /*  for (Student z:students
             ) {
            System.out.println(z.studentID + ": " +z.name);
        }*/
    }

    public static void makeStudent(String x) {
        if (x != "") {
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
            students.add(student);
        }
    }
}
