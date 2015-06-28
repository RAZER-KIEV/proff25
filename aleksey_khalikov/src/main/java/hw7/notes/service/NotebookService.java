package hw7.notes.service;

/**
 * Created by GFalcon on 25.06.15.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);
}
