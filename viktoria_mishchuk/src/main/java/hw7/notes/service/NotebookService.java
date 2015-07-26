package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by viktoria
 * Project:.hw7.notes.service
 */
public interface NotebookService {

    Long receive(Notebook note, int amount, double price);
    Long sale(Long storeId, int amount);
}
