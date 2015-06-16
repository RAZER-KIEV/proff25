package lection05;

import org.hibernate.*;

/**
 * hibernate save/update/delete
 */
public class MainHiber {
    public static void main(String[] args) {
        HiberConnect hiberConnect = new HiberConnect();
        try {
            hiberConnect.init();
            hiberConnect.openSession();
            hiberConnect.beginTransaction();
            //hiberConnect.save("Antarktida");
            //hiberConnect.update("Antarktida","Antarktika");
            //hiberConnect.delete("Antarktika");
            hiberConnect.commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            hiberConnect.closeSession();
            hiberConnect.closeFactory();
        }
    }
}
