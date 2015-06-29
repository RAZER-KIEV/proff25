package hw7.notes.dao;



import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();
}
