package session10;

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
            //hiberConnect.commit();
            System.out.println(hiberConnect.findAll());
            System.out.println(hiberConnect.findBetweenID(2, 4));
            System.out.println(hiberConnect.findRegionName("Europe"));
            for (int i = 1; i < hiberConnect.count(); i+=2) {
                System.out.println(hiberConnect.getPart(i,2));
            }

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