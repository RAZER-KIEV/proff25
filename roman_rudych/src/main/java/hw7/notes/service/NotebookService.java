package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by Роман on 25.06.2015.
 */
public interface NotebookService {
    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
    Long add(Notebook notebook);
}
