package home.dao;

import home.domain.Task;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 10.12.2015.
 */
@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Long create(Task task) {
        return (Long)sessionFactory.getCurrentSession().save(task);
    }

    @Override
    public Task read(Long id) {
        return (Task)sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public boolean update(Task task) {
        sessionFactory.getCurrentSession().update(task);
        return true;
    }

    @Override
    public boolean delete(Task task) {
        sessionFactory.getCurrentSession().delete(task);
        return true;
    }

    @Override
    public List findAll(Long uId) {
        List<Task> tasks;
        Query query = sessionFactory.getCurrentSession().createQuery("from Task t where t.networkId=:id");
        query.setParameter("id",uId);
        tasks = query.list();
        return tasks;
    }

    @Override
    public List findTasksWithStatus(String status) {
        List<Task> tasks;
        Query query = sessionFactory.getCurrentSession().createQuery("from Task t where t.status=:status");
        query.setParameter("status",status);
        tasks = query.list();
        return tasks;
    }

    @Override
    public List findTasksWithPriority(String priority) {
        List<Task> tasks;
        Query query = sessionFactory.getCurrentSession().createQuery("from Task t where t.priority=:priority");
        query.setParameter("priority",priority);
        tasks = query.list();
        return tasks;
    }
}
