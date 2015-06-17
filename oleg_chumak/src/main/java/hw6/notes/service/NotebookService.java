package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by oleg on 17.06.15.
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);
    boolean delete(Long id);
}
