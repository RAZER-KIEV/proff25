package hw7.notes.dao;

import hw7.notes.domain.CPU;
import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public interface CPUDao {
    Long create(CPU obj);
    CPU read(Long ig);
    boolean update(CPU obj);
    boolean delete(CPU obj);
    List<CPU> findAll();
}
