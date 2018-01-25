import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBUtil {
    static final String TABLE_USERINFO = "userdata";
    static final String Utf_8 = "text/html;charset=utf-8";

    static final String APPLE_DATA = "apple";
    static final String WATERMELON_DATA= "watermelon";


     static Connection getConnect(String rootName){
        String url = "jdbc:mysql://localhost:3306/"+ rootName;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,"root","WAsd8787@");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("State :"+ e.getSQLState());
        }
        return connection;
    }

     static void getCreatConnect(String root){
         String url = "jdbc:mysql://localhost:3306/admin";
         Connection connection = null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection(url,"root","WAsd8787@");
             Statement statement = connection.createStatement();
             statement.executeUpdate("create database "+ root);
             statement.close();
             connection.close();

             String newUrl = "jdbc:mysql://localhost:3306/"+ root;
             connection = DriverManager.getConnection(newUrl,"root","WAsd8787@");
             statement = connection.createStatement();
             statement.executeUpdate("CREATE  TABLE userdata(Username VARCHAR(80) primary key,Password VARCHAR(80))");
             statement.close();
             connection.close();

         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
     }

}
