package home.dao;

import home.domain.MyEvent;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by RAZER on 2/18/2016.
 */

@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    SessionFactory sessionFactory;

    List<MyEvent> eventList;

    @Override
    public Long create(MyEvent event) {
        return (Long) sessionFactory.getCurrentSession().save(event);
    }

    @Override
    public MyEvent read(Long id) {
        return (MyEvent) sessionFactory.getCurrentSession().get(MyEvent.class, id);
    }

    @Override
    public boolean update(MyEvent event) {
        sessionFactory.getCurrentSession().update(event);
        return true;
    }

    @Override
    public boolean delete(MyEvent event) {
        sessionFactory.getCurrentSession().delete(event);
        return true;
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from MyEvent");
        eventList = query.list();
        return eventList;
    }

    @Override
    public List findAllbyNetwork(Long networkId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from MyEvent e where e.networkId=:nwId");
        query.setParameter("nwId",networkId);
        eventList = query.list();
        return eventList;
    }

    @Override
    public List getLastNews(Date lastOnline, Long myId, Long myNetwork) {
        Query query = sessionFactory.getCurrentSession().createQuery("from MyEvent e where e.networkId=:nwId and e.publishDate>:myLastOnline").setParameter("myLastOnline",lastOnline);
        query.setParameter("nwId",myNetwork);
        List<MyEvent> events = query.list();
        List<MyEvent> onlyMyEvents;
        if(events!=null && events.size()>0){
        onlyMyEvents = new ArrayList<MyEvent>();
        for(MyEvent event : events){
            for (Long resever :event.getResevers()){
                if(resever!=null && resever.equals(myId)) onlyMyEvents.add(event);
            }
        }
        }else return events;
        System.out.println("events.size()" + events.size());
        System.out.println("onlyMyEvents.size()" + onlyMyEvents.size());
        return events;
    }
}
