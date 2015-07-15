package hw6.notes.service;

import hw6.notes.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by george on 20.06.15.
 */
public class NotebookServiceImpl implements NotebookService{
    private NotebookDaoImpl notes;

    public NotebookServiceImpl(){
    }

    public NotebookServiceImpl(SessionFactory factory) {
        notes = new NotebookDaoImpl(factory);
    }

    public void createDao(SessionFactory factory) {
        notes = new NotebookDaoImpl(factory);
    }

    @Override
    public Long add(Notebook notebook) {
        return notes.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notes.findAll();
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> list = notes.findByModel(model);
        for(Notebook note : list){
            return notes.delete(note);
        }
        return false;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notes.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notes.findByPriceManufDate(price,date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notes.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = notes.read(id);
        notebook.setPrice(price);
        notes.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = notes.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notes.update(notebook);

    }

    @Override
    public boolean delete(Long id) {
        Notebook notebook = notes.read(id);
       return notes.delete(notebook);
    }
}
