package by.tms.crudspring.service;

import by.tms.crudspring.dao.InMemoryOperationDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    private final InMemoryOperationDao operationStorage;

    public OperationService(InMemoryOperationDao operationStorage) {
        this.operationStorage = operationStorage;
    }

    public void addOperation(String k, String operation){
        operationStorage.addOperation(k, operation);
    }

    public List<String> getAllHistory(String k){
        return operationStorage.getAllHistory(k);
    }

    public void deleteHistory(String k) {
        operationStorage.deleteHistory(k);
    }
}
