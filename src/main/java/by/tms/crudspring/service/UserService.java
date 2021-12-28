package by.tms.crudspring.service;


import by.tms.crudspring.dao.HibernateUserDao;
import by.tms.crudspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private HibernateUserDao userDao;


    public boolean save(String name, String username, String password) {
        User user= new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        if(userDao.findByUsername(user.getUsername()) ==null){
            userDao.save(user);
            return true;
        }else {
            return false;
        }
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    private List<User> findAll(){
        return userDao.findAll();
    }

    public void deleteUser(User user){
        userDao.deleteUser(user);
    }
}
