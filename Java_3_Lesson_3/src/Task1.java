import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task1 {

    public static void main(String[] args) {
        readBytes();
    }

    public static void readBytes(){
        try (FileInputStream fin = new FileInputStream("Task1/bytes");){
            int i;
            byte [] b = new byte[512];
            while((i = fin.read(b)) != -1){
                System.out.println(new String (b,0,i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
