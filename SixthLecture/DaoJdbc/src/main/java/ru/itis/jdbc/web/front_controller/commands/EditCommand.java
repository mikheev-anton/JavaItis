package ru.itis.jdbc.web.front_controller.commands;


import ru.itis.jdbc.model.Car;

import javax.servlet.ServletException;
import java.io.IOException;

public class EditCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String id = request.getParameter("id");
        Car car = convertRequestCar();
        if (id.isEmpty()||"0".equals(id)){
            carService.save(car, getUserId());
        }
        else {
            carService.update(new Car(car, getUser()));
        }
        request.setAttribute("cars", service.getUser(getUserId()).getCars());
        forward("/cars.jsp");
    }

    private Car convertRequestCar() {
        String id = request.getParameter("id").isEmpty()? "0" : request.getParameter("id");
        String model = request.getParameter("model");
        String mileage = request.getParameter("mileage");
        return new Car.Builder()
                .setId(Integer.parseInt(id))
                .setModel(model)
                .setMileage(Integer.parseInt(mileage))
                .build();
    }
}
