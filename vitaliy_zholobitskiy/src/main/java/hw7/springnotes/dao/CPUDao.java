package hw7.springnotes.dao;



import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
public interface CPUDao {
    Long create(hw7.springnotes.domain.CPU cpu);
    hw7.springnotes.domain.CPU read(Long id);
    boolean update(hw7.springnotes.domain.CPU cpu);
    boolean delete(hw7.springnotes.domain.CPU cpu);
    List findAll();
}
