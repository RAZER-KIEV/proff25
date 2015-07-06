package hw7.notes.dao;

import hw7.notes.domain.Memory;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface MemoryDao {
    public Long create(Memory memory);
    public Memory read(Long id);
    public boolean update(Memory memory);
    public boolean delete(Memory memory);
    public List<Memory> findAll();
}
