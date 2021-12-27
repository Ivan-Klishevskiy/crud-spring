package by.tms.crudspring.service;


import by.tms.crudspring.dao.InMemoryUserDao;
import by.tms.crudspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private InMemoryUserDao InMemoryUserDao;


    public boolean save(String name, String username, String password) {
        User user= new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        if(InMemoryUserDao.findByUsername(user.getUsername()) ==null){
            InMemoryUserDao.save(user);
            return true;
        }else {
            return false;
        }
    }

    public User findByUsername(String username){
        return InMemoryUserDao.findByUsername(username);
    }

    private List<User> findAll(){
        return InMemoryUserDao.findAll();
    }

    public void deleteUser(User user){
        InMemoryUserDao.deleteUser(user);
    }
}
