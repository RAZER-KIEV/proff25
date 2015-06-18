package hw6;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 17.06.15.
 */
public interface NotebookService {
    /**
     - Добавить новый ноутбук
     - Показать список ноутбуков (включая порядковый номер id)
     - Удалить ноутбук по id
     - Изменить цену ноутбука по id
     - Изменить серийный номер и производителя по id
     - Удалить ноутбуки по названию модели
     - Получить ноутбуки по производителю
     - Получить ноутбуки по цене и году выпуска
     - Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
     */



    Long addNotebook(Long serial, String vendor, String model, Date manufactureDate, Integer price);

    List<Notebook> showAllNotebooks();

    String dellById(Long id);

    String setPriceById(Long id, Integer Price);

    String setSerialAndVendorById(Long id, Long serial, String Vendor);

    String dellByModel(String model);

    List<Notebook> getByVendor(String vendor);

    List<Notebook> getByPriceAndDate(Integer price, Date manufactureDate);

    List<Notebook> getByPriceWithVendorAndDate();


}
