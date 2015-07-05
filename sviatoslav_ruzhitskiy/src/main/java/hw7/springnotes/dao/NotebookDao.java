package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long ig);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();
}
