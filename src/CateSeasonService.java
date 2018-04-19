import servlet.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Ken;Time:11:06 Date:2018/3/24
 **/
@WebServlet("/CateSeasonService")
public class CateSeasonService extends HttpServlet {
    private DBDAO cate = new CateSeasonImplement();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String re = null;


        String tbName = request.getParameter("store");
        String season = request.getParameter("season");
        String year = request.getParameter("years");
        String account = request.getParameter("account");

        Connection connection = DBUtil.getConnect(account);

        try {
            re = cate.getData(connection,tbName+"_store",year,season);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append(re);

    }

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
