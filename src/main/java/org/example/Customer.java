package org.example;

import java.util.UUID;

public class Customer {

    String name;
    int nbAccount;
    Account[] accounts = new Account[100];

    public Customer (String CustomerName) {
        nbAccount = 0;
        this.name = CustomerName;
        this.accounts[nbAccount] = new Account(UUID.randomUUID().toString(), 150.0f);
    }

    String getName() {
        return this.name;
    }
    void addAccount(float money) {
        nbAccount++;
        this.accounts[nbAccount] = new Account( UUID.randomUUID().toString(), money);
    }
    float getBalance() {
        float sum = 0.0f;
        for (int i = 0; i < this.nbAccount+1; i++) {
            sum += this.accounts[i].getBalance();
        }
        return sum;
    }
    void displayBalance() {
        System.out.println(this.getBalance());
    }

}
