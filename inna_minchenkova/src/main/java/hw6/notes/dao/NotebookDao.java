package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Inna on 19.06.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read (Long id);
    boolean update (Notebook notebook);
    boolean delete (Notebook notebook);
    List<Notebook> findAll();

}
