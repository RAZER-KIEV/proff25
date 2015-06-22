package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Sveta on 6/18/2015.
 */
public interface NotebookDao {
    public Long create(Notebook ntb);
    public Notebook read(Long ig);
    public boolean update(Notebook ntb);
    public boolean delete(Notebook ntb);
    public List<Notebook> findAll();
}
