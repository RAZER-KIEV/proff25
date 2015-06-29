package hw7.notes.dao;

import hw7.notes.domain.Memory;
import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long ig);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List<Memory> findAll();
}
