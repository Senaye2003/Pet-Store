package petStore;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnector.connect();
                Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS pets (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "age INTEGER," +
                    "weight REAL," +
                    "stock INTEGER," +
                    "price REAL)";
            statement.execute(createTableQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
