package DBBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken;Time:21:02 Date:2018/3/26
 **/
public class SeasonBundle {

    private String season;

    private List<CateBundle> bundles = new ArrayList<>();

    public SeasonBundle(String season, List<CateBundle> bundles) {
        this.season = season;
        this.bundles = bundles;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<CateBundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<CateBundle> bundles) {
        this.bundles = bundles;
    }
}
