package ru.itis.jdbc.web.front_controller.commands;

import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.web.Md5;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class RegistrationCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        User user = convertRequestUser();
        service.addUser(user);
        request.getSession().setAttribute("user", service.getUser(user.getEmail()));
        request.setAttribute("users", service.getAll());
        forward("/users.jsp");
    }

    private User convertRequestUser() {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String password = Md5.getHash(request.getParameter("password"));
        String city = request.getParameter("city");
        return new User.Builder()
                .setName(name)
                .setEmail(email)
                .setAge(Integer.parseInt(age))
                .setPassword(password).setCity(city)
                .setCars(new ArrayList<Car>()).build();
    }
}
