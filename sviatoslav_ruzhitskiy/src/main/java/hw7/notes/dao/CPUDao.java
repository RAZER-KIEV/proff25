package hw7.notes.dao;

import hw7.notes.domain.CPU;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long ig);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
