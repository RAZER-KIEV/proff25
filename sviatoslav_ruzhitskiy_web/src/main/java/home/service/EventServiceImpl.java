package home.service;

import home.dao.EmployeeDao;
import home.dao.EventDao;
import home.dao.NetworkDao;
import home.dao.TaskDao;
import home.domain.Employee;
import home.domain.MyEvent;
import home.domain.Network;
import home.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by RAZER on 2/18/2016.
 */

@Transactional
@Service

public class EventServiceImpl implements EventService {


    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    TaskDao taskDao;

    @Autowired
    NetworkDao networkDao;

    @Autowired
    EventDao eventDao;

    private MyEvent myEvent;

    @Override
    public Long create(MyEvent event) {
        return eventDao.create(event);
    }

    @Override
    public Long createNewTaskEv(Task task) {
        makeNewEvent();
        myEvent.setNetworkId(task.getNetworkId());
        myEvent.setResevers(networkDao.read(task.getNetworkId()).getEmployees());
        myEvent.setMessage("New Task #"+task.getTaskId()+" with address "+task.getAddress()+" was Created");
        return eventDao.create(myEvent);
    }

    @Override
    public Long createNewEmplEv(Employee employee) {
        makeNewEvent();
        Long netId = employee.getNetworkId();
        if(netId!=null){
            myEvent.setNetworkId(netId);
            myEvent.setResevers(networkDao.read(employee.getNetworkId()).getEmployees());
        }
        myEvent.setNetworkId(netId);
        myEvent.setMessage("New Employee #"+employee.getId()+" with Login "+employee.getLogin()+" was Created");
        return eventDao.create(myEvent);
    }

    @Override
    public Long deleteEmplEv(Employee employee) {
        makeNewEvent();
        myEvent.setNetworkId(employee.getNetworkId());
        myEvent.setMessage("Employee "+employee.getLogin()+" was deleted");
        return null;
    }

    @Override
    public Long createNewNetworkEv(Network network) {
        makeNewEvent();
        myEvent.setMessage("New Network #"+network.getNetworkId()+" with name "+network.getName()+" was Created");
        return eventDao.create(myEvent);
    }

    @Override
    public Long deleteNetworkEv(Network network) {
        makeNewEvent();
        myEvent.setMessage("Attention! Your network was deleted!");
        return eventDao.create(myEvent);
    }

    @Override
    public Long updateTaskEv(Task task, String message) {
        makeNewEvent();
        myEvent.setMessage(message);        //"Task #"+task.getTaskId()+" with address "+task.getAddress()+" was modified");
        myEvent.setResevers(networkDao.read(task.getNetworkId()).getEmployees());
        myEvent.setNetworkId(task.getNetworkId());
        return eventDao.create(myEvent);
    }

    @Override
    public Long deleteTask(Task task) {
        makeNewEvent();
        myEvent.setMessage("Task #"+task.getTaskId()+" with address "+task.getAddress()+" was deleted!");
        myEvent.setResevers(networkDao.read(task.getNetworkId()).getEmployees());
        myEvent.setNetworkId(task.getNetworkId());
        return eventDao.create(myEvent);
    }

    private void makeNewEvent(){
        myEvent = new MyEvent();
        myEvent.setPublishDate(new Date());
    }

    @Override
    public MyEvent read(Long id) {
        return eventDao.read(id);
    }

    @Override
    public boolean update(MyEvent event) {
        return eventDao.update(event);
    }

    @Override
    public boolean delete(MyEvent event) {
        return eventDao.delete(event);
    }

    @Override
    public List findAll() {
        return eventDao.findAll();
    }

    @Override
    public List findAllbyNetwork(Long networkId) {
        List<MyEvent> myEvents = eventDao.findAllbyNetwork(networkId);
        Collections.sort(myEvents);
        return myEvents;
    }

    @Override
    public List getLastNews(Date lastOnline, Long myId, Long myNetwork) {
        return eventDao.getLastNews(lastOnline,myId,myNetwork);
    }

}
