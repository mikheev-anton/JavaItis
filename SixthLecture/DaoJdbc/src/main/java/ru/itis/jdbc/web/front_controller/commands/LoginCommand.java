package ru.itis.jdbc.web.front_controller.commands;

import ru.itis.jdbc.model.User;
import ru.itis.jdbc.web.Md5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand extends FrontCommand {

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
    }

    @Override
    public void process() throws ServletException, IOException {
        String command = request.getParameter("command");
        if ("login".equals(command)){
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (service.isRegistered(email)){
                User user = service.getUser(email);
                password = Md5.getHash(password);
                if (user.getPassword().equals(password)){
                    request.getSession().setAttribute("user", user);
                    request.setAttribute("users", service.getAll());
                    forward("/users.jsp");
                }else {
                    forward("/login.jsp");
                }
            }
            else {
                forward("/profile.jsp");
            }
        }
        else {
            forward("/login.jsp");
        }
    }
}
