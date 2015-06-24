package hw7.notes.dao;


import hw7.notes.domain.Memory;
import java.util.List;

public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List getMemoriesPorced(int start, int size);
    List findAll();
}
