import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    static public Connection connectGet() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "M81M78");
    }
}
