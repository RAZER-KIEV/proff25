package hw7.notes.dao;

import hw7.notes.domain.CPU;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface CPUDao {
    public Long create(CPU cpu);
    public CPU read(Long id);
    public boolean update(CPU cpu);
    public boolean delete(CPU cpu);
    public List<CPU> findAll();
}
