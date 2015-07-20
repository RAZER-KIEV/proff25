package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;
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

    private static final List<Character> NUMBERS = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    private static final List<Character> LOWERCASE_LETTERS = Arrays.asList('q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m');
    private static final List<Character> UPPERCASE_LETTERS = Arrays.asList('Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M');

    @Transactional
    @Override
    public boolean register(String login, String individualTaxpayerNumber, String password) throws AuthorizationException {
        if (!loginTypoCheck(login, false))
            throw new AuthorizationException("Login not correct");
        if (!passwordTypoCheck(password, false))
            throw new AuthorizationException("Password not correct");
        if (!individualTaxpayerNumberTypoCheck(individualTaxpayerNumber, false))
            throw new AuthorizationException(("Individual taxpayer number not correct"));
        LocalDateTime now = LocalDateTime.now();
        Operator operator = new Operator(login, password, Long.parseLong(individualTaxpayerNumber), now, now, false, 0);
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
