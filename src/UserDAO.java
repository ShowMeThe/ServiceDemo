import java.sql.Connection;

public interface UserDAO {
    String getData(Connection connection,String id) throws Exception;
}
