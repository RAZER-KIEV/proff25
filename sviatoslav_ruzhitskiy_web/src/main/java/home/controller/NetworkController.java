package home.controller;

import home.domain.Employee;
import home.domain.Network;
import home.enums.EmplPossition;
import home.service.EmployeeService;
import home.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Locale;
import static home.controller.AuthenticationController.gson;

/**
 * Created by RAZER on 2/8/2016.
 */
@Controller
@SessionAttributes("id")
@RequestMapping(value = "/network")
public class NetworkController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NetworkService networkService;

    private Long uId;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String create (@RequestParam("networkname")String networkname, HttpSession httpSession){
        if((uId = (Long) httpSession.getAttribute("NMQCUID"))==null)return "Not authenticated";
        Network network = new Network(networkname,new Long[]{uId});
        Long netwId = networkService.create(network);
        Employee e = employeeService.read(uId);
        e.setNetworkId(netwId);
        e.setPosition(EmplPossition.SUPERADMIN);
        employeeService.update(e);
        return String.valueOf(netwId);
    }


    @RequestMapping(value = "/addEmployeeToMyNetwork", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String addEmployeeToMyNetwork(@RequestParam("emplId") String id, HttpSession httpSession){
        if((uId= (Long) httpSession.getAttribute("NMQCUID"))==null) return "Not authenticated";
        Long newEmpID = Long.valueOf(id);
        if(newEmpID==null)return "Error. Incorrect ID";
        Employee newEmpl  = employeeService.read(newEmpID);
        if(newEmpl==null) return "Error!No such Employee Found!";
        Network myNetwork = networkService.read(employeeService.read(uId).getNetworkId());
        //Long myNetworkId = networkService.read(employeeService.read(uId).getNetworkId()).getNetworkId();
        if(myNetwork==null) return "Error! You haven't network";
        Long[] emplIds = myNetwork.getEmployees();
        //System.out.println(Arrays.toString(emplIds));
        Long[] newEmplIds;
        if(emplIds!=null){
            newEmplIds = new Long[emplIds.length+1];
            System.arraycopy(emplIds,0,newEmplIds,0,emplIds.length);
        }else {
            newEmplIds = new Long[1];
        }
        newEmplIds[newEmplIds.length-1] = newEmpID;
        myNetwork.setEmployees(newEmplIds);
        Boolean networkUpdated = networkService.update(myNetwork);
        newEmpl.setNetworkId(myNetwork.getNetworkId());
        Boolean employeeUpdated = employeeService.update(newEmpl);
        if(networkUpdated&employeeUpdated) return "Success";
        else return "networkUpdated  = "+networkUpdated+", employeeUpdated =  "+employeeUpdated;
    }

    @RequestMapping(value = "/read", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String read(@RequestParam("id") String id){
        return gson.toJson(networkService.read(Long.valueOf(id)));
    }

    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String update(@RequestParam("networkgson")String networkgson){
        Network network = gson.fromJson(networkgson, Network.class);
        return String.valueOf(networkService.update(network));
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String delete(@RequestParam("networkid")String networkId){
        return String.valueOf(networkService.delete(networkService.read(Long.valueOf(networkId))));
    }

    @RequestMapping(value = "/getAll", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String findAll(){
        return gson.toJson(networkService.findAll());
    }
}
