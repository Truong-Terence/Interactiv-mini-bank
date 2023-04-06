package org.example;

import java.util.UUID;

public class Bank {
    Customer[] customers = new Customer[100];
    String name;
    int nbCustomer;

    public Bank() {
        nbCustomer = 0;
    }
    void addCustomer(String costumerName) {
        nbCustomer++;
        this.customers[nbCustomer] = new Customer(costumerName);
    }

    void customerBalanceSheet(String costumerName) {

    }

    void displayBalanceSheet() {

    }

}
