import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    final int PAGE = 1800;
    public static void main(String[] args) throws IOException {


        RandomAccessFile raf = new RandomAccessFile("Task3/Page1.txt", "r");
        raf.seek();

        System.out.println((char) raf.read());
    }
}
