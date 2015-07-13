package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private OperatorDao operatorDao;

    public ClientServiceImpl() {
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        return false;
    }

    @Override
    public boolean createClientWithOperator(String operatorLogin, String name,
                                            String surname, String phone, String address)
                                            throws ClientException {

        Operator operator = operatorDao.read(operatorLogin);
        Client client = new Client(name, surname, phone, address, 0L, null, operator);
        clientDao.create(client);
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List showAllClients() {
        return clientDao.listAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsByPortion(int portionSize) {
        if (portionSize < 1)
            throw new IllegalArgumentException();

        int size = (int) clientDao.getListSize();
        List clients = new LinkedList<>();
        for (int i = 0; i < size; i+=portionSize ) {
            clients.addAll(clientDao.listChunkOfClients(i, portionSize));
            clients.add(null);
        }
        return clients;
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsGtSum(int sum) {
        return clientDao.listClientsGtSum(sum);
    }

    @Transactional(readOnly = true)
    @Override
    public List showClientsLastMonth() {
        return clientDao.listClientsLastMonth();
    }
}
