import DBBean.CateBundle;
import DBBean.SellList;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken;Time:21:16 Date:2018/3/20
 **/
public class CateSearchImplement implements DBDAO {


    private List<CateBundle> data = new ArrayList<>();
    private String re;
    String sql;


    @Override
    public String getData(Connection connection, String TBName,String year,String month,String day) throws Exception {
         re = null;
        JSONObject object = new JSONObject();
        try {
                Statement statement = connection.createStatement();

            if(day == null){
                sql = "Select * from "+ TBName + " where years =" + year + " AND months =" + month;

                statement.execute(sql);
                ResultSet result = statement.getResultSet();
                data.clear();
                while (result.next()) {
                    CateBundle bundle = new CateBundle(result.getString(5),result.getString(6),result.getString(7),result.getString(8));
                    data.add(bundle);
                }

            }else {
                sql = "Select * from "+ TBName + " where years =" + year + " AND months =" + month + " AND days = " + day;

                statement.execute(sql);
                ResultSet result = statement.getResultSet();
                data.clear();
                while (result.next()) {
                    CateBundle bundle = new CateBundle(result.getString(5),result.getString(6),result.getString(7),result.getString(8));
                    data.add(bundle);
                }
            }
            object.put("object",data);

            re = JSONObject.fromObject(object).toString();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  re;
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
