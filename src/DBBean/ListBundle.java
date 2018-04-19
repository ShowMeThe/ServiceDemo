package DBBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken;Time:11:52 Date:2018/2/20
 **/
public class ListBundle {
    private String ProName;
    private List<SellList> lists = new ArrayList<>();

    public ListBundle(String proName) {
        ProName= proName;
    }

    public void addList(SellList list){
        lists.add(list);
    }

    public String getProName() {
        return ProName;
    }

    public List<SellList> getLists() {
        return lists;
    }

    public void setProName(String proName) {
        ProName = proName;
    }
}
