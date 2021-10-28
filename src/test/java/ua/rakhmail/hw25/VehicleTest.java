package ua.rakhmail.hw25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ua.rakhmail.hw25.dao.VehicleDAO;
import ua.rakhmail.hw25.entity.Owner;
import ua.rakhmail.hw25.entity.TyresType;
import ua.rakhmail.hw25.entity.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class VehicleTest {
    @BeforeAll
    static void setUp() {
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
    }

    @Test
    void getAllVehicleWithoutException() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.getVehicles();
    }

    @Test
    void saveAndGetNewVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = new Vehicle("test", "test", 1, TyresType.ALL_SEASON, "test");
        vehicleDAO.saveVehicle(vehicle);
        Assertions.assertEquals("test", vehicleDAO.getVehicle(6).getName());
    }

    @Test
    void getFirstVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Assertions.assertEquals("Batgirl Cycle", vehicleDAO.getVehicle(1).getName());
    }

    @Test
    void updateVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = vehicleDAO.getVehicle(3);
        vehicle.setName("test");
        vehicleDAO.updateVehicle(vehicle);
        Assertions.assertEquals("test", vehicleDAO.getVehicle(3).getName());
    }

    void deleteVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = vehicleDAO.getVehicle(2);
        Assertions.assertEquals("BlackHand car", vehicleDAO.getVehicle(2).getName());
        vehicleDAO.deleteVehicle(2);
        Assertions.assertNull(vehicleDAO.getVehicle(2));
    }
}