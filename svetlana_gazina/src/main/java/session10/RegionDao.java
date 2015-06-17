package session10;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Sveta on 6/16/2015.
 */
public interface RegionDao {
    public Long create(Region region);
    public void update(Region region);
    public Region read (Long id);
    public void delete (Region region);

    public List<Region> findAll();
    public List<Region> findByName(String name);
    public List<Region> findByIdRange(Long idFrom, Long idTo);
    public List<Region[]> findByPortions(Integer beginFrom, Integer PortionSize);

}