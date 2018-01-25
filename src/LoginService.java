import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
         this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
        String code="202";
        String message="失败";
        String username = null;
        String password = null;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();

        username = request.getParameter("username");
        password = request.getParameter("password");

        for(Cookie getCookie:cookies){
            Cookie cookie = new Cookie("JSESSION",getCookie.getValue());
            System.out.println("From Android:" + cookie.getValue());
            System.out.println( "From Web" + MySessionManager.getSession(cookie.getValue()));

            if(cookie.getName().equals("JSESSION") && !cookie.getValue().isEmpty() && MySessionManager.getSession(cookie.getValue())!= null){

                JSONObject object = new JSONObject();
                object.put("Code","400");
                object.put("Message","");
                response.getWriter().append(object.toString());
                return;
            }else {
                System.out.print("FALSE");
            }
        }

        session.setMaxInactiveInterval(60*60);
        session.setAttribute("Username",username);
        session.setAttribute("Password",password);

        Connection connection = DBUtil.getConnect("admin");
        try {
            Statement statement = connection.createStatement();
            String res="SELECT * FROM " + DBUtil.TABLE_USERINFO + " where Username =" + username + " and Password =" + password;
            ResultSet result=statement.executeQuery(res);

            while (result.next()){
                if (result.getString("Username").equals(username) && result.getString("Password").equals(password)) {
                    code = "200";
                    message = "成功";
                   MySessionManager.AddSession(session);
                }
            }

            JSONObject object = new JSONObject();
            object.put("Code",code);
            object.put("Message",message);
            response.getWriter().append(object.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
