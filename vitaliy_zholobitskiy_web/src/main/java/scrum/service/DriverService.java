package scrum.service;

import org.h2.engine.User;
import scrum.domain.Driver;

import java.util.List;

/**
 * Created by Віктор on 7/14/2015.
 */
public interface DriverService {
    public boolean autetifiction(String login, String pasword);
    public List<Driver> finedAll();
}
