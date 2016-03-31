package home.service;

import home.dao.EmployeeDao;
import home.domain.Employee;
import home.domain.MyEvent;
import home.domain.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Service
@Transactional
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    OfficeService officeService;

    @Autowired
    NetworkService networkService;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EventService eventService;

    @Override
    public Long create(Employee empl) {

        Long officeId = networkService.read(empl.getNetworkId()).getOffices()[0];
        Office offis = officeService.read(officeId);
        empl.setLastLat(offis.getLatitude());
        empl.setLastLong(offis.getLongitude());
        Long id = employeeDao.create(empl);
        eventService.createNewEmplEv(employeeDao.read(id));
        return id;
    }

    @Override
    public Employee read(Long ig) {
        return employeeDao.read(ig);
    }

    @Override
    public boolean update(Employee empl) {
        return employeeDao.update(empl);
    }

    @Override
    public boolean delete(Employee empl) {
        MyEvent myEvent = new MyEvent();
        myEvent.setNetworkId(empl.getNetworkId());
        myEvent.setMessage("Employee "+empl.getLogin()+" was deleted!");
        myEvent.setPublishDate(new Date());
        return employeeDao.delete(empl);
    }

    @Override
    public Employee searchByLogin(String login) {
        return employeeDao.searchByLogin(login);
    }

    @Override
    public Long getDBSize() {
        return employeeDao.getDBSize();
    }

    @Override
    public List findAll() {
        return employeeDao.findAll();
    }

    @Override
    public List findAllwithNetwork(Long networkId) {
        return employeeDao.findAllwithNetwork(networkId);
    }
}
