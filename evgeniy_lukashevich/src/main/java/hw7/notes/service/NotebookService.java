package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public interface NotebookService {
    Long receive(Notebook note, int amount, double price); //Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
    Long sale(Long storeId, int amount); // Продать указанное количество ноутбуков со склада(id склада, количество)
    boolean updateCPU(CPU cpu); // Изменить процессор
    boolean updateMemory(Memory memory); // Изменить память
    boolean updateVendor(Vendor vendor); // Изменить производителя
    boolean updateNotebook(Notebook notebook); // Изменить тип ноутбука
    boolean removeFromStore(Store store, int amount); // Списать со склад ноутбуки (ключ, количество)
    List getNotebooksByPortion(int size); // Показать все ноутбуки на складе (пользователь указывает размер порции)
    List getNotebooksGtAmount(int amount); // Показать все ноутбуки которых больше указанного количества
    List getNotebooksByCpuVendor(Vendor cpuVendor); // Показать все ноутбуки по указанному имени производителя процессора
    List getNotebooksFromStore(); // Показать все ноутбуки на складе
    List getNotebooksStorePresent(); // Показать типы ноутбуков, оставшиеся на складе по каждому производителю
    Map getSalesByDays(); // Получить объем продаж ноутбуков в среднем за день
}
