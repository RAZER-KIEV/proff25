package hw8.taxi.service;

import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
public class ClientServiceImpl implements ClientService{
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        return false;
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return null;
    }

    @Override
    public List showClientsGtSum(int sum) {
        return null;
    }

    @Override
    public List showClientsLastMonth() {
        return null;
    }
}
