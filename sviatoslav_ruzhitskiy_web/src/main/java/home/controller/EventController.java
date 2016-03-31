package home.controller;

import android.util.Log;
import home.domain.Employee;
import home.domain.MyEvent;
import home.service.EmployeeService;
import home.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import static home.controller.AuthenticationController.gson;
import static home.controller.AuthenticationController.log;

/**
 * Created by RAZER on 2/18/2016.
 */
@Controller
@SessionAttributes("id")
@RequestMapping(value = "/event")
public class EventController {

    private Long uId;

    @Autowired
    EventService eventService;

    @Autowired
    EmployeeService employeeService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/getAll", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String findAll(HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        return gson.toJson(eventService.findAll());
    }

    @RequestMapping(value = "/getAllbyNetwork", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String findAllbyNetwork(HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        return gson.toJson(eventService.findAllbyNetwork(employeeService.read(uId).getNetworkId()));
    }

    @RequestMapping(value = "/getLastNews", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String getLastNews(HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        log.info("getLastNews");
        Employee me = employeeService.read(uId);
        Date lastOnline = me.getLastOnline();
        log.info("lastOnline.toString()) = "+lastOnline.toString());
        List<MyEvent> news = eventService.getLastNews(lastOnline,me.getId(),me.getNetworkId());
        log.info("news.size(): " + news.size());
        if(news==null||news.size()==0){
            news = new ArrayList<>();
            news.add(new MyEvent(new Long[]{uId},"No news", new Date(),me.getNetworkId()));
        }
        me.setLastOnline(new Date());
        employeeService.update(me);
        return gson.toJson(news);
    }
}
