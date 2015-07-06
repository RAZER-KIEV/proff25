package hw7.notes.service;

import hw7.notes.domain.Notebook;

/**
 * Created by jax on 05.07.15.
 */
public interface NotebookService {
    Long receive(Notebook note,int amount,double price);
    Long sale(Long storeId,int amount);
}
