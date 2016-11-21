package ru.itis.jdbc.dao.file;

import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UserDaoFileImpl implements UserDao {

    private File path;

    private List<User> cache;

    public UserDaoFileImpl(String path) {
        this(new File(path));
    }

    public UserDaoFileImpl(File path) {
        this.path = path;
        this.cache = readAllUsers();
    }

    @Override
    public List<User> findAll() {
        return cache;
    }

    @Override
    public void update(User user) {
        ListIterator<User> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()) {
            if (userListIterator.next().getId() == user.getId()){
                userListIterator.remove();
                userListIterator.add(user);
//                break;
            }
        }
        writeAllUsers(cache);
    }

    public void save(User user) {
        if (!cache.contains(user)){
            cache.add(user);
        }
        writeAllUsers(cache);
    }

    @Override
    public User find(int id) {
        for (User user : cache){
            if (user.getId() == id){
                return user;
            }
        }
        return new User(0,"null",0, "null");
    }

    @Override
    public void delete(int id){
        ListIterator<User> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()) {
            if (userListIterator.next().getId() == id){
                userListIterator.remove();
                break;
            }
        }
        writeAllUsers(cache);
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        List<User> users = new ArrayList<>();
        for (User u : cache){
            if (u.getCity().equals(cityName)){
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public boolean isExist(String name) {
        for (User u : cache){
            if (u.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private List<User> readAllUsers(){
        List<User> arrayList;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.path))){
            try {
                arrayList = (ArrayList<User>)stream.readObject();
                if (!arrayList.isEmpty())
                    return arrayList;
            }catch (ClassNotFoundException e){
                System.out.println("User не найден");
            }
        }catch (IOException e){
            System.out.println("Не верный путь");
        }
        return new ArrayList<>();
    }

    private void writeAllUsers(List<User> users){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(users);
        }catch (IOException e){
            System.out.println("Не верный путь");
        }
    }
}
