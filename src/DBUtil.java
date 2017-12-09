import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class DBUtil {
    static final String TABLE_USERINFO = "UserData";
    static final String TABLE_DATA = "studentdata";
    static final String Utf_8 = "text/html;charset=utf-8";

     static Connection getConnect(){
        String url = "jdbc:mysql://localhost:3306/user_data";
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



}
