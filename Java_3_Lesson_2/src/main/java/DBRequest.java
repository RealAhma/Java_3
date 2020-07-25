import java.sql.*;

public class DBRequest {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            create();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            update();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            updateSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            read();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dropTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void create () throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Students (" +
                " Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                " Name TEXT NOT NULL, " +
                " Score INTEGER NOT NULL )");
    }

    public static void read () throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString("Name"));
        }
    }

    public static void delete() throws SQLException {
       stmt.executeUpdate("DELETE FROM Students WHERE Id = '7'");
    }

    public  static  void update() throws SQLException {
        stmt.executeUpdate(" INSERT INTO Students (Name, Score) VALUES ('Bob', 20) ");
        stmt.executeUpdate(" INSERT INTO Students (Name, Score) VALUES ('Alex', 30) ");
        stmt.executeUpdate(" INSERT INTO Students (Name, Score) VALUES ('Roy', 40) ");
    }

    public static void updateSet () throws SQLException {
        stmt.executeUpdate("UPDATE Students SET Score = 50 WHERE Name = \"Bob\";");
    }
    public static void dropTable () throws SQLException {
        stmt.executeUpdate("DROP TABLE Students");
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
