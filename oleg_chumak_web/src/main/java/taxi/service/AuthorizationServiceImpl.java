package taxi.service;

import taxi.dao.OperatorDao;
import taxi.dao.RoleDao;
import taxi.domain.Operator;
import taxi.domain.Role;
import taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private OperatorDao operatorDao;

    @Autowired
    private RoleDao roleDao;

    private Role USER;

    @Transactional
    @Override
    public boolean register(String login, String individualTaxpayerNumber, String password) throws AuthorizationException {
        System.out.println("in register service");
        List<Role> roleList = roleDao.findAll();
        if (roleList.size() == 0){
            Role adminRole = new Role("Administrator", true, true);
            Role userRole = new Role("User", false, false);
            roleDao.create(adminRole);
            roleDao.create(userRole);
            USER = adminRole;
        } else {
            USER = roleDao.read("User");
        }

        /*if (USER == null) {
            System.out.println("in check for USER on null");
            USER = roleDao.read("user");
        }
        System.out.println("Role" + USER.getRoleName());*/

        LocalDateTime now = LocalDateTime.now();
        Operator operator = new Operator(login, password, Long.parseLong(individualTaxpayerNumber), "", now, false, 0L, USER);

        try {
            operatorDao.create(operator);
        } catch (Exception exception) {
            throw new AuthorizationException("Login not unique");
        }
        return true;
    }
    @Transactional
    @Override
    public boolean changePassword(String login, String password) throws AuthorizationException {
        /*Operator operator = operatorDao.read(login);
        if (!passwordTypoCheck(password, false))
            throw new AuthorizationException("Password not correct");
        if (password.equals(operator.getPassword()))
            throw new AuthorizationException("Password can't be same as previous");
        operator.setPassword(password);
        operator.setLastPasswordChangeDate(LocalDateTime.now());
        operatorDao.update(operator);*/
        return true;
    }
}
