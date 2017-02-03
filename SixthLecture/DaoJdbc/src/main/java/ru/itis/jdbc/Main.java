package ru.itis.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.jdbc.dao.hibernate.CarDaoHibernateImpl;
import ru.itis.jdbc.dao.hibernate.UserDaoHibernateImpl;
import ru.itis.jdbc.factory.ServiceFactory;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.service.CarService;
import ru.itis.jdbc.service.UserService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        UserService userService = ServiceFactory.getInstance().getUserService();
//        userService.addUser(new User.Builder().setName("Vova").build());
//
//        CarService carService = ServiceFactory.getInstance().getCarService();
//
//        carService.save(new Car.Builder().setModel("lada").build(), 1);
//
//        System.out.println(carService.findAll());
//        System.out.println(userService.getAll());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml", "spring/db-context.xml");
        CarDaoHibernateImpl bean = applicationContext.getBean(CarDaoHibernateImpl.class);
        System.out.println(bean.findAll());
        System.out.println(bean.find(3));
//        System.out.println(bean.findAllUserCars(2));
        System.out.println(bean.getCarsByCity("ЕКБ"));
        bean.delete(12);
        Car jeep = new Car.Builder()
                .setMileage(1212)
                .setModel("jeep")
                .build();
        bean.save(jeep, 4);
        jeep.setModel("NewJeep");
        bean.update(jeep);
    }
}
