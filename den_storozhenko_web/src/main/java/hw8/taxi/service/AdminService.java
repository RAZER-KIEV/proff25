package hw8.taxi.service;

import hw8.taxi.exception.OperatorEditingException;
import java.util.List;

public interface AdminService {
    boolean update(String login, String newLogin, String password, String role, String ident, Integer countAttempts, String isBlocked) throws OperatorEditingException;
    void unlockClear(String login);
    List getUsers();
    List getUsersAndAdmins();
}
