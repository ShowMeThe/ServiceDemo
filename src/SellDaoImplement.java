
import DBBean.ListBundle;
import DBBean.SellList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken;Time:18:26 Date:2018/2/1
 **/
public class SellDaoImplement implements DBDAO {

   private List<SellList> data = new ArrayList<>();
   private String temp;
   private ListBundle bundle;
   private List<ListBundle> bundles = new ArrayList<>();

    @Override
    public String getData(Connection connection, String TBName, String year, String month, String day) throws Exception {
        return null;
    }

    @Override
    public String getData(Connection connection, String TBName, String year, String season) throws Exception {
        return null;
    }

    @Override
    public String getData(Connection connection, String TBName) throws Exception {
        String re = null;
        JSONObject object = new JSONObject();

        try {
            Statement statement = connection.createStatement();
            statement.execute("Select *  from "+ TBName);
            ResultSet result = statement.getResultSet();
           data.clear();
           bundles.clear();
           while (result.next()){
                        SellList list = new SellList(result.getString(1),result.getString(2),result.getString(3)
                                ,result.getString(4),result.getString(5),result.getString(6));
                                data.add(list);
            }
             for(int i=0;i<data.size();i++){
              if(i%4==0){
                  temp = data.get(i).getProName();
                  bundle = new ListBundle(temp);
                  bundle.addList(data.get(i));
                 }else {
                  bundle.addList(data.get(i));
                  if(bundle.getLists().size()==4) {
                      bundles.add(bundle);
                  }
              }
             }

            object.put("data",bundles);
            re = JSONObject.fromObject(object).toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  re;
    }
}
