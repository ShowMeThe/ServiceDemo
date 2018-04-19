import DBBean.CateBundle;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ken;Time:22:00 Date:2018/3/31
 **/
public class CateFiveImplement implements DBDAO {

    private List<Integer> data = new ArrayList<>();
    private String re;
    String sql;

    JSONObject object = new JSONObject();


    @Override
    public String getData(Connection connection, String TBName, String year, String month, String day) throws Exception {
        re = null;
        int temp =0;
        Statement statement = connection.createStatement();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.valueOf(year));
            calendar.set(Calendar.MONTH, Integer.valueOf(month));
            calendar.set(Calendar.DATE, Integer.valueOf(day));
            for (int i = 0; i < 5; i++) {
                calendar.add(Calendar.DATE,-i);

                sql = "Select * from "+ TBName + " where years =" + calendar.get(Calendar.YEAR) + " AND months =" + calendar.get(Calendar.MONTH)  + " AND days = " + calendar.get(Calendar.DAY_OF_MONTH) ;

                statement.execute(sql);
                ResultSet result = statement.getResultSet();
                data.clear();
                while (result.next()) {
                  temp = temp + Integer.valueOf(result.getString(8));
                }
            }
            data.add(temp);

            object.put("object",data);
            re = JSONObject.fromObject(object).toString();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }


    @Override
    public String getData(Connection connection, String TBName, String year, String season) throws Exception {
        return null;
    }

    @Override
    public String getData(Connection connection, String TBName) throws Exception {
        return null;
    }
}
