package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import java.util.List;


public interface NotebookDao {
    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List findAll();
}
