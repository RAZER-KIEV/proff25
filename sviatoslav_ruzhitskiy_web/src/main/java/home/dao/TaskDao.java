package home.dao;

import home.domain.Task;

import java.util.List;

/**
 * Created by ПК on 10.12.2015.
 */
public interface TaskDao {
    Long create(Task task);
    Task read(Long id);
    boolean update(Task task);
    boolean delete(Task task);
    List findAll(Long uID);
    List findTasksWithStatus(String status);
    List findTasksWithPriority(String priority);


}
