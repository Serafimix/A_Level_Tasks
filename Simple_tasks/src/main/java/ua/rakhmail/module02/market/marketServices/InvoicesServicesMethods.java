package ua.rakhmail.module02.market.marketServices;

import ua.rakhmail.module02.market.marketObjets.Invoice;
import ua.rakhmail.module02.market.technique.Category;
import ua.rakhmail.module02.market.technique.Technique;

import java.util.*;

public class InvoicesServicesMethods {
    public static void fillListOfInvoice(List<Invoice> list) {
        for (int i = 0; i < 15; i++) {
            list.add(ShopService.getInvoice());
        }
    }

    public static void getCountOfCategorySell(List<Invoice> list) {
        // потом переписать чтобы вне зависимости от количества катеогрий техник в enumЕ работало
        long countOfTelephoneSell = list.stream()
                .flatMap(x -> x.getTechniques().stream())
                .filter(x -> x.getCategory() == Category.TELEPHONE)
                .count();
        long countOfTVSell = list.stream()
                .flatMap(x -> x.getTechniques().stream())
                .filter(x -> x.getCategory() == Category.TELEVISION)
                .count();
        System.out.println("Count of Telephones sell = " + countOfTelephoneSell);
        System.out.println("Count of Televisions sell = " + countOfTVSell);
    }

    public static void getSumOfOrder(List<Invoice> list) {
        int sum;
        sum = list.stream()
                .flatMap(x -> x.getTechniques().stream())
                .mapToInt(Technique::getPrice)
                .sum();
        System.out.println("Summary of all order = " + sum);
    }

    public static void getCheapestOfInvoice(List<Invoice> list) {
        System.out.println("Cheapest order: " + list.stream()
                .min(Comparator.comparing(i -> i.getTechniques().stream()
                        .mapToInt(Technique::getPrice)
                        .sum())));
    }

    public static void getRetailOfInvoice(List<Invoice> list) {
        long count = list.stream()
                .filter(x -> x.getType().equals("retail"))
                .count();
        System.out.println("In the list of Invoices have \"Retail\" invoice = " + count);
    }

    public static void getFirstOfThreeInvoices(List<Invoice> list) {
        System.out.println("First of three invoices: ");
        list.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void infoInvoiceForYoungPeople(List<Invoice> list) {
        System.out.println("List of order for Low age customers");
        list.stream()
                .filter(x -> x.getCustomer().getAge() < 18)
                .peek(x -> x.setType("low_age"))
                .forEach(System.out::println);

    }

    public static void invoicedOnlySingleTypeOfTechnology(List<Invoice> list) {
        System.out.println("List of invoice only with single type of technique: ");
        // потом переписать чтобы вне зависимости от количества катеогрий техник в enumЕ работало
        list.stream()
                .filter(x -> x.getTechniques().stream()
                        .map(Technique::getCategory)
                        .allMatch(category -> category == Category.TELEPHONE))
                .forEach(System.out::println);
        list.stream()
                .filter(x -> x.getTechniques().stream()
                        .map(Technique::getCategory)
                        .allMatch(category -> category == Category.TELEVISION))
                .forEach(System.out::println);
    }

    public static void sortedInvoiced(List<Invoice> list) {
        System.out.println("Sorted list of Invoices: ");
        list.stream()
                .sorted((x1, x2) -> x2.getCustomer().getAge() - x1.getCustomer().getAge())
                .sorted((a1, a2) -> (int) ((long) a1.getTechniques().size() - (long) a2.getTechniques().size()))
                // пробовал так же через thenComparator, всё равно сумма заказов перебивает количество.
//                .sorted((x1, x2) -> x1.getTechniques().stream()
//                        .mapToInt(Technique::getPrice)
//                        .sum() - x2.getTechniques().stream().
//                        mapToInt(Technique::getPrice)
//                        .sum())
                .forEach(System.out::println);
    }
}
