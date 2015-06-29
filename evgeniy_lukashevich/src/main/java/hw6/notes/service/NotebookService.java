package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Jeckgehor on 20.06.2015.
 */
public interface NotebookService {
    Long add(Notebook notebook); // Добавить новый ноутбук
    List<Notebook> findAll(); // Показать список ноутбуков (включая порядковый номер id)
    void changePrice(Long id, double price);// Изменить цену ноутбука по id
    void changeSerialVendor(Long id, String serial, String vendor); // Изменить серийный номер и производителя по id
    boolean delete(Long id); // Удалить ноутбук по id
    boolean deleteByModel(String model); // Удалить ноутбуки по названию модели
    List findByVendor(String vendor); // Получить ноутбуки по производителю
    List findByPriceManufDate(Double price, Date date); // Получить ноутбуки по цене и году выпуска
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor); // Получить ноутбуки
    // по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
}
