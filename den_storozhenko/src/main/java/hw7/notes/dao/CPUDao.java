package hw7.notes.dao;

import hw7.notes.domain.CPU;
import java.util.List;

public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List getCpuPorced(int start, int size);
    List findAll();
}
