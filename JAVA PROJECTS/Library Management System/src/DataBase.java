import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/project"; // Assuming 'project' is the existing database name
    
            String userName = "root";
            String password = "sai@1234";
    
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}    



    // public static Connection getConnection() {
    //     Connection con=null;
    //     try{
    //         String url="jdbc:mysql://localhost:3306/";
            
    //         String databaseName="project";
    //         String userName="root";
    //         String password="sai@1234";

    //         Connection connection = DriverManager.getConnection(url, userName, password);

    //         java.sql.Statement statement = connection.createStatement();
    //         String sql = "CREATE DATABASE " + databaseName;

    //         statement.executeUpdate(sql);
    //         System.out.println("Database created successfully.");

    //         statement.close();
    //         connection.close();
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //     }
    //     return con;
    // }
// }

    




















    // public static void main(String[] args) {
    //     // Database URL, username, and password
    //     String url = "jdbc:mysql://localhost:3306/my_db";
    //     String username = "root";
    //     String password = "sai@1234";

    //     // Establishing the connection
    //     try {
    //         Connection connection = DriverManager.getConnection(url, username, password);
    //         if (connection != null) {
    //             System.out.println("Connected to the database!");
    //             // Perform operations here
    //             // Remember to close the connection when done: connection.close();
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Connection failed!");
    //         e.printStackTrace();
    //     }
    // }
// }
































// import java.sql.Connection;
// import java.sql.DriverManager;
// public class DataBase 
// {
// public static Connection getConnection()
// {
// Connection con=null;
// try
// {
// Class.forName("oracle.jdbc.driver.OracleDriver");
// con=DriverManager.getConnection("jdbc:oracle:thin:@218.248.0.7:1521:rdbms","245120737138","sai");
// }
// catch(Exception e)
// {
// System.out.println(e);
// }
// return con;
// }
// }
