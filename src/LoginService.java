import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String code="";
        String message="";

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        Connection connection = DBUtil.getConnect();
        try {
            Statement statement = connection.createStatement();
            String res="Select Username and Password FROM " + DBUtil.TABLE_USERINFO + " where Username=" + username + " and Password=" + password;
            ResultSet result=statement.executeQuery(res);

            if(result.next()){
                code ="1";
                message = "成功";
            }else {
                code = "-1";
                message = "失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType(DBUtil.Utf_8);
        response.getWriter().append(code);
    }

    @Override
    public void destroy(){
         super.destroy();
    }
}
