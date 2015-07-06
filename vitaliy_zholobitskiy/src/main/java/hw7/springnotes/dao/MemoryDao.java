package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List findAll();
}
