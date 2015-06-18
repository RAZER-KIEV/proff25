package week_lesson10;

import week5_lesson9.Region;

import java.util.List;

/**
 * Created by HP on 16.06.2015.
 */
public interface RegionDao {
    public Long create(Region region);
    public Region read(Region region);
    public Long update(Region region);
    public Long delete(Region region);
    public List<Region> findAll();
    public List<Region> findHonyGT(Long amount);
    public List<Region> findDiapazon(Long amount, Long last);
    public void printBy(int kol, int start);
}
