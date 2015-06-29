package session10;

import javax.swing.plaf.synth.Region;
import java.util.List;

/**
 * Created by Віктор on 6/16/2015.
 */
public class RegionDaoHibernateImpl implements RegionDAO {
    public Long id;
    public Region region;
    public List<Region> listAll;
    public List<Long> listOfRegionsId;
    public List<Region> listOfRegions;


    public Long create(Region region) {
        return id;
    }

    public Region read(Long id) {
        return region;
    }

    public void update(Region transientRegion) {

    }

    public void delit(Region persistentRegion) {

    }

    public List<Region> findAll() {
        return listAll;
    }

    public List<Long> findRegion(Region region) {
        return listOfRegionsId;
    }

    public List<Region> findId(Long id1, Long id2) {
        return listOfRegions;
    }
}
