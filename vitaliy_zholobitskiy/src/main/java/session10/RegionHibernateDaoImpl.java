package session10;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by just1ce on 16.06.2015.
 */
public class RegionHibernateDaoImpl implements RegionDao  {
    private static Logger log= Logger.getLogger(RegionHibernateDaoImpl.class);
    private SessionFactory factory;

    public RegionHibernateDaoImpl(SessionFactory factory)
    {
        this.factory=factory;
    }
    @Override
    public Long create(Region reg) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.save(reg);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            log.error(
                   "Transaction failed"
            );
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return 0L;
    }

    @Override
    public Region read(Long id) {
        Session session=factory.openSession();
        try{
            return (Region)session.get(Region.class,id);
        }
        catch(HibernateException e){
            log.error(
                    "Transaction failed"
            );
        }
        finally {
            session.close();
        }
        return  null;
    }

    @Override
    public void update(Region reg) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(reg);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            log.error(
                    "Transaction failed"
            );
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

    }

    @Override
    public void delete(Region reg) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(reg);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            log.error(
                    "Transaction failed"
            );
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }
    @Override
    public List<Region> findAll(){
        Session session=factory.openSession();
        Query query=session.createQuery("from Region");
        return query.list();
    }

    @Override
    public List<Region> findForName(String name) {
        Session session=factory.openSession();
        Query query=session.createQuery("from Region r " +
                "where r.name = '"+name+"'");
        return query.list();
    }

    @Override
    public List<Region> findForIndeces(int start,int end) {
        Session session=factory.openSession();
        Query query=session.createQuery("from Region r " +
                "where r.id > "+start+"and r.id<"+end);
        return query.list();

    }

    @Override
    public List<Region> getPorcies(int count_el) {
        Session session=factory.openSession();
        Query query=session.createQuery("from Region");
        query.setFirstResult(1);
        query.setMaxResults(count_el);
        return query.list();
    }
}
