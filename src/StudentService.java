import jdk.nashorn.internal.objects.annotations.Where;
import net.sf.json.JSONArray;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StudentService")
public class StudentService extends HttpServlet {
    private UserDAO userDAO = new UserDaoImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
      doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Connection connection = null;
        connection = DBUtil.getConnect();
        String number = request.getParameter("ID");
        String re = null;
        try {
            re = userDAO.getData(connection,number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(DBUtil.Utf_8);
        response.getWriter().append(re).flush();

    }



    @Override
    public void destroy(){
        super.destroy();
    }
}