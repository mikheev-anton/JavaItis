package ru.itis.jdbc.model;


import java.util.List;

public class User {

    private final int id;
    private final String name;
    private final String email;
    private final String password;

    private List<Car> cars;

    public User(User user) {
        this(user.getId(),user.getName(),user.getEmail(),user.getPassword());
    }

    public User(String name, String email, String password) {
        this(0,name,email,password);
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isNew(){
        return this.id == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return !(email != null ? !email.equals(user.email) : user.email != null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
