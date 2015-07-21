package scrum.service;

import scrum.domain.User;

import java.util.List;

/**
 * Created by HP on 14.07.2015.
 */
public interface TaxiService {
//    public Taxi read(Long id);
  //  public Long create(Taxi taxi);
    public boolean update();
    public boolean delete();
 //   public List getTaxiList();

    public User read(Long id);
    public Long create(User user);
    public boolean update(User user);
    public boolean delete(User user);
    public List getTaxiList();

}
