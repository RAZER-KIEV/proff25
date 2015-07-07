package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 * Long create(CPU cpu)
 * CPU read(Long id)
 * boolean update(CPU cpu)
 * boolean delete(CPU cpu)
 * List findAll()
 */
public interface CPUDao {

    Long create(CPU cpu);

    CPU read(Long id);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List findAll();

}
