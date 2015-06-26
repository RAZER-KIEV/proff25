package hw7.notes.service;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
/**
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 */
public interface NotebookService {
    Long create(CPU processor);
    Long create(Memory memory);
    Long create(Vendor vendor);
    Long create(Notebook notebook);
    Long receive(Notebook note, int amount, double price);
    Long sale(Long storeId, int amount);
}