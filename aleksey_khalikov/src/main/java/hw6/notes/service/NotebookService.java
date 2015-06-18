package hw6.notes.service;

import hw6.notes.domain.Notebook;
import java.util.List;

/**
 * Created by GFalcon on 18.06.15.
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List findAll();
}
