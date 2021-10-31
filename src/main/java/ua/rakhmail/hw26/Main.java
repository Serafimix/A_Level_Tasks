package ua.rakhmail.hw26;

import ua.rakhmail.hw26.dao.OrderDAO;
import ua.rakhmail.hw26.entity.*;

import java.time.LocalDate;

public class Main {
    private static final OrderDAO orderDAO = new OrderDAO();

    public static void main(String[] args) {
        Artist artist1 = new Artist("Gorillaz");
        Album album1 = new Album("Gorillaz Album", LocalDate.of(2000, 5, 30),
                MusicStyle.ROCK, "Fell good inc.", artist1);
        BuyingAlbum buyingAlbum1 = new BuyingAlbum(album1);
        Customer customer1 = new Customer("Mr.", "Smith");
        Orders order1 = new Orders(buyingAlbum1, customer1);
        orderDAO.save(order1);
        System.out.println(orderDAO.getById(1));

    }
}
