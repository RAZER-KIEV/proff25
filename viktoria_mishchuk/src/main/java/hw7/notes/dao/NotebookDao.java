package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public interface NotebookDao {

    Long create(Notebook notebook);
    Notebook read(Long ig);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();

}
