package home.controller;

import home.dao.OfficeDao;
import home.domain.Employee;
import home.domain.Network;
import home.domain.Office;
import home.enums.EmplPossition;
import home.service.EmployeeService;
import home.service.NetworkService;
import home.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Locale;

import static home.controller.AuthenticationController.gson;

/**
 * Created by RAZER on 11-Mar-16.
 */
@Controller
@SessionAttributes("id")
@RequestMapping(value = "/office")
public class OfficeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NetworkService networkService;

    @Autowired
    OfficeService officeService;

    private Long uId;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }


    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String create(@RequestParam("latitude") String latitude, @RequestParam ("longitude") String longitude, @RequestParam ("officeName") String name, HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Office office = new Office();
        Network network = networkService.read(employeeService.read(uId).getNetworkId());
        Long networkId = network.getNetworkId();
        office.setNetworkId(networkId);
        office.setLatitude(Double.parseDouble(latitude));
        office.setLongitude(Double.parseDouble(longitude));
        office.setName(name);
        if(amISuperAdmin(uId)){
                Long id = officeService.create(office);
                if(id>0){ network.setOffices(longArrayPlusOne(network.getOffices(), id));
                    networkService.update(network);
                }
                return String.valueOf(id);
            }
        else return "You haven't permissions";
    }

    @RequestMapping(value = "/read", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String read(@RequestParam("officeId") String id,  HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        return gson.toJson(officeService.read(Long.valueOf(id)));
    }

    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String update(@RequestParam("officeGson")String officegson,  HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        //client = employeeService.read(uId);
        Office office = gson.fromJson(officegson, Office.class);
        if(amISuperAdmin(uId, office.getOfficeId()))
             return String.valueOf(officeService.update(office));
        else return "You haven't permissions";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String delete(@RequestParam("officeId")String officeid,  HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        //client = employeeService.read(uId);
        Office office = officeService.read(Long.valueOf(officeid));
        if(amISuperAdmin(uId, office.getOfficeId()))
             return String.valueOf(officeService.delete(officeService.read(Long.valueOf(officeid))));
        else return "You haven't permissions";
    }

    @RequestMapping(value = "/getAll", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String findAll( HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        return gson.toJson(officeService.findAll(employeeService.read(uId).getNetworkId()));
    }

    private boolean amISuperAdmin(Long emplId, Long officeId){
        Office office = officeService.read(officeId);
        Employee client = employeeService.read(emplId);
        if(client.getNetworkId().equals(office.getNetworkId()) && client.getPosition().equals(EmplPossition.SUPERADMIN))
            return true;
        else
            return false;
    }

    private boolean amISuperAdmin(Long emplId){
        Employee client = employeeService.read(emplId);
        if(client.getPosition().equals(EmplPossition.SUPERADMIN))
            return true;
        else
            return false;
    }

    public Long[] longArrayPlusOne(Long[] array, Long id){
        if(array!=null){
            Long[] newArray = Arrays.copyOf(array, array.length+1);
            newArray[newArray.length-1] = id;
               return newArray;
        }else  return new Long[]{id};
    }

}
