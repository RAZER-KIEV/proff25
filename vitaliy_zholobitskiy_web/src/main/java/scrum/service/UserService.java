package scrum.service;

public interface UserService {
    boolean authenticate(String login, String password);
}
