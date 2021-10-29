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

import java.time.LocalDate;
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
        Vehicle vehicle1 = new Vehicle("Batgirl Cycle", LocalDate.of(1950, 5, 30), 25000, TyresType.SUMMER_SEASON, LocalDate.now());
        vehicle1.setOwner(owner1);
        Vehicle vehicle2 = new Vehicle("BlackHand car", LocalDate.of(1950, 5, 30), 12500, TyresType.WINTER_SEASON, LocalDate.now());
        vehicle2.setOwner(owner2);
        Vehicle vehicle3 = new Vehicle("New Flash Cycle", LocalDate.of(1950, 5, 30), 5000, TyresType.SUMMER_SEASON, LocalDate.now());
        vehicle3.setOwner(owner3);
        Vehicle vehicle4 = new Vehicle("Flash Cycle", LocalDate.of(1950, 5, 30), 10000, TyresType.WINTER_SEASON, LocalDate.now());
        vehicle4.setOwner(owner4);
        Vehicle vehicle5 = new Vehicle("Joker Bicycle", LocalDate.of(1950, 5, 30), 1, TyresType.ALL_SEASON, LocalDate.now());
        List<Vehicle> vehicles = new LinkedList<>();
        Collections.addAll(vehicles, vehicle1, vehicle2, vehicle3, vehicle4, vehicle5);
        VehicleDAO vehicleDAO = new VehicleDAO();

        // сохраняем в базу данных
        vehicles.forEach(vehicleDAO::saveVehicle);
    }

    @Test
    void getAllVehicleCount() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Assertions.assertEquals(5, vehicleDAO.getVehicles().size());
    }

    @Test
    void saveAndGetNewVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = new Vehicle("test", LocalDate.of(1900, 1, 1), 1, TyresType.ALL_SEASON, LocalDate.now());
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

    @Test
    void deleteVehicle() {
        VehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle = vehicleDAO.getVehicle(2);
        Assertions.assertEquals("BlackHand car", vehicleDAO.getVehicle(2).getName());
        vehicleDAO.deleteVehicle(2);
        Assertions.assertNull(vehicleDAO.getVehicle(2));
    }
}