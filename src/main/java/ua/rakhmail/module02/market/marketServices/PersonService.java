package ua.rakhmail.module02.market.marketServices;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.rakhmail.module02.market.marketObjets.Customer;

import java.util.Random;

@Data
@NoArgsConstructor
public class PersonService {
    private static int countID = 1;

    public static Customer getRandomCustomer() {
        Random random = new Random();
        Customer customer = new Customer();
        customer.setAge(random.nextInt(60));
        customer.setId("Customer#" + countID);
        int a = random.nextInt(5);
        switch (a) {
            case (0) -> customer.setEmail("person" + countID + "@gmail.com");
            case (1) -> customer.setEmail("person" + countID + "@yandex.ru");
            case (2) -> customer.setEmail("person" + countID + "@rambler.com");
            case (3) -> customer.setEmail("person" + countID + "@mail.ua");
            case (4) -> customer.setEmail("person" + countID + "@mail.ru");
        }
        countID++;
        return customer;
    }
}
