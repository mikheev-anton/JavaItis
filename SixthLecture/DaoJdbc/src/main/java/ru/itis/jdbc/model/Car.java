package ru.itis.jdbc.model;


public class Car {

    private int id;
    private String type;
    private String model;
    private String number;
    private int ownerId;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getNumber() {
        return number;
    }

    public boolean isNew(){
        return id == 0;
    }

    public Car(Car car) {
        this(car.getId(),car.getType(),car.getModel(),car.getNumber(),car.getOwnerId());
    }

    public Car(String type, String model, String number, int ownerId) {
        this(0,type, model, number, ownerId);
    }

    public Car(int id, String type, String model, String number, int ownerId) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.number = number;
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        return !(number != null ? !number.equals(car.number) : car.number != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
