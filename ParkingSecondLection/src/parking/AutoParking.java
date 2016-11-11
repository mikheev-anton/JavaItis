package parking;

/**
 * Created by 1 on 10.11.2016.
 */
public class AutoParking {
    private Transport[] parkingPlace;

    public AutoParking(Transport[] parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void parkIn(Transport transport){
        for (int i = 0; i < parkingPlace.length; i++) {
            if (parkingPlace[i] == null){
                parkingPlace[i] = transport;
                System.out.println(transport +" припаркована на месте № "+i);
                return;
            }
        }
        System.out.println("Нет мест");
    }

    public Transport parkOutForNumber(int number){
        for (int i = 0; i < parkingPlace.length; i++) {
            if (parkingPlace[i] != null && parkingPlace[i].getNumber() == number){
                System.out.println(parkingPlace[i]+" уехала с парковки");
                parkingPlace[i] = null;
                return parkingPlace[i];
            }
        }
        System.out.println("ТС с номером: " + number + " 404!");
        return null;
    }
    public Transport parkOutForPlace(int numberOfPlace){
        if (numberOfPlace>=0 && numberOfPlace<parkingPlace.length){
            System.out.println("Нет такого места");
        }
        if (parkingPlace[numberOfPlace] != null){
            System.out.println(parkingPlace[numberOfPlace]+" уехала с парковки");
            parkingPlace[numberOfPlace] = null;
            return parkingPlace[numberOfPlace];
        }

        System.out.println("ТС на месте: " + numberOfPlace + " 404!");
        return null;
    }

    public void moveAll(){
        for (int i = 0; i < parkingPlace.length; i++) {
            if (parkingPlace[i] != null)
                parkingPlace[i].move();
        }
        parkingPlace = null;
        System.out.println("Парковка свободна!");
    }
}
