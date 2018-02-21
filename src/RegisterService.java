import com.mysql.jdbc.log.LogUtils;
import net.sf.json.JSONObject;

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
        String code = "300";
        String message = "用户名已存在";

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String account = request.getParameter("Username");
        String password = request.getParameter("Password");
        System.out.print(account + password);
        DBUtil.getCreatConnect(account);

        Connection connection = DBUtil.getConnect(account);
        try {
            Statement statement = connection.createStatement();
            String sqlInsert = "insert into " + DBUtil.TABLE_USERINFO + "(Username, Password) values('"
                    + account + "', '" + password + "')";
            if (statement.executeUpdate(sqlInsert)>0) { // 否则进行注册逻辑，插入新账号密码到数据库
                code = "200";
                message = "注册成功";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("Code",code);
        object.put("Message",message);
        response.getWriter().append(object.toString());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
