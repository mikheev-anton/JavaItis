package ru.itis.jdbc.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.User;

import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public List<User> findAll() {
        Session session = openSession();
        Query query = session.createQuery("select u from User u");
        return query.list();
    }

    @Override
    public void update(User user) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    @Override
    public void save(User user) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public User find(int id) {
        Session session = openSession();
        return session.get(User.class, id);
    }

    @Override
    public User find(String email) {
        Session session = openSession();
        String s = "select u from User u where u.email = :email";
        Query query = session.createQuery(s, User.class);
        query.setParameter("email", email);
        return (User)query.uniqueResult();
    }

    @Override
    public void delete(int id) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        User mockForDel = new User.Builder().setId(id).build();
        session.delete(mockForDel);
        transaction.commit();
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        Session session = openSession();
        Query query = session.createQuery("select u from User u where u.city = : city",User.class);
        query.setParameter("city", cityName);
        return query.list();
    }

    @Override
    public boolean isExist(String email) {
        Session session = openSession();
        Query query = session.createQuery("select count(u) from User u where u.email = : email", User.class);
        query.setParameter("email", email);
        Object o = query.uniqueResult();
        return (Integer)o > 0;
    }
}
