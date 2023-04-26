package org.example;

import java.util.UUID;

public class Bank {
    Customer[] customers = new Customer[100];
    String name;
    int nbCustomer;

    public Bank(String name) {
        this.name = name;
        this.nbCustomer = 0;
    }
    void addCustomer(String costumerName) {
        this.customers[nbCustomer] = new Customer(costumerName);
        this.nbCustomer++;
    }

    Customer getCustomerByIndex(int index) {
        return this.customers[index];
    }

    void displayBalanceSheet() {
        for (Customer customer : customers) {
            if (customer == null) {
                break;
            }
            System.out.println("Customer :" + customer.getName() + " --> " + customer.getBalance());
        }
    }

    public Customer[] getCustomer() {
        return customers;
    }
}
