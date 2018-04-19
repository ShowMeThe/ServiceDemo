import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/SellService")
public class SellService extends HttpServlet {
      private DBDAO sell = new SellDaoImplement();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");

        String re = null;

        Connection connection = DBUtil.getConnect(account);

        try {
          re = sell.getData(connection,"selllist");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append(re);
    }
}