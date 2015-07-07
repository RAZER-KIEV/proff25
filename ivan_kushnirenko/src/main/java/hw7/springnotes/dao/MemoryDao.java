package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 * Long create(Memory memory)
 * Memory read(Long ig)
 * boolean update(Memory memory)
 * boolean delete(Memory memory)
 * List findAll()
 */
public interface MemoryDao {

    Long create(Memory memory);

    Memory read(Long id);

    boolean update(Memory memory);

    boolean delete(Memory memory);

    List findAll();

}
