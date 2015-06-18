package session10;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by george on 16.06.15.
 */
public class ClientHibernateDaoImpl implements ClienDao {

    private static Logger log = Logger.getLogger(String.valueOf(ClientHibernateDaoImpl.class));
    private SessionFactory factory;

    public ClientHibernateDaoImpl() {
    }

    public ClientHibernateDaoImpl (SessionFactory factory){this.factory=factory;}
    Session session = null;
    @Override
    public Long create(Client user) {
         session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(user);
            System.out.println(id);
            session.getTransaction().commit();
            return id;
        }catch(HibernateException ex){

        }finally{
            session.close();
        }
        return id;
    }

    @Override
    public Client read(Long id) {
        session = factory.openSession();
        Client client = null;
        try{
            session.beginTransaction();
            client = (Client) session.get(Client.class, id);
            System.out.println(client.getId()+"  "+client.getName());
            return client;
        }catch(HibernateException ex){

        }finally{
            session.close();
        }
        return client;
//        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delite() {

    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public int findeIdByName(String name) {
        return 0;
    }

    @Override
    public List<Client> findNameByIdDiapazone(int min, int max) {
        return null;
    }


}
