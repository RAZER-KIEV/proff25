package scrum.service;

public interface UserService {
    Long getIdByName(String name);
    boolean authenticate(String login, String password);
}
