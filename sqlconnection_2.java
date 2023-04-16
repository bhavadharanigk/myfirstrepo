import java.sql.*;

public class sqlconnection_2 {
    public static void main(String[] args) {
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connect to the database
            String url = "jdbc:sqlserver://localhost:1433;databaseName=helloworld;user=testuser;password=Welcome@123";
            Connection conn = DriverManager.getConnection(url);

            // Execute the SELECT query
            String query = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process the query results
            while (rs.next()) {
                // Access each column by name or index
                String column1Value = rs.getString("ColumnName1");
                int column2Value = rs.getInt("ColumnName2");
                // ...
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
