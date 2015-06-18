package hw6.notes;

import java.util.List;

/**
 * Created by HP on 18.06.2015.
 */
public interface NotebookDao {
    //МЕТОДЫ
    void initialize();

    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List findAll();
}
