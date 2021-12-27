package by.tms.crudspring.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryOperationDao implements OperationDao{

    private final Map<String, List<String>> historyList;

    public InMemoryOperationDao(Map<String, List<String>> historyList) {
        this.historyList = historyList;
    }

    @Override
    public void addOperation(String k, String operation){
        List<String> temp = historyList.get(k);
        if(temp==null){
            temp=new ArrayList<>();
            temp.add(operation);
            historyList.put(k,temp);
        }else {
            historyList.get(k).add(operation);
        }
    }

    @Override
    public List<String>getAllHistory(String k){
        return historyList.get(k);
    }

    @Override
    public void deleteHistory(String k){
        historyList.remove(k);
    }
}
