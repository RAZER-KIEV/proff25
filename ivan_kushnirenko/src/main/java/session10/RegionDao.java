package session10;

import java.util.List;
/**
 * Created by ivan on 16.06.15.
 */
public interface RegionDao {
    public Long create(Region region);
    public Region read(Long id);
    void update(Region region);
    void delete(Region region);
    public List<Region> findAll();
    public List<Region> findRegionById (Long id);
}
