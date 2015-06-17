package hw6;

import java.util.List;
/**
 * Created by ivan on 17.06.15.
 */
public interface NotebookDao {

    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List<Notebook> findAll();

}
