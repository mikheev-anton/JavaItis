package ru.itis.jdbc.model;


import java.io.Serializable;

public class Car implements Serializable {

    private int id;
    private String model;
    private int mileage;
    private int ownerId;

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public boolean isNew(){
        return id == 0;
    }

    public Car(Car car, int userId) {
        this(car.getId(),car.getModel(),car.getMileage(), userId);
    }

    public Car(Car car) {
        this(car.getId(),car.getModel(),car.getMileage(),car.getOwnerId());
    }

    public Car(String model, int mileage, int ownerId) {
        this(0, model, mileage, ownerId);
    }

    public Car(int id, String model, int mileage, int ownerId) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (mileage != car.mileage) return false;
        return !(model != null ? !model.equals(car.model) : car.model != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + mileage;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", ownerId=" + ownerId +
                '}';
    }
}
