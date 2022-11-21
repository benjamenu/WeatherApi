/**
 * This class is used to make a connection to a MYSQL database.
 * Data from the openweather API will be stored in the database.
 */

import java.sql.*;

public class Database {
    private final Connection connection;
    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "password");
        System.out.println("Database Connected");
    }

    /**
     * This method will store the current temperature and time
     * associated with that temperature when it was collected.
      * @param temperature Current Temperature
     * @param dateTime Current date and time
     * @throws SQLException
     */
    public void addToDB(double temperature, String dateTime) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "insert into currentweather " +
                "values ('"+dateTime+"', '"+temperature+"')";
        statement.executeUpdate(query);
        System.out.println("Entry added to DB");
    }

}
