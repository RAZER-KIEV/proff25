package session10.dao;

import session10.Region;

import java.util.List;

/**
 * Created by RAZER on 16.06.2015.
 */
public interface ReginDao {
    public Long create(Region reg);
    public Region read(Long id);
    public void update(Region newOne);
    public void delete(Region region);
    public List<Region> findAll();
    public Region findRegById(Long id);
    public Region findByName(String name);
    public List<Region> findAllby(int bigin, int size);
}
