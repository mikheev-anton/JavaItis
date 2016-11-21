package ru.itis.jdbc;

import ru.itis.jdbc.factory.ServiceFactory;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = ServiceFactory.getInstance().getUserService();

    }
}
