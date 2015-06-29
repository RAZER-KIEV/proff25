package session10;

/**
 * Created by Jeckgehor on 16.06.2015.
 */
public interface RegionDao {
    Long create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
}