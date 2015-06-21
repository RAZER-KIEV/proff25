package session10.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import session10.Region;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by RAZER on 16.06.2015.
 */
public class RegionHipernateDaoImpl implements ReginDao {
    //private static Logger log = Logger.getLogger(String.valueOf(RegionHipernateDaoImpl.class));
    private SessionFactory sessionFactory;

    public RegionHipernateDaoImpl(SessionFactory sfact){
        sessionFactory=sfact;

    }
    @Override
    public Long create(Region reg) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(reg);
            session.getTransaction().commit();
            return id;

        }catch (HibernateException hibEx){
            session.getTransaction().rollback();
         }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Region read(Long id) {
        Session session = sessionFactory.openSession();
        try{
        return (Region) session.get(Region.class, id);
        }catch(HibernateException hipEx){
            session.getTransaction().rollback();

        }finally{
            session.close();
        }
        //return session.get(Region.class, id);
        return null;
    }

    @Override
    public void update(Region newOne) {
        Session session = sessionFactory.openSession();


    }

    @Override
    public void delete(Region reg) {
        Session session = sessionFactory.openSession();
        try{
         session.delete(reg);
        }catch(HibernateException hipEx){
            session.getTransaction().rollback();

        }finally{
            session.close();
        }
    }

    @Override
    public List<Region> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Region");
        return query.list();
    }

    @Override
    public Region findRegById(Long id) {
        Session session = sessionFactory.openSession();
        String query = "from Regions r where r.id="+id+"\"";
        Region regionres =(Region) session.createQuery(query);

        return regionres;
    }

    @Override
    public Region findByName(String name) {
        Session session = sessionFactory.openSession();
        String query ="from Regions r.name ="+name+"\"";
        Region regionres =(Region) session.createQuery(query);

        return regionres;
    }

    @Override
    public List<Region> findAllby(int begin, int size) {
        Session session = sessionFactory.openSession();
        String qu ="from Region r";
        Query query = session.createQuery(qu);
        query.setFirstResult(begin);
        query.setMaxResults(size);
        List<Region> listReg = (List<Region>) query.uniqueResult();

        return listReg;
    }

}
