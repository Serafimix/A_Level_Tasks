package ua.rakhmail.hw25;

import ua.rakhmail.hw25.dao.VehicleDAO;
import ua.rakhmail.hw25.entity.Owner;
import ua.rakhmail.hw25.entity.TyresType;
import ua.rakhmail.hw25.entity.Vehicle;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

/*

//        TESTS IS INCLUDED ON  "src/test/java/ua/rakhmail/hw25"


        // создаем 4 персонажа
        Owner owner1 = new Owner("Barbara", "Gordon");
        Owner owner2 = new Owner("William", "Hand");
        Owner owner3 = new Owner("Barry", "Allen");
        Owner owner4 = new Owner("Jay", "Garrick");

        // создаем 5 транспортныйх средств
        Vehicle vehicle1 = new Vehicle("Batgirl Cycle", LocalDate.of(1933, 5, 25), 25000, TyresType.SUMMER_SEASON, LocalDate.now());
        vehicle1.setOwner(owner1);
        Vehicle vehicle2 = new Vehicle("BlackHand car", LocalDate.of(1956, 6, 30), 12500, TyresType.WINTER_SEASON, LocalDate.now());
        vehicle2.setOwner(owner2);
        Vehicle vehicle3 = new Vehicle("New Flash Cycle", LocalDate.of(1967, 7, 14), 5000, TyresType.SUMMER_SEASON, LocalDate.now());
        vehicle3.setOwner(owner3);
        Vehicle vehicle4 = new Vehicle("Flash Cycle", LocalDate.of(1978, 8, 12), 10000, TyresType.WINTER_SEASON, LocalDate.now());
        vehicle4.setOwner(owner4);
        Vehicle vehicle5 = new Vehicle("Joker Bicycle", LocalDate.of(1988, 9, 5), 1, TyresType.ALL_SEASON, LocalDate.now());
        List<Vehicle> vehicles = new LinkedList<>();
        Collections.addAll(vehicles, vehicle1, vehicle2, vehicle3, vehicle4, vehicle5);
        VehicleDAO vehicleDAO = new VehicleDAO();

        // сохраняем в базу данных
        vehicles.forEach(vehicleDAO::saveVehicle);

        // выводим всю технику в консоль
        vehicleDAO.getVehicles().forEach(System.out::println);

        // выводим технику под номером 3 в консоль
        System.out.println(System.lineSeparator() + "Get Vehicle #3 " + vehicleDAO.getVehicle(3));

        // изменяем существующую технику и изменяем её же в БД, выведя в консоль
        Vehicle vehicleUpdate = vehicleDAO.getVehicle(3);
        vehicleUpdate.setName("This was just a joke");
        vehicleDAO.updateVehicle(vehicleUpdate);
        System.out.println(System.lineSeparator() + "Vehicle #3 is update" + vehicleDAO.getVehicle(3));

        // удаляем технику #3 из БД
        vehicleDAO.deleteVehicle(3);
        System.out.println("Vehicle #3 is delete , so getVehicle #3 is " + vehicleDAO.getVehicle(3));

        System.out.println();
        vehicleDAO.getVehicles().forEach(System.out::println);

*/

    }
}
