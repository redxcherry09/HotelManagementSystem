package hotelmanagement;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel_advanced",
                "root",
                "root"
            );
        } catch(Exception e) {
            return null;
        }
    }public static void main(String[] args) {
        new Login();
    }
}
