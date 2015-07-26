package session10.dao;

import session10.Region;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session10
 */
public interface DaoRegion {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete (Region region);
    List<Region> findAll();
    List<Region> findRegionByName(Region region);
    List<Region> findRegionById(Long id1, Long id2);
    List<Region> RegionPortion(int id, int size);
}
