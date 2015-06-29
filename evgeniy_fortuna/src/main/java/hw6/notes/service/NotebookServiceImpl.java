package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;



public class NotebookServiceImpl implements NotebookService {
    private NotebookDao noteDao;

    public NotebookServiceImpl() {

    }

    public NotebookServiceImpl(NotebookDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public List<Notebook> findAll() {
        return noteDao.findAll();
    }

    @Override
    public Long add(Notebook notebook) {
        return noteDao.create(notebook);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = noteDao.read(id);
        notebook.setPrice(price);
        noteDao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = noteDao.read(id);
        notebook.setSerial(serial);
        notebook.setModel(vendor);
        noteDao.update(notebook);
    }

    @Override
    public boolean delete(Long id) {
        return noteDao.delete(noteDao.read(id));
    }

    @Override
    public boolean deleteByModel(String model) {
        //TODO
        return true;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        //TODO
        return null;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        //TODO
        return null;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        //TODO
        return null;
    }
}
