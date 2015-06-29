package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.sql.SQLException;
import java.util.List;

public interface NotebookDao {
    public Long create(Notebook ntb);

    public Notebook read(Long ig) throws SQLException;

    public boolean update(Notebook ntb);

    public boolean delete(Notebook ntb);

    public List findAll();
}
