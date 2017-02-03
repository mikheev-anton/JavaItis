package ru.itis.jdbc.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.util.List;

@Repository
public class CarDaoHibernateImpl implements CarDao {

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
    public List<Car> findAllUserCars(int userId) {
        Session session = openSession();
        Query query = session.createQuery("from Car c where owner.id = : userId",Car.class);
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public List<Car> findAll() {
        Session session = openSession();
        Query query = session.createQuery("from Car");
        return query.list();
    }

    @Override
    public void update(Car car) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
    }

    @Override
    public void save(Car car, int userId) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        car.setOwner(new User.Builder().setId(userId).build());
        session.save(car);
        transaction.commit();
    }

    @Override
    public Car find(int id) {
        Session session = openSession();
        return session.get(Car.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        Car build = new Car.Builder().setId(id).setOwnerId(new User.Builder().build()).build();
        session.delete(build);
        transaction.commit();
    }

    @Override
    public List<Car> getCarsByCity(String userCity) {
        Session session = openSession();
        String s = "from Car c right outer join fetch c.owner u where u.city = :city";
        Query query = session.createQuery(s, Car.class);
        query.setParameter("city", userCity);
        return query.list();
    }
}
