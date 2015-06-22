package hw6.notes.service;

//Created on 18.06.15.

import hw6.notes.domain.Notebook;

import java.util.List;

public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
    void closeFactory();
}
