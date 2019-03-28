
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StudentStreamMain {
    public static void main(String[] args) {

        String filename = System.getProperty("user.dir") + "\\src\\StudentsGrades.csv";
                try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {

                    lineStream.forEach(System.out :: println);

                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }



    }
}
