import java.sql.*;

public class sqlconnection {
    public static void main(String[] args) throws SQLException {
        // Connect to the SQL Server database
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=helloworld",
                "testuser", "Welcome@123");

        // Create a SQL statement to extract a record from a table
        String sql = "select * from [helloworld].[dbo].[employees]";

        // Prepare the SQL statement with a parameterized query
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1); // Set the parameter value for the "id" column

        // Execute the SQL statement and retrieve the result set
        ResultSet resultSet = statement.executeQuery();

        // Process the result set and extract the record
        if (resultSet.next()) {
            int id = resultSet.getInt("emp_id");
            String name = resultSet.getString("emp_name");
            int age = resultSet.getInt("emp_age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        // Close the resources
        resultSet.close();
        statement.close();
        connection.close();
    }
}
