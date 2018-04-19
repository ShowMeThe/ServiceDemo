package DBBean;

/**
 * Created by Ken;Time:21:12 Date:2018/3/20
 **/
public class CateBundle {
    private String year,month,day,morn,after,eve,out;

    public CateBundle(String morn,String after, String eve, String out) {
        this.after = after;
        this.eve = eve;
        this.out = out;
        this.morn = morn;
    }

    public String getMorn() {
        return morn;
    }

    public void setMorn(String morn) {
        this.morn = morn;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getEve() {
        return eve;
    }

    public void setEve(String eve) {
        this.eve = eve;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
