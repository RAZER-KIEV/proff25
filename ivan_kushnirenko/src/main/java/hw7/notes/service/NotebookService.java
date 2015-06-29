package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by ivan on 24.06.15.
 */
public interface NotebookService {

    Long receive(Notebook note, int amount, double price);

    Long sale(Long storeId, int amount);

}
