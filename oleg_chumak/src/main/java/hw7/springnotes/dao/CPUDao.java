package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;

import java.util.List;

/**
 * Created by oleg on 24.06.15.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long ig);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
