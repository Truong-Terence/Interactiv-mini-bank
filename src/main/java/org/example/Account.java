
package org.example;
public class Account {
    String accountId;
    float balance;

    public Account(String accountId, float balance) {
        this.accountId = accountId;
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

    void transfer(float value, Account recipient) {
        this.balance -= value;
        recipient.balance += value;
    }
}


