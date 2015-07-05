package hw7.notes.dao;

import hw7.notes.domain.CPU;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    Boolean update(CPU cpu);
    Boolean delete(CPU cpu);
    List findAll();
}
