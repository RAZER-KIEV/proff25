package lection05.DAO;

import java.util.List;

public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
    List<Region> find(String name);
    List<Region> findID(Long startID, Long finishID);
}
