import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<InputStream> in = new ArrayList<>();
        in.add(new FileInputStream("Task2/1.txt"));
        in.add(new FileInputStream("Task2/2.txt"));
        in.add(new FileInputStream("Task2/3.txt"));
        in.add(new FileInputStream("Task2/4.txt"));
        in.add(new FileInputStream("Task2/5.txt"));

        SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(in));

        int i;
        while ((i = sin.read()) != -1){
            System.out.print((char) i);
        }
        sin.close();
    }
}
