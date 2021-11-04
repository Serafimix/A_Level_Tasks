package ua.rakhmail.hw26;

import ua.rakhmail.hw26.dao.OrderDAO;
import ua.rakhmail.hw26.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        list.remove("2");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
/*
//    TESTS IS INCLUDED


    private static final OrderDAO ORDER_DAO = new OrderDAO();

    public static void main(String[] args) {
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

        // save all orders
        ORDER_DAO.save(orders1);
        ORDER_DAO.save(orders2);

        // print all orders
        ORDER_DAO.getAllOrder().forEach(System.out::println);

        // change Customer in order
        orders1.setCustomer(customer2);
        ORDER_DAO.update(orders1);
        System.out.println(System.lineSeparator() + ORDER_DAO.getById(1));

        // delete first order
        ORDER_DAO.delete(1);
        System.out.println();
        ORDER_DAO.getAllOrder().forEach(System.out::println);

        // copy all orders
        ORDER_DAO.insertOrder();
        System.out.println();
        ORDER_DAO.getAllOrder().forEach(System.out::println);

        // get new order with new ID
        System.out.println(System.lineSeparator() + ORDER_DAO.getById(3));
        }
        */

}
