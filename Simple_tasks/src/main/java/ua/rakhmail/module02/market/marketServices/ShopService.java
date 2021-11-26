package ua.rakhmail.module02.market.marketServices;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.rakhmail.module02.market.marketObjets.Invoice;
import ua.rakhmail.module02.market.technique.Category;
import ua.rakhmail.module02.market.technique.Technique;
import ua.rakhmail.module02.market.technique.Telephone;
import ua.rakhmail.module02.market.technique.Television;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
public class ShopService {
    public static List<List<String>> allItemsToBuy = getListFromCSV();

    public static Invoice getInvoice() {
        Random random = new Random();
        Invoice check = new Invoice();
        check.setCustomer(PersonService.getRandomCustomer());
        check.setLimit(random.nextInt(3500));
        List<Technique> techniques = createListOfTechnique(5);
        check.setTechniques(techniques);
        int allCost = (check.getTechniques().stream()
                .map(Technique::getPrice)
                .mapToInt(x -> x)
                .sum());
        if (allCost <= check.getLimit()) {
            check.setType("retail");
        } else {
            check.setType("wholesale");
        }
        writerLogsOfOrder(check);
        return check;
    }

    private static List<Technique> createListOfTechnique(int bound) {
        List<Technique> techniques = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(bound) + 1; i++) {
            // создаю от 1 до bound товара в заказе.
            int randomItem = 1 + random.nextInt(allItemsToBuy.size() - 1);
            // рандомно выбираю товар вне зависимости от колличества, исключив первую строчку csv файла с описанием полей.
            Set<Integer> wrongItemIndex = new HashSet<>();
            for (int j = 0; j < allItemsToBuy.get(randomItem).size(); j++) {
                if (allItemsToBuy.get(randomItem).get(j).isEmpty()) {
                    try {
                        throw new UncorrectedLineWriter();
                    } catch (UncorrectedLineWriter e) {
                        wrongItemIndex.add(randomItem);
                    }
                }
            }
            if (!wrongItemIndex.contains(randomItem)) {
                techniques.add(getTechniqueFromCSV(randomItem));
                // если данные с ошибочным полем = мы заставим покупателя выбрать другой товар. Но об ошибке мы узнаем.
            } else {
                i--;
            }
        }
        return techniques;
    }

    private static Technique getTechniqueFromCSV(int index) {
        switch (allItemsToBuy.get(index).get(0)) {
            case ("Telephone") -> {
                return new Telephone(Category.TELEPHONE,
                        allItemsToBuy.get(index).get(1),
                        allItemsToBuy.get(index).get(4),
                        Integer.parseInt(allItemsToBuy.get(index).get(6)),
                        allItemsToBuy.get(index).get(2));
            }
            case ("Television") -> {
                return new Television(Category.TELEVISION,
                        allItemsToBuy.get(index).get(1),
                        allItemsToBuy.get(index).get(4),
                        Integer.parseInt(allItemsToBuy.get(index).get(6)),
                        Integer.parseInt(allItemsToBuy.get(index).get(3)),
                        allItemsToBuy.get(index).get(5));
            }
        }
        return new Technique();
    }

    private static List<List<String>> getListFromCSV() {
        List<List<String>> list = new ArrayList<>();
        String text;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/module02/items_for_market_for_module.csv"))) {
            while ((text = reader.readLine()) != null) {
                list.add(Arrays.stream(text.split(",")).toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writerLogsOfOrder(Invoice order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/module02/logs_of_all_Order.txt", true))) {
            writer.write(System.lineSeparator() + LocalDateTime.now() + " this is time of create order " +
                    System.lineSeparator() + " For users " + order.getCustomer().toString() + System.lineSeparator() +
                    " All his Order by Now " + order.getTechniques());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

