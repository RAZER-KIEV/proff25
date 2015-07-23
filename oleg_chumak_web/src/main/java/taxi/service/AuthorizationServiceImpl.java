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
    private OperatorDao dao;

    @Autowired
    private RoleDao roleDao;

    private Role USER;

    private static final List<Character> NUMBERS = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    private static final List<Character> LOWERCASE_LETTERS = Arrays.asList('q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m');
    private static final List<Character> UPPERCASE_LETTERS = Arrays.asList('Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M');

    @Transactional
    @Override
    public boolean register(String login, String individualTaxpayerNumber, String password) throws AuthorizationException {
/*
этот IF вываливает ошибку Something bad: Provided id of the wrong type for
class taxi.domain.Client. Expected: class java.lang.Long, got class java.lang.String
вероятно, потому что у некоторых из нас таблица Role - пустая.
для начала, нужно написать проверку, что база запускается на сервере в первый раз (т.е. таблица
Role пустая и тогда создавать две роли админа и юзера. Только после этого и можно использовать этот If
        if (USER == null) {
            USER = roleDao.read("user");
        }
*/
        if (!loginTypoCheck(login, false))
            throw new AuthorizationException("Login not correct");
        if (!passwordTypoCheck(password, false))
            throw new AuthorizationException("Password not correct");

        // здесь не понятно, что с чем сравнивается, возможно Богдан в jsp которая делает регистрацию
        // забыл добавить еще одно поле для проверки individualTaxpayerNumber
 /*       if (!individualTaxpayerNumberTypoCheck(individualTaxpayerNumber, false))
            throw new AuthorizationException(("Individual taxpayer number not correct"));*/
        LocalDateTime now = LocalDateTime.now();
        Operator operator = new Operator(login, password, Long.parseLong(individualTaxpayerNumber), "", now, false, 0L, USER);

        try {
            dao.create(operator);
        } catch (Exception exception) {
            throw new AuthorizationException("Login not unique");
        }
        return true;
    }

    @Transactional
    @Override
    public boolean changePassword(String login, String password) throws AuthorizationException {
        Operator operator = dao.read(login);
        if (!passwordTypoCheck(password, false))
            throw new AuthorizationException("Password not correct");
        if (password.equals(operator.getPassword()))
            throw new AuthorizationException("Password can't be same as previous");
        operator.setPassword(password);
        operator.setLastPasswordChangeDate(LocalDateTime.now());
        dao.update(operator);
        return true;
    }

    private boolean loginTypoCheck(String login, boolean regex) {
        if (regex) {
            return loginTypoCheckRegex(login);
        }

        return loginTypoCheckNoRegex(login);
    }

    private boolean loginTypoCheckNoRegex(String login) {
        if (login.length() < 4 || login.indexOf(" ") != -1)
            return false;

        return true;
    }

    private boolean loginTypoCheckRegex(String login) {
        return false;
    }

    private boolean passwordTypoCheck(String password, boolean regex) {
        if (regex) {
            return passwordTypoCheckRegex(password);
        }

        return passwordTypoCheckNoRegex(password);
    }

    private boolean passwordTypoCheckNoRegex(String password) {
        if (password.length() < 8 || password.indexOf(" ") != -1)
            return false;
        if (!checkIfTextContainsCharacters(NUMBERS, password))
            return false;
        if (!checkIfTextContainsCharacters(LOWERCASE_LETTERS, password))
            return false;
        if (!checkIfTextContainsCharacters(UPPERCASE_LETTERS, password))
            return false;
        return true;
    }

    /**
     * @return true if text contains at last one char from characters list
     */
    private boolean checkIfTextContainsCharacters(List<Character> characters, String text) {
        for (int i = 0; i < text.length(); i++) {
            if (characters.contains(Character.valueOf(text.charAt(i))))
                return true;
        }
        return false;
    }

    /**
     * @return true if all text chars are from characters list
     */
    private boolean checkIfAllTextContainsCharacters(List<Character> characters, String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!characters.contains(Character.valueOf(text.charAt(i))))
                return false;
        }
        return true;
    }

    private boolean passwordTypoCheckRegex(String password) {
        return false;
    }

    private boolean individualTaxpayerNumberTypoCheck(String individualTaxpayerNumber, boolean regex) {
        if (regex) {
            return individualTaxpayerNumberTypoCheckRegex(individualTaxpayerNumber);
        }
        return individualTaxpayerNumberTypoCheckNoRegex(individualTaxpayerNumber);
    }

    private boolean individualTaxpayerNumberTypoCheckNoRegex(String individualTaxpayerNumber) {
        if (individualTaxpayerNumber.length() != 10 || individualTaxpayerNumber.indexOf(" ") != -1)
            return false;
        if (!checkIfAllTextContainsCharacters(NUMBERS, individualTaxpayerNumber))
            return false;
        return true;
    }

    private boolean individualTaxpayerNumberTypoCheckRegex(String individualTaxpayerNumber) {
        return false;
    }
}
