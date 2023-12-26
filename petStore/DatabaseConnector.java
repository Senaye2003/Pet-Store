package petStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:sqlite:petstore.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
