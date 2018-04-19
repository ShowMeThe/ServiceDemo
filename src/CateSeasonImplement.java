import DBBean.CateBundle;
import DBBean.SeasonBundle;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken;Time:11:06 Date:2018/3/24
 **/


public class CateSeasonImplement implements DBDAO {

    private List<SeasonBundle> bundles = new ArrayList<>();
    private String re;
    String sql;
    int start;
    String month;
    SeasonBundle bundle;

    @Override
    public String getData(Connection connection, String TBName, String year, String season) throws Exception {
        JSONObject object = new JSONObject();
        try {
            Statement statement = connection.createStatement();
            bundles.clear();
            start = Integer.valueOf(season);
            for(int i =0;i<3;i++){
                List<CateBundle> data = new ArrayList();
                if(data.size()>0){
                    data.clear();
                }
                month = String.valueOf(start++);
                sql = "Select * from "+ TBName + " where years =" + year + " AND months =" + month;
                statement.execute(sql);
                ResultSet result = statement.getResultSet();
                while (result.next()) {
                    CateBundle cate = new CateBundle(result.getString(5),result.getString(6),result.getString(7),result.getString(8));
                    data.add(cate);
                }
                System.out.println(data.size());
                bundle = new SeasonBundle(month,data);
                bundles.add(bundle);
            }

            object.put("object",bundles);
            re = JSONObject.fromObject(object).toString();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return re;
    }


    @Override
    public String getData(Connection connection, String TBName) throws Exception {
        return null;
    }

    @Override
    public String getData(Connection connection, String TBName, String year, String month, String day) throws Exception {
        return null;
    }
}
