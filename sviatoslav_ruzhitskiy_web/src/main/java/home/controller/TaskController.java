package home.controller;

import home.domain.Employee;
import home.domain.MyEvent;
import home.domain.Network;
import home.domain.Task;
import home.enums.EmplPossition;
import home.enums.TaskStatus;
import home.enums.TaskType;
import home.service.EmployeeService;
import home.service.EventService;
import home.service.NetworkService;
import home.service.TaskService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.*;

import static home.controller.AuthenticationController.gson;
import static home.controller.AuthenticationController.log;

/**
 * Created by ПК on 10.12.2015.
 */
@Controller
@SessionAttributes("id")
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    EventService eventService;

    @Autowired
    NetworkService networkService;

    @Autowired
    EmployeeService employeeService;

    private Long uId;
    private Employee empl;
    private Task task;
    private Network network;
    MyEvent event;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);

    }

    @RequestMapping(value = "/addTask", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String addTask(@RequestParam("type") String gsonType, @RequestParam("address") String address , HttpSession httpSession)  {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        TaskType type = gson.fromJson(gsonType, TaskType.class);
        Task task = new Task(type,address);
        Long networkId = employeeService.read(uId).getNetworkId();
        if(networkId==null) return "You can not create Task! Firstly create/join Network ";
        task.setNetworkId(networkId);
        task.setExecuterIds(new Long[]{uId});
        return String.valueOf(taskService.create(task));
    }

    @RequestMapping(value = "/getTask", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getTask(@RequestParam("taskId") String id, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
       Task  task = taskService.read(Long.valueOf(id));
        return gson.toJson(task);
    }


    @RequestMapping(value = "/updateTask", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String updateTask(@RequestParam("task") String taskGson, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        empl = employeeService.read(uId);
        try {
            task = gson.fromJson(taskGson, Task.class);
            log.info("new task = "+task);
        }catch (Exception e){
            e.printStackTrace();
            return "INVALID_GSON!";
        }
        log.info("existing task = "+taskService.read(task.getTaskId()));
        return String.valueOf(taskService.update(task));
    }

    @RequestMapping (value = "/acceptTask", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String acceptTask(@RequestParam("taskId") String taskId, HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        return taskService.acceptTask(Long.valueOf(taskId), uId);
    }

    @RequestMapping(value = "/deleteTask", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String deleteTask(@RequestParam("taskId") String taskId, HttpSession httpSession) {
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Task task = taskService.read(Long.parseLong(taskId));
        return "deleted: "+taskService.delete(task);
    }

    @RequestMapping(value = "/getAll", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getAll(HttpSession httpSession) {
        if((uId = (Long) httpSession.getAttribute("NMQCUID"))==null)return "Not authenticated";
        System.out.println("getAll(); uId = "+uId);
        List<Task> taskList = taskService.findAll(employeeService.read(uId).getNetworkId());
        Collections.sort(taskList);
        return gson.toJson(taskList);
    }

    @RequestMapping(value = "/getNotDone", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getNotDone(HttpSession httpSession) {
        if((uId = (Long) httpSession.getAttribute("NMQCUID"))==null)return "Not authenticated";
        List<Task> taskList = taskService.findAll(uId);  // TODO: 2/19/2016
        return gson.toJson(taskList);
    }


}
