import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by Ken;Time:23:34 Date:2018/1/21
 **/
public class MySessionManager  {

    private static HashMap map = new HashMap();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            map.put(session.getId(), session);
        }
    }


    public static synchronized void DelSession(String session_id) {
        if (session_id!= null && map.size()!=0) {
            map.remove(session_id);
            System.out.println("删除成功");
        }
    }


    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null){
            return null;
        }else {
            return (HttpSession) map.get(session_id);
        }
    }
}
