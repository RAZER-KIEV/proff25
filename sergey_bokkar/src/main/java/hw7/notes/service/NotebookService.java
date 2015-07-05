package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by Well on 03.07.2015.
 */
public interface NotebookService {

    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);

}
