package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public interface NotebookService {

    Long add(Notebook notebook);
    List findAll();

}
