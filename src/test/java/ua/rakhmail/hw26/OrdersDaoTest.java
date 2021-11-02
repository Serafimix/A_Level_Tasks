package ua.rakhmail.hw26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.rakhmail.hw26.dao.OrderDAO;
import ua.rakhmail.hw26.entity.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrdersDaoTest {
    private static OrderDAO orderDAO;

    @BeforeAll
    static void beforeAll() {
        orderDAO = new OrderDAO();
        Artist artist1 = new Artist("Gorillaz");
        Artist artist2 = new Artist("Eminem");
        Album album1 = new Album("Gorillaz Album", LocalDate.of(2000, 5, 30),
                MusicStyle.ROCK, "Fills good inc.", artist1, 500.0);
        Album album2 = new Album("Eminem Album", LocalDate.of(1999, 2, 20),
                MusicStyle.RAP, "Without me", artist2, 250.0);
        BuyingAlbum buyingAlbum1 = new BuyingAlbum(album1);
        BuyingAlbum buyingAlbum2 = new BuyingAlbum(album2);
        Customer customer1 = new Customer("Mr.", "Smith");
        Customer customer2 = new Customer("Ms.", "Smiths");
        Orders orders1 = new Orders(buyingAlbum1, customer1);
        Orders orders2 = new Orders(buyingAlbum2, customer2);
        orderDAO.save(orders1);
        orderDAO.save(orders2);
    }

    @Test
    void save() {
        Orders orders = new Orders();
        orderDAO.save(orders);
        Assertions.assertEquals(orders, orderDAO.getById(3));
    }

    @Test
    void update() {
        Orders orders = orderDAO.getById(1);
        orders.setCustomer(orderDAO.getById(2).getCustomer());
        orderDAO.update(orders);
        Assertions.assertEquals(orderDAO.getById(2).getCustomer(), orderDAO.getById(1).getCustomer());
    }

//    @Test
//    void insert() {
//        orderDAO.insertOrder();
//        Assertions.assertEquals(4, orderDAO.getAllOrder().size());
//    }


    @Test
    void delete() {
        Orders orders = orderDAO.getById(3);
        Assertions.assertEquals(orders, orderDAO.getById(3));
        orderDAO.delete(3);
        assertNull(orderDAO.getById(3));
    }

    @Test
    void getByIdWhenNull() {
        assertNull(orderDAO.getById(10));
    }

    @Test
    void getByIdl() {
        Assertions.assertEquals("Gorillaz", orderDAO.getById(1).getBuyingAlbum().getAlbum().getArtist().getNickname());
    }

    @Test
    void getAllOrders() {
        Assertions.assertEquals(2, orderDAO.getAllOrder().size());
    }
}