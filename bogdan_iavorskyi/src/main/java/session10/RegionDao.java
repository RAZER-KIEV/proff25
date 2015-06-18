package session10;

import java.util.List;

/*
 *
 */
public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
    List<Region> findByName(String regionName);
    List<Region> findByIdRange(Long beginId, Long endId);
    void partialShow(Long start, Long quantity);
    Long getCount();
}
