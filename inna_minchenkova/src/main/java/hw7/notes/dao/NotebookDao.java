package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface NotebookDao {
    public Long create(Notebook notebook);
    public Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    public List<Notebook> findAll();
}
