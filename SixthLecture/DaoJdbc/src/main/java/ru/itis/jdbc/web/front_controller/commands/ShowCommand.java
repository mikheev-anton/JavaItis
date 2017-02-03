package ru.itis.jdbc.web.front_controller.commands;

import ru.itis.jdbc.model.Car;

import javax.servlet.ServletException;
import java.io.IOException;


public class ShowCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String id = request.getParameter("userId");
        String show = request.getParameter("show");
        String servletPath;
        if (id == null && show == null){
            request.setAttribute("users", service.getAll());
            servletPath = "/users.jsp";
        }
        else if ("update".equals(show)||"add".equals(show)){
            String carId = request.getParameter("id");
            Car car = new Car.Builder().build();
            if ("update".equals(show))
                car = carService.find(Integer.parseInt(carId));
            request.setAttribute("car", car);
            servletPath = "/edit_car.jsp";
        }
        else if ("registration".equals(show)){
            servletPath = "/profile.jsp";
        }
        else {
            request.setAttribute("cars", service.getUser(getUserId()).getCars());
            servletPath = "/cars.jsp";
        }
        forward(servletPath);
    }
}
