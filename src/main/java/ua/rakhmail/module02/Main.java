package ua.rakhmail.module02;

import ua.rakhmail.module02.market.marketObjets.Invoice;
import ua.rakhmail.module02.market.marketServices.InvoicesServicesMethods;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Invoice> invoices = new ArrayList<>();
        InvoicesServicesMethods.fillListOfInvoice(invoices);
        decorate();
        InvoicesServicesMethods.getCountOfCategorySell(invoices);
        decorate();
        InvoicesServicesMethods.getCheapestOfInvoice(invoices);
        decorate();
        InvoicesServicesMethods.getSumOfOrder(invoices);
        decorate();
        InvoicesServicesMethods.getRetailOfInvoice(invoices);
        decorate();
        InvoicesServicesMethods.invoicedOnlySingleTypeOfTechnology(invoices);
        decorate();
        InvoicesServicesMethods.getFirstOfThreeInvoices(invoices);
        decorate();
        InvoicesServicesMethods.infoInvoiceForYoungPeople(invoices);
        decorate();
        InvoicesServicesMethods.sortedInvoiced(invoices);
        decorate();
    }

    private static void decorate() {
        System.out.println("*****************************************************************************************");
    }
}