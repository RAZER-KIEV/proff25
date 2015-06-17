package hw6;

import java.util.Date;

/**
 * Created by ivan on 17.06.15.
 */
public interface NotebookService {

    boolean addNotebook(Long serial, String vendor, String model, Date manufactureDate, Integer price);

    void showAllNotebooks();

}
