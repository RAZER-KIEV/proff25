package scrum.service;

import scrum.domain.Taxi;
import scrum.domain.User;
import java.util.List;

/**
 * Created by HP on 14.07.2015.
 */
public interface TaxiService {
    public Taxi readTaxi(Long id);
    public Long createTaxi(Taxi taxi);
    public boolean updateTaxi();
    public boolean deleteTaxi();
    public List getTaxiList();

    public User readUser(Long id);
    public Long createUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public List getUserList();

}
