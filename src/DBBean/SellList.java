package DBBean;

/**
 * Created by Ken;Time:12:16 Date:2018/2/1
 **/
public class SellList {
      String ID;
      String SellTime;
      String ProNumber;
      String ProName;
      String Price;
      String Total;

    public SellList(String ID, String sellTime, String proNumber, String proName, String price, String total) {
        this.ID = ID;
        SellTime = sellTime;
        ProNumber = proNumber;
        ProName = proName;
        Price = price;
        Total = total;
    }

    public String getID() {
        return ID;
    }

    public String getSellTime() {
        return SellTime;
    }

    public String getProNumber() {
        return ProNumber;
    }

    public String getProName() {
        return ProName;
    }

    public String getPrice() {
        return Price;
    }

    public String getTotal() {
        return Total;
    }
}
