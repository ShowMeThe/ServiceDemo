import net.sf.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDAO {
    @Override
    public String getData(Connection connection, String id) throws Exception {


        List<Student> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute("Select * from "+ DBUtil.TABLE_DATA + " where ID ="+id);
            ResultSet result = statement.getResultSet();
            while(result.next()){
                Student student = new Student(result.getString("name"),Integer.valueOf(result.getString("age")));
                data.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String re =  JSONArray.fromObject(data).toString();

        return re;
    }
}
