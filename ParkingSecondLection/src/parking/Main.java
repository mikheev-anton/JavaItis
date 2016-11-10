package parking;

/**
 * Created by 1 on 10.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        Transport[] transports = {
                new Car("Nissan", 123),
                new MotoCycle("Nissan", 12),
                new Jeep("Niva", 222),
                new Bicycle("Steals", 1),
                null,
                null,
                null,
                null,
                null,
        };

        AutoParking autoParking = new AutoParking(transports);

        autoParking.parkIn(new Jeep("Suzuki", 564));
        autoParking.parkIn(new Bicycle("BMX", 4));
        autoParking.parkIn(new Car("Audi", 777));
        autoParking.parkIn(new MotoCycle("Ural", 784));
        autoParking.parkIn(new Car("VAZ", 942));
        autoParking.parkIn(new Car("Kia", 849));

        autoParking.moveAll();
    }
}
