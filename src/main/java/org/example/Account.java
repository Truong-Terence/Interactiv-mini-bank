
package org.example;
public class Account {
    short number;
    double balance;

    public Account(short number, double balance) {
        this.number = number;
        this.balance = balance;
    }
    void deposit(float value) {
        this.balance += value;
    }

    void withdrawal(float value) {
        this.balance -= value;
    }
    float getBalance() {
        return (float) this.balance;
    }

    void displayBalance() {
        System.out.println(getBalance());
    }

//    void transfer(float value, Account recipient) {
//
//    }
}


