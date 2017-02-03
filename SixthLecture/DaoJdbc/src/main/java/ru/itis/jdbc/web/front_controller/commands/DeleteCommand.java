package ru.itis.jdbc.web.front_controller.commands;


import javax.servlet.ServletException;
import java.io.IOException;

public class DeleteCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id!=null){
            int carId = Integer.parseInt(id);
            carService.delete(carId);
            request.setAttribute("cars", service.getUser(getUserId()).getCars());
            forward("/cars.jsp");
        }
    }
}
