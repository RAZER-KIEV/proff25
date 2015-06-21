package session10;



import java.util.List;


/**
 * Created by just1ce on 16.06.2015.
 */
public interface RegionDao {
    Long create(Region reg);
    Region read(Long id);
    void update(Region reg);
    void delete(Region reg);
    List<Region> findAll();
    List<Region> findForName(String name);
    List<Region> findForIndeces(int start,int end);
    List<Region> getPorcies(int count_el);
}
