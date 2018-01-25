import java.sql.Connection;

public interface DBDAO {
    String getData(Connection connection,String DbName,String fruitName) throws Exception;
}
