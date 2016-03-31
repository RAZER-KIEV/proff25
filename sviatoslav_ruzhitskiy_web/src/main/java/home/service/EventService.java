package home.service;

import home.domain.Employee;
import home.domain.MyEvent;
import home.domain.Network;
import home.domain.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by RAZER on 2/18/2016.
 */

public interface EventService {
    Long create(MyEvent event);
    MyEvent read(Long id);
    boolean update(MyEvent event);
    boolean delete(MyEvent event);
    List findAll();
    List findAllbyNetwork(Long networkId);
    List getLastNews(Date lastOnline, Long myId, Long myNetwork);
    //tasks
    Long createNewTaskEv(Task task);
    Long updateTaskEv(Task task, String message);
    Long deleteTask(Task task);
    //employees
    Long createNewEmplEv(Employee employee);
    Long deleteEmplEv(Employee employee);
    //networks
    Long createNewNetworkEv(Network network);
    Long deleteNetworkEv(Network network);




}
