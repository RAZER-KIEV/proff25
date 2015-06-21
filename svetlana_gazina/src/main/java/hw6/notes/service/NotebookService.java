package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Sveta on 6/21/2015.
 */
public interface NotebookService {
    public Long add(Notebook notebook);
    public List<Notebook> findAll();
    public void changePrice(Long id, double price);
    public void changeSerialVendor(Long id, String serial, String vendor);
    public boolean delete(Long id);

}
