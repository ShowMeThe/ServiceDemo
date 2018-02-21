import java.sql.Connection;

public interface DBDAO {
    String getData(Connection connection,String TBName,String fruitName) throws Exception;
    String getData(Connection connection,String TBName) throws Exception;
}
