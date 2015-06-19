package session10;

import java.util.List;

/**
 * Created by oleg on 16.06.15.
 */
public interface RegionDao {

    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
    List<Region> findByName(String name);
    List<Region> findById(Long firstId, Long lastId);
    List<Region> findAllbyPortions(Long start, Long range);
}
