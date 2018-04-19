import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Ken;Time:21:13 Date:2018/3/20
 **/
@WebServlet("/CateSearchService")
public class CateSearchService extends HttpServlet {
    private DBDAO cate = new CateSearchImplement();

    @Override
    protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String re = null;

        String tbName = request.getParameter("store");
        String year = request.getParameter("years");
        String month = request.getParameter("months");
        String day = request.getParameter("days");
        String account = request.getParameter("account");

        Connection connection = DBUtil.getConnect(account);
        try {
            re = cate.getData(connection,tbName+"_store",year,month,day);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append(re);

    }

       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
