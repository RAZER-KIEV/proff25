package session10;

import java.util.List;

/**
 * Created by george on 16.06.15.
 */
public interface ClienDao {

    Long create(Client user);
    Client read(Long id);
    void update();
    void delite();
    List<Client> findAll();
    int findeIdByName(String name);
    List<Client> findNameByIdDiapazone(int min, int max);
}
