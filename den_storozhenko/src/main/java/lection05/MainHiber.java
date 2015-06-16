package lection05;

import org.hibernate.HibernateException;

/**
 * Created by storo_000 on 16.06.2015.
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
            hiberConnect.close();
        }

    }
}
