package home.controller;

import home.domain.Employee;
import home.domain.PointGPS;
import home.service.EmployeeService;
import home.service.PointGPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ПК on 08.12.2015.
 */

@Controller
@SessionAttributes("id")
@RequestMapping(value = "/gps")
public class GPSController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PointGPSService pointGPSService;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/updateLocation", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String updateLocation(@RequestParam("emplId") String emplId, @RequestParam("long") String longitude, @RequestParam("lat") String latitude)  {
       // Task task = new Task(title,description);
        PointGPS pointGPS = new PointGPS(Double.valueOf(longitude), Double.valueOf(latitude), Long.valueOf(emplId));
        Employee employee = employeeService.read(Long.parseLong(emplId));
        if(employee!=null){
            //employee.setLastlatLong(new Double[]{Double.valueOf(longitude), Double.valueOf(latitude)});
            employee.setLastLat(Double.valueOf(latitude));
            employee.setLastLong(Double.valueOf(longitude));
            employee.setLastOnline(new Date());
            employeeService.update(employee);
            System.out.println(employee);
        }
        return String.valueOf(pointGPSService.create(pointGPS));
    }
}
