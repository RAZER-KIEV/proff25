package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by ПК on 26.06.2015.
 */
public interface NotebookService {
    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
}
