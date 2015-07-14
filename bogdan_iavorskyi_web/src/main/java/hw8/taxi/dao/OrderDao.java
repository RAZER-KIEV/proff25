package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    void update(Order order);
    void delete(Order order);
    List listInRangeOfAmount(Long from, Long to);
    List listChunk(int startPoint, int chunkSize);
    long getListSize();
}
