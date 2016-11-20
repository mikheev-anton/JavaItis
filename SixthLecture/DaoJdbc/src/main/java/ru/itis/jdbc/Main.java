package ru.itis.jdbc;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.DaoFactory;
import ru.itis.jdbc.factory.ServiceFactory;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = ServiceFactory.getInstance().getUserService();
        User user = userService.getUser(1);
        User user1 = userService.getUser(2);
        User user2 = userService.getUser(3);
        User user3 = userService.getUser(4);
        User user4 = userService.getUser(5);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
    }
}
