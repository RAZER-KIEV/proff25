package hw8.taxi.service;

import hw8.taxi.IsValid;
import hw8.taxi.UserRole;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.exception.OperatorEditingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private OperatorDao operatorDao;

    public AdminServiceImpl() {
    }

    public AdminServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    @Override
    public boolean update(String login, String newLogin, String password, String role, String ident, Integer countAttempts, String isBlocked) throws OperatorEditingException{
        String error="";
        if (newLogin!=null && !newLogin.isEmpty() && operatorDao.getByLogin(newLogin)!=null){
            error+="Operator with login \""+newLogin+"\" exists.<br>";
        }
        if (newLogin!=null && !newLogin.isEmpty() && !IsValid.isValidLogin(newLogin)){
            error+="Login must be at least 4 characters, must not contain spaces.<br>";
        }
        if (password!=null && !password.isEmpty() && !IsValid.isValidPassword(password)){
            error+="Password must be at least 8 characters, include upper and lowercase letters, numbers.<br>";
        }
        if (ident!=null && !ident.isEmpty() && !IsValid.isValidId(ident)){
            error+="Id was going to consist of 10 digits, must not contain letters and other characters.<br>";
        }
        if (countAttempts!=null && countAttempts<0){
            error+="Count attempts must be >= 0.<br>";
        }
        if (!error.isEmpty()){
            throw new OperatorEditingException(error);
        }
        Operator operator = operatorDao.getByLogin(login);
        if (newLogin!=null && !newLogin.isEmpty())
            operator.setLogin(newLogin);
        if (password!=null && !password.isEmpty())
            operator.setPassword(password);
        switch (role) {
            case "USER":
                operator.setRole(UserRole.USER);
                break;
            case "ADMIN":
                operator.setRole(UserRole.ADMIN);
                break;
            case "SUPERADMIN":
                operator.setRole(UserRole.SUPERADMIN);
                break;
        }
        if (ident!=null && !ident.isEmpty())
            operator.setIdnumb(ident);
        if (countAttempts!=null)
            operator.setCountWrongPass(countAttempts);
        operator.setIsBlocked(isBlocked.equals("true"));
        operator.setPassDate(new Date());
        return operatorDao.update(operator);
    }

    @Override
    public void unlockClear(String login) {
        Operator operator = operatorDao.getByLogin(login);
        operator.setIsBlocked(false);
        operator.setCountWrongPass(0);
        operatorDao.update(operator);
    }

    @Override
    public List<Operator> getUsers() {
        return operatorDao.findUsers();
    }

    @Override
    public List<Operator> getUsersAndAdmins() {
        return operatorDao.findAll();
    }
}
