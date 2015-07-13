package week5_lesson10;

import week5_lesson9.Region;

import java.util.List;

/**
 * Created by HP on 16.06.2015.
 */
public interface RegionDao {
    //МЕТОДЫ
    void initialize();
    void openSession();
    void closeSession();
    void beginTransaction();
    void commit();

     Long create(Region region);
     Region read(Long id);
     Long update(Region region);
     Long delete(Region region);
     Long delete(Long id);
     List<Region> findAll();
     List<Region> findHonyGT(Long amount);
     List<Region> findDiapazon(Long amount, Long last);
     void printBy(int kol, int start);
}
