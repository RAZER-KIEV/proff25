package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 05.07.15.
 */
@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired(required = true)
    private NotebookDaoImpl notebookDao;
    @Autowired(required = true)
    private StoreDaoImpl storeDao;
    @Autowired(required = true)
    private CPUDaoImpl cpuDao;
    @Autowired(required = true)
    private MemoryDaoImpl memoryDao;
    @Autowired(required = true)
    private VendorDaoImpl vendorDao;
    @Autowired(required = true)
    private SalesDaoImpl salesDao;

    public NotebookServiceImpl() {

    }

    public NotebookServiceImpl(NotebookDaoImpl notebookDao, StoreDaoImpl storeDao, CPUDaoImpl cpuDao,
                               MemoryDaoImpl memoryDao, VendorDaoImpl vendorDao) {
        this.notebookDao = notebookDao;
        this.storeDao = storeDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.vendorDao = vendorDao;
    }

    public NotebookDaoImpl getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDaoImpl notebookDao) {
        this.notebookDao = notebookDao;
    }

    public StoreDaoImpl getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDaoImpl storeDao) {
        this.storeDao = storeDao;
    }

    public CPUDaoImpl getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDaoImpl cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDaoImpl getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDaoImpl memoryDao) {
        this.memoryDao = memoryDao;
    }

    public VendorDaoImpl getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDaoImpl vendorDao) {
        this.vendorDao = vendorDao;
    }

    public SalesDaoImpl getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    @Override
    public Long receive(Long id, int amount, double price) {
        Notebook note = notebookDao.read(id);
        return storeDao.create(new Store(note, amount, price));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
    }

    @Override
    public Long createCPU(CPU cpu) {
        return null;
    }

    @Override
    public Long createMemory(Memory memory) {
        return null;
    }

    @Override
    public Long createVendor(Vendor vendor) {
        return null;
    }

    @Override
    public Long createNotebook(Notebook notebook) {
        return null;
    }

    @Override
    public Vendor getVendor(Long id) {
        return null;
    }

    @Override
    public CPU getCPU(Long id) {
        return null;
    }

    @Override
    public Memory getMemory(Long id) {
        return null;
    }

    @Override
    public Notebook getNotebook(Long id) {
        return null;
    }

    @Override
    public Store getStore(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByPortion(int size) {
        return notebookDao.getPortionOfNotebooks(0, size);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksGtAmount(int amount) {
        return storeDao.getNotebooksGtAmount(amount);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return notebookDao.getNotebooksByCpuVendor(cpuVendor);
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksFromStore() {
        return storeDao.getNotebooksFromStore();
    }

    @Override
    public Map getNotebooksStorePresent1() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List getNotebooksStorePresent() {
        return storeDao.getNotebooksFromStore();
    }

    @Override
    public Map getSalesByDays() {
        return salesDao.getSalesByDays();
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        if (amount <= 0 || store.getCount() < amount) {
            throw new IllegalArgumentException("ERROR: input parameter 'amount' must be correct.");
        }
        store.setCount(store.getCount() - amount);
        return storeDao.update(store);
    }

    public static void main(String[] args) {
        System.out.println(new NotebookServiceImpl().getCpuDao());
    }
}
