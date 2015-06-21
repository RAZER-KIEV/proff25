package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;

/**
 * Created by HP on 20.06.2015.
 */
public class Menu {
    public static void main(String[] args) {
        HibernateUtil hiberUtil = new HibernateUtil();
        hiberUtil.initialize();
        NotebookServiceImpl noteServise = new NotebookServiceImpl(hiberUtil.getFactory());
        noteServise.changePrice(21L, 900.99);
noteServise.changeSerialVendor(5L, "1290-Me", "Ivanov");

hiberUtil.factoryClose();

    }
}
