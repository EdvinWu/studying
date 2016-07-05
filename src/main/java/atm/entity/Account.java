package atm.entity;

import consts.Consts;

public class Account {
    private int balance = 200;
    private String address = Consts.ADDRESS.toString();
    private String accountHolderName = Consts.NAME.toString();

    public int getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void changeBalance(int amount) {
        balance += amount;
    }
}
