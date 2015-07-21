package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${number_of_tries_to_log_in}")
    private int legalNumberOfBadTriesToLogIn;

    @Value("30")
    private long passwordValidTime; // in days

    @Autowired
    private OperatorDao dao;

    private static final String UNSUCCESSFUL_REGULAR = "Login or password incorrect";
    private static final String UNSUCCESSFUL_BLOCKED = "Account is blocked. Please, contact with administrator";
    private static final String UNSUCCESSFUL_PASSWORD_EXPIRED = "Password expired";

    public AuthenticationServiceImpl() {
    }

    @Transactional
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        Operator operator;
        if ((operator = dao.read(login)) == null)
            throw new AuthenticationException(UNSUCCESSFUL_REGULAR);

        if (operator.getBlocked())
            throw new AuthenticationException(UNSUCCESSFUL_BLOCKED);

        int unsuccessfulLoginTries = operator.getUnsuccessfulLoginTries();

        if (!operator.getPassword().equals(pass)) {
            String message;
            if (unsuccessfulLoginTries > legalNumberOfBadTriesToLogIn) {
                operator.setUnsuccessfulLoginTries(0);
                operator.setBlocked(true);
                message = UNSUCCESSFUL_BLOCKED;
            } else {
                operator.setUnsuccessfulLoginTries(++unsuccessfulLoginTries);
                message = UNSUCCESSFUL_REGULAR;
            }
            dao.update(operator);
            throw new AuthenticationException(message);
        }

        if (unsuccessfulLoginTries != 0) {
            operator.setUnsuccessfulLoginTries(0);
            dao.update(operator);
        }

        if (checkIfPasswordExpired(operator))
            throw new AuthenticationException(UNSUCCESSFUL_PASSWORD_EXPIRED);

        return true;
    }

    @Transactional
    @Override
    public void doBadWork(String login, int days) {
        Operator operator = dao.read(login);
        LocalDateTime time = LocalDateTime.now();
        time = time.minusDays(days);
        operator.setLastPasswordChangeDate(time);
        dao.update(operator);
    }

    private boolean checkIfPasswordExpired(Operator operator) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastPassChangeTime = operator.getLastPasswordChangeDate();
        if ( lastPassChangeTime.plusDays(passwordValidTime).compareTo(now) > 0 ) {
            return false;
        }
        return true;
    }

    public long getPasswordValidTime() {
        return passwordValidTime;
    }

    public void setPasswordValidTime(long passwordValidTime) {
        if (passwordValidTime < 1)
            throw new IllegalArgumentException("Bad password valid time: " + passwordValidTime);
        this.passwordValidTime = passwordValidTime;
    }

    public static String getUnsuccessfulPasswordExpired() {
        return UNSUCCESSFUL_PASSWORD_EXPIRED;
    }
}
