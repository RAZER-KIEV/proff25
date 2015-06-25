package hw7.notes.dao;

import hw7.notes.domain.CPU;
import java.util.List;

public interface CPUDao {
    Long create(CPU processor);
    CPU read(Long ig);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
