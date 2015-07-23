package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan on 21.07.15.
 */

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return false;
    }

}
