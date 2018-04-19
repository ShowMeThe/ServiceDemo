import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ken;Time:23:35 Date:2018/1/21
 **/
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        MySessionManager.AddSession(httpSessionEvent.getSession());
    }


    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        MySessionManager.DelSession(session.getId());
    }
}
