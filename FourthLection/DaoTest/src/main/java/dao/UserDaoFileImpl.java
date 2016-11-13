package dao;

import model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UserDaoFileImpl implements UsersDao{

    private File path;

    public UserDaoFileImpl(String path) {
        this(new File(path));
    }

    public UserDaoFileImpl(File path) {
        this.path = path;
    }

    public List<User> findAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.path))){
            while (stream.available() > 0){
                try {
                    User user = (User)stream.readObject();
                    arrayList.add(user);
                }catch (ClassNotFoundException e){
                    System.out.println("User не найден");
                }
            }
        }catch (IOException e){
            System.out.println("Не верный путь");
        }
        return arrayList;
    }

    public void save(User user) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(user);
        }catch (IOException e){
            System.out.println("Не верный путь");
        }
    }
}
