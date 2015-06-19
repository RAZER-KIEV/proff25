package session10;

/**
 * Created by bosyi on 16.06.15.
 */
public class MainHiber {
    public static void main(String[] args) {
        HiberConnect hb = new HiberConnect();
        hb.openFactory();
        hb.openSession();
        hb.beginTransaction();
        hb.update(new Long(6), "rrrr");
        hb.commitTransaction();
        hb.closeSession();
        hb.closeFactory();
    }
}
