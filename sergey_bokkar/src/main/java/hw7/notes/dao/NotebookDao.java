package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public interface NotebookDao {

    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();

}
