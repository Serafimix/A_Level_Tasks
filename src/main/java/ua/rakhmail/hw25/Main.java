package ua.rakhmail.hw25;

import ua.rakhmail.hw25.dao.VehicleDAO;
import ua.rakhmail.hw25.entity.Owner;
import ua.rakhmail.hw25.entity.TyresType;
import ua.rakhmail.hw25.entity.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // создаем 4 персонажа
        Owner owner1 = new Owner("Barbara", "Gordon");
        Owner owner2 = new Owner("William", "Hand");
        Owner owner3 = new Owner("Barry", "Allen");
        Owner owner4 = new Owner("Jay", "Garrick");

        // создаем 5 транспортныйх средств
        Vehicle vehicle1 = new Vehicle("Batgirl Cycle", "1950-05-30", 25000, TyresType.SUMMER_SEASON, "2021-01-01");
        vehicle1.setOwner(owner1);
        Vehicle vehicle2 = new Vehicle("BlackHand car", "1999-09-29", 12500, TyresType.WINTER_SEASON, "2015-02-02");
        vehicle2.setOwner(owner2);
        Vehicle vehicle3 = new Vehicle("New Flash Cycle", "1988-08-08", 5000, TyresType.SUMMER_SEASON, "2018-08-08");
        vehicle3.setOwner(owner3);
        Vehicle vehicle4 = new Vehicle("Flash Cycle", "1940-07-07", 10000, TyresType.WINTER_SEASON, "2014-04-04");
        vehicle4.setOwner(owner4);
        Vehicle vehicle5 = new Vehicle("Joker Bicycle", "1966-06-06", 1, TyresType.ALL_SEASON, "not date text");
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
    }
}
