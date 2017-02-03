package ru.itis.jdbc.web.front_controller.commands;

import org.springframework.context.ApplicationContext;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.service.CarService;
import ru.itis.jdbc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected UserService service;
    protected CarService carService;
    private User user;


    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
        ApplicationContext con = (ApplicationContext)context.getAttribute("hibernateSpringContext");
        this.carService = (CarService)con.getBean("carServiceImpl");
        this.service = (UserService)con.getBean("usersAndAutoService");
//        this.service = ServiceFactory.getInstance().getUserService();
//        this.carService = ServiceFactory.getInstance().getCarService();

        if (user == null){
            this.user = (User)request.getSession().getAttribute("user");
        }
    }

    abstract public void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
    protected int getUserId(){
        return this.user.getId();
    }

    protected User getUser(){
        return user;
    }
}
