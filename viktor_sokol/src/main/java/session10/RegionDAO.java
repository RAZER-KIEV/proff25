package session10;

import javax.swing.plaf.synth.Region;
import java.util.List;

/**
 * Created by Віктор on 6/16/2015.
 */
public interface RegionDAO {
    Long create(Region region);

    Region read(Long id);

    void update(Region transientRegion);

    void delit(Region persistentRegion);

    List<Region> findAll();

    List<Long> findRegion(Region region);

    List<Region> findId(Long id1, Long id2);
}
