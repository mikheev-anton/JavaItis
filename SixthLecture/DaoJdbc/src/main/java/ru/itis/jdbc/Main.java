package ru.itis.jdbc;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.DaoFactory;
import ru.itis.jdbc.model.Car;

public class Main {
    public static void main(String[] args) {
        CarDao carDao = DaoFactory.getInstance().getCarDao();
        System.out.println(carDao.find(2,1));
    }
}
