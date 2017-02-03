package ru.itis.jdbc.web.front_controller;


import ru.itis.jdbc.model.User;
import ru.itis.jdbc.web.front_controller.commands.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand command = getCommand(req);
        command.init(getServletContext(), req, resp);
        command.process();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand command = getCommand(req);
        command.init(getServletContext(), req, resp);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request){
        FrontCommand command;
        try {
            command = (FrontCommand) getCommandClass(request).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return command;
    }

    private Class getCommandClass(HttpServletRequest request) {
        String command = request.getParameter("command");
        Class result = null;
        User user = (User)request.getSession().getAttribute("user");
        if (command == null && user == null){
            command = "Login";
        }
        else if (user != null && command == null){
            command = "Show";
        }
        else {
            char c = Character.toUpperCase(command.charAt(0));
            String substring = command.substring(1, command.length());
            command = c+substring;
        }

        String commandClassName = "ru.itis.jdbc.web.front_controller.commands." + command + "Command";
        try {
            result = Class.forName(commandClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
