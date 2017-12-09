import com.mysql.jdbc.log.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/RegisterService")
public class RegisterService extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = "";
        String message = "";

        String account = request.getParameter("Username");
        String password = request.getParameter("Password");

        Connection connect = DBUtil.getConnect();
        try {
            Statement statement = connect.createStatement();
            String sql = "select Username from " + DBUtil.TABLE_USERINFO + " where Username='" + account + "'";

            ResultSet result = statement.executeQuery(sql);
            if (result.next()) { // 能查到该账号，说明已经注册过了
                code = "100";
                message = "该账号已存在";
                return;
            } else {
                String sqlInsert = "insert into " + DBUtil.TABLE_USERINFO + "(Username, Password) values('"
                        + account + "', '" + password + "')";
                System.out.print("注册");

                if (statement.executeUpdate(sqlInsert)>0) { // 否则进行注册逻辑，插入新账号密码到数据库
                    code = "200";
                    message = "注册成功";
                } else {
                    code = "300";
                    message = "注册失败";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType(DBUtil.Utf_8);
        response.getWriter().append("code:").append(code).append(";message:").append(message);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
