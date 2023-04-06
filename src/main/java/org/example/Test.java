package org.example;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
//        System.out.println(testDisplayBalance());
//        System.out.println(testGetName());
//        System.out.println(testCostumerFirstAccounts());
//        testAddAccount();
//        testGetBalance();
        testTransfer();
    }
    public static float testDisplayBalance() {
        Account account = new Account(UUID.randomUUID().toString(),2.0f);
        return account.getBalance();
    }

    public static String testGetName() {
        Customer newCustomer = new Customer("Tété");
        return newCustomer.getName();
    }
    public static Account[] testCostumerFirstAccounts() {
        Customer newCustomer = new Customer("Tété");
        return newCustomer.accounts;
    }
    public static void testAddAccount() {
        Customer newCustomer = new Customer("Tété");
        newCustomer.addAccount(100.0f);
        for (int i = 0; i <= newCustomer.nbAccount; i++) {
            System.out.println("Compte n°" + (i + 1));
        System.out.println(newCustomer.accounts[i].accountId);
        System.out.println(newCustomer.accounts[i].balance);
        }
    }

    public static void testGetBalance() {
        Customer newCustomer = new Customer("Tété");
        newCustomer.addAccount(100.0f);
        System.out.println(newCustomer.getBalance());
    }

    public static void testTransfer() {
        Customer newCustomer = new Customer("Tété");
        newCustomer.addAccount(100.0f);
        newCustomer.accounts[0].transfer((float) 20, newCustomer.accounts[1]);
        System.out.println(newCustomer.accounts[0].balance);
        System.out.println(newCustomer.accounts[1].balance);
    }
}
