import java.sql.Connection;

public interface DBDAO {
    String getData(Connection connection,String TBName,String year,String month,String day) throws Exception;

    String getData(Connection connection,String TBName,String year,String season) throws Exception;

    String getData(Connection connection, String TBName) throws Exception;
}
