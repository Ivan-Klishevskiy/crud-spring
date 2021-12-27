package by.tms.crudspring.dao;

import by.tms.crudspring.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    void deleteUser(User user);
}
