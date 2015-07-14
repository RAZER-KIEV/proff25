package hw6.notes.service;

import hw6.notes.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl dao;

    public NotebookServiceImpl(){
    }

    public NotebookServiceImpl(SessionFactory factory) {
        dao = new NotebookDaoImpl(factory);
    }

    public void createDao(SessionFactory factory) {

        dao = new NotebookDaoImpl(factory);
    }

    @Override
    public Long add(Notebook notebook) {
        return dao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return dao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = dao.read(id);
        notebook.setPrice(price);
        dao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = dao.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        dao.update(notebook);
    }

    @Override
    public boolean delete(Long id) {
        Notebook notebook = dao.read(id);
        return dao.delete(notebook);
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> notebooks = dao.findByModel(model);
        boolean result = true;
        for(Notebook notebook:notebooks){
            result = result && dao.delete(notebook);
        }
        return result;
    }

    @Override
    public boolean deleteByVendor(String vendor) {
        List<Notebook> notebooks = dao.findByVendor(vendor);
        boolean result = true;
        for(Notebook notebook:notebooks){
            result = result && dao.delete(notebook);
        }
        return result;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return dao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return dao.findByPriceManufDate(price,date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return dao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }
}
