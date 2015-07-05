package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    Boolean update(Notebook notebook);
    Boolean delete(Notebook notebook);
    List findAll();
}
