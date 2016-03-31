package home.service;

import home.dao.TaskDao;
import home.domain.Employee;
import home.domain.Task;
import home.enums.TaskStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 10.12.2015.
 */

@Service
@Transactional
public class TaskServiceImpl implements TaskService{

    public static final Logger log = Logger.getLogger(TaskServiceImpl.class);

    @Autowired
    EventService eventService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TaskDao taskDao;

    @Override
    public Long create(Task task) {
        Long id = taskDao.create(task);
        if(id!=null){
           eventService.createNewTaskEv(taskDao.read(id));
        }
        return id;
    }

    @Override
    public Task read(Long id) {
        return taskDao.read(id);
    }

    @Override
    public boolean update(Task task) {
        //Task old = read(task.getTaskId());
       // log.info("old task = "+old+"\n new task = "+task);
        //String message="";
        /*if(old.getStatus()!=task.getStatus()){
            message = "Task #"+task.getTaskId()+", "+task.getAddress() +" - status changed to "+task.getStatus();
        }else message = "Task #"+task.getTaskId()+", "+task.getAddress()+" was modified";*/
        boolean updated = taskDao.update(task);
        //eventService.updateTaskEv(task,message);
        return updated;
    }

    @Override
    public String acceptTask(Long taskId, Long uId) {
        Task task = read(taskId);
        Employee empl = employeeService.read(uId);
            if(task.getStatus()== TaskStatus.NEW) {
                task.setAccepted(new Date());
                task.setStatus(TaskStatus.INPROCESS);
                task.setExecuterIds(longArrayPlusOne(task.getExecuterIds(), uId));
                empl.setBusy(true);
                empl.setCurrentTaskId(taskId);
            }else if (task.getStatus() == TaskStatus.INPROCESS) {
                task.setDone(new Date());
                task.setStatus(TaskStatus.DONE);
                empl.setBusy(false);
                empl.setCurrentTaskId(null);
            } else  if(task.getStatus() == TaskStatus.DONE){
                return "This task is already done!";
            }
        String message = "Task #"+task.getTaskId()+", "+task.getAddress() +"  "+". Status changed: "+task.getStatus();
        boolean updated = update(task);
        employeeService.update(empl);
        eventService.updateTaskEv(task, message);
        return null;
    }

    @Override
    public boolean delete(Task task) {
        boolean deleted = taskDao.delete(task);
        eventService.deleteTask(task);
        return deleted;
    }

    @Override
    public List findAll(Long uId) {
        return taskDao.findAll(uId);
    }


    public Long[] longArrayPlusOne(Long[] array, Long id){
        if(array!=null){
            Long[] newArray = Arrays.copyOf(array, array.length+1);
            newArray[newArray.length-1] = id;
            return newArray;
        }else  return new Long[]{id};
    }

    // -----------------Task GENERATOR ---------------------! // TODO: 2/8/2016

}
