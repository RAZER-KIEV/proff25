package home.service;

import home.domain.Task;

import java.util.List;

/**
 * Created by ПК on 10.12.2015.
 */
public interface TaskService {
    Long create(Task task);
    Task read(Long id);
    boolean update(Task task);
    String acceptTask(Long taskId, Long uId);
    boolean delete(Task task);
    List findAll(Long uID);
}
