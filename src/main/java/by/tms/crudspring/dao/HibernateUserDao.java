package by.tms.crudspring.dao;

import by.tms.crudspring.entity.User;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernateUserDao implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where username = :username", User.class);
        try {
            query.setParameter("username", username);
            User res = query.getSingleResult();
            session.close();
            return res;
        }catch (NoResultException ignored){
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        try {
            return query.getResultList();
        }catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.delete(user);
        session.close();
    }


    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }
}
