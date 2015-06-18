package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by ПК on 18.06.2015.
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();

}
