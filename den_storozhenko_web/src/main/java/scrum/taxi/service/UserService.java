package scrum.taxi.service;

public interface UserService {
    boolean authenticate(String login, String password);
}
