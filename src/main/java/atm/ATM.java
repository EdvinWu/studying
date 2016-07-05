package atm;

import atm.services.*;
import consts.Consts;
import consts.Operation;

public abstract class ATM {
    protected Display display;
    protected CardReader cardReader;
    protected Input input;
    protected Output output;
    protected ServerConnector serverConnector;

    public void insertCard() {
        cardReader.insertCard();
    }

    public boolean checkPin() {
        String pin = display.getPin();
        return cardReader.checkPin(pin);
    }

    public int selectAmount() {
        return display.getAmount();
    }

    public boolean checkSum(int amount) {
        return amount <= serverConnector.getBalance(cardReader.getAdress());
    }

    public void withdraw(int amount) {
        output.withdraw(amount);
        serverConnector.changeBalance(cardReader.getAdress(),-amount);
    }

    public void notEnoughError() {
        display.show(Consts.NOT_ENOUGH_AMOUNT.toString());
    }

    public void wrongPin() {
        display.show(Consts.WRONG_PIN_MSG.toString());
    }

    public void deposit(int amount){
        input.deposit(amount);
        serverConnector.changeBalance(cardReader.getAdress(),amount);

    }

    public Operation chooseOperation() {
        return display.getOperation();

    }

    public int getBalance(){
        Integer balance = serverConnector.getBalance(cardReader.getAdress());
        display.show(balance.toString());
        return balance;
    }

    public String getAccountName(){
        String name = serverConnector.getName(cardReader.getAdress());
        display.show(name);
        return name;
    }

}
