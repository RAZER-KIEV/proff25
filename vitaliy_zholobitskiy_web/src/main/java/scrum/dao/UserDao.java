package scrum.dao;

import scrum.domain.User;

import java.util.List;

/**
 * Created by Inna on 14.07.2015.
 */
public interface UserDao {
    public void createUser(User user);

    public User readClient(Long id);

    public User readByName(String name);

    public void deleteUser(User user);

    public void updateUser(User user);
    public boolean auth(String login, String pass);

}
