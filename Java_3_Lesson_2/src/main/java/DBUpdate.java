import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class DBUpdate {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("test.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String line = sc.nextLine();
            String [] lineArray =  line.split(" ");
            System.out.println(Arrays.toString(lineArray));
            System.out.println();
        }

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            create();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        for (int i = 1; i < 4 ; i++) {
//            try {
//                stmt.executeUpdate("INSERT INTO Students (Id, Name, Score) VALUES ()");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void create () throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Students (" +
                " Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                " Name TEXT NOT NULL, " +
                " Score INTEGER NOT NULL )");
    }

    public static void connect () throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:DB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect (){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
