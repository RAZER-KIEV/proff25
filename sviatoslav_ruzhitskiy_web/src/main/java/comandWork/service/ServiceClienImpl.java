package comandWork.service;

/**
 * Created by RAZER on 14.07.2015.
 */

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceClienImpl implements ServiceClient{
    @Override
    public boolean authenticate(String login, String pass) {

        return false;
    }
}
