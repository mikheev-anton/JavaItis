package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

// класс-модель
// содержит данные какой-либо сущности
public class User implements Serializable {
    private String name;
    private String login;
    private String password;
    private int id;

    public User(String name, String login, String password, int id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("login", this.login)
                .add("password", this.password).toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !object.getClass().getName().equals(this.getClass().getName())) {
            return false;
        }

        User that = (User)object;

        // return this.name.equals(that.name) && this.login.equals(that.login) && this.password.equals(that.password);
        return Objects.equal(this.name, that.name) &&
                Objects.equal(this.id, that.id)&&
                Objects.equal(this.login, that.login) &&
                Objects.equal(this.password, that.password);
    }
}
