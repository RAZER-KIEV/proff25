package home.dao;

import home.domain.MyEvent;

import java.util.Date;
import java.util.List;

/**
 * Created by RAZER on 2/18/2016.
 */
public interface EventDao {
    Long create(MyEvent event);
    MyEvent read(Long id);
    boolean update(MyEvent event);
    boolean delete(MyEvent event);
    List findAll();
    List findAllbyNetwork(Long networkId);
    List getLastNews(Date lastOnline, Long myId, Long myNetwork);
}
