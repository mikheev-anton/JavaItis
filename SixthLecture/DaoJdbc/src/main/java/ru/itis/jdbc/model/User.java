package ru.itis.jdbc.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_table")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "users_tab_seq", sequenceName = "users_tab_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_tab_seq")
    @Access(value = AccessType.PROPERTY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Car> cars;

    public User(Builder builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.city = builder.city;
        this.email = builder.email;
        this.cars = builder.cars;
        this.name = builder.name;
        this.password = builder.password;
    }

    protected User() {
    }

    public User(User user) {
        this(user.getId(),user.getName(),user.getAge(),user.getCity());
    }

    public User(String name, int age, String city) {
        this(0,name,age,city);
    }

    public User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.cars = new ArrayList<>();
    }

    public static class Builder{
        private int id;
        private String name;
        private int age;
        private String city;
        private String password;
        private String email;

        private List<Car> cars;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setCars(List<Car> cars) {
            this.cars = cars;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return !(city != null ? !city.equals(user.city) : user.city != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
