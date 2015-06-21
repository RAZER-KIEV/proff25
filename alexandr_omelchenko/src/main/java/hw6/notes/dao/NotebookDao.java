package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by HP on 18.06.2015.
 */
public interface NotebookDao {
    //МЕТОДЫ
    SessionFactory initialize();

    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List findAll();
}
