package atm;

import atm.services.*;
import consts.Consts;
import consts.Operation;

public abstract class ATM {
    Display display;
    CardReader cardReader;
    Input input;
    Output output;
    ServerConnector serverConnector;

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
        display.show(Consts.WRONG_PIN.toString());
    }

    public void deposit(int amount){
        input.deposit(amount);
        serverConnector.changeBalance(cardReader.getAdress(),amount);

    }

    public Operation chooseOperation() {
        return display.getOperation();

    }

    public int getBalance(){
        return serverConnector.getBalance(cardReader.getAdress());
    }

    public String getAccountName(){
        return serverConnector.getName(cardReader.getAdress());
    }

}
