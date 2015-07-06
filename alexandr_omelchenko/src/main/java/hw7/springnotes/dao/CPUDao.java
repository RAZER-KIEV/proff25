package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import java.util.List;

public interface CPUDao {
    Long create(CPU processor);
    CPU read(Long ig);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
