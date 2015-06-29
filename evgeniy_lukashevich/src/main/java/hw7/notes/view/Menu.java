package hw7.notes.view;

import hw6.notes.util.HibernateUtil;
import hw7.notes.dao.*;
import hw7.notes.domain.*;
import hw7.notes.service.*;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Menu {
    public static void main (String[] args) {
        StoreDaoImpl storeDao = new StoreDaoImpl(HibernateUtil.connect());
        Store store = storeDao.read(5L);
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        notebookService.removeFromStore(store, 4);
    }
}
