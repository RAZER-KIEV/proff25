package hw6.notes.service;

import hw6.notes.domain.Notebook;
import java.util.List;


public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
}
