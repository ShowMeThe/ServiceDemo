import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ken;Time:12:54 Date:2018/1/29
 **/
@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String operation = null;
        JSONObject object = new JSONObject();
        Cookie[] cookies = request.getCookies();
        operation = request.getParameter("operation");
        for (Cookie getCookie : cookies) {
            Cookie cookie = new Cookie("JSESSION", getCookie.getValue());
            if (operation.equals("Out")) {
                object.put("Code", "400");
                object.put("Message", "登出成功");
                MySessionManager.DelSession(cookie.getValue());
                response.getWriter().append(object.toString());
                System.out.println("用户登出");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
