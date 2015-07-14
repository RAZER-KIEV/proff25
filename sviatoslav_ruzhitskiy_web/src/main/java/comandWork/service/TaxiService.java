package comandWork.service;

import java.util.List;

/**
 * Created by RAZER on 14.07.2015.
 */
public interface TaxiService {
    boolean authenticate(String login, String pass);

    List findAll();

}
