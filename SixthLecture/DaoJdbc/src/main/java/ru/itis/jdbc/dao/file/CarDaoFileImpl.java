package ru.itis.jdbc.dao.file;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CarDaoFileImpl implements CarDao {

    private File path;

    private List<Car> cache;

    public CarDaoFileImpl(String path) {
        this(new File(path));
    }

    public CarDaoFileImpl(File path) {
        this.path = path;
        this.cache = readAllUsers();
    }

    @Override
    public List<Car> findAllUserCars(int userId) {
        List<Car> cars = new ArrayList<>();
        for (Car c : cache){
            if (c.getOwnerId() == userId){
                cars.add(c);
            }
        }
        return cars;
    }

    @Override
    public List<Car> findAll() {
        return cache;
    }

    @Override
    public void update(Car car) {
        ListIterator<Car> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()) {
            if (userListIterator.next().getId() == car.getId()){
                userListIterator.remove();
                userListIterator.add(car);
//                break;
            }
        }
        writeAllUsers(cache);
    }

    @Override
    public void save(Car car, int userId) {
        if (!cache.contains(car)){
            cache.add(new Car(car,userId));
        }
        writeAllUsers(cache);
    }

    @Override
    public Car find(int id) {
        for (Car car : cache){
            if (car.getId() == id){
                return car;
            }
        }
        return new Car(0,"null",0, -1);
    }

    @Override
    public void delete(int id) {
        ListIterator<Car> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()) {
            if (userListIterator.next().getId() == id){
                userListIterator.remove();
                break;
            }
        }
        writeAllUsers(cache);
    }

    @Override
    public List<Car> getCarsByCity(String userCity) {
        return null;
    }

    private List<Car> readAllUsers(){
        List<Car> arrayList;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.path))){
            try {
                arrayList = (ArrayList<Car>)stream.readObject();
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

    private void writeAllUsers(List<Car> users){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(users);
        }catch (IOException e){
            System.out.println("Не верный путь");
        }
    }
}
