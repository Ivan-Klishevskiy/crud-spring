package by.tms.crudspring.dao;

import java.util.List;

public interface OperationDao {

    void addOperation(String k, String operation);

    List<String> getAllHistory(String k);

    void deleteHistory(String k);
}