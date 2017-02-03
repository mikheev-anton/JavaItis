package ru.itis.jdbc.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @SequenceGenerator(name = "cars_tab_seq", sequenceName = "cars_tab_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_tab_seq")
    @Access(value = AccessType.PROPERTY)
    private Integer id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_mileage")
    private int mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    protected Car() {
    }

    public Car(Builder builder) {
        this(builder.id,builder.model,builder.mileage, builder.owner);
    }

    public Car(Car car, User user) {
        this(car.getId(),car.getModel(),car.getMileage(), user);
    }

    public Car(Car car) {
        this(car.getId(),car.getModel(),car.getMileage(), car.getOwner());
    }

    public Car(String model, int mileage, User owner) {
        this(0, model, mileage, owner);
    }

    public Car(int id, String model, int mileage, User owner) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
        this.owner = owner;
    }

    public static class Builder{
        private int id;
        private String model;
        private int mileage;
        private User owner;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder setOwnerId(User owner) {
            this.owner = owner;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
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
                ", ownerId=" + getOwner().getId() +
                '}';
    }
}
