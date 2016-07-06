package atm;

import atm.services.*;
import com.google.inject.Inject;
import consts.Consts;
import consts.Operation;

public class ATM {
    @Inject
    Display display;
    @Inject
    CardReader cardReader;
    @Inject
    Input input;
    @Inject
    Output output;
    @Inject
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
        return amount <= serverConnector.getBalance(cardReader.getAddress());
    }

    public void withdraw(int amount) {
        output.withdraw(amount);
        serverConnector.changeBalance(cardReader.getAddress(),-amount);
        getBalance();
    }

    public void notEnoughError() {
        display.show(Consts.NOT_ENOUGH_AMOUNT.toString());
    }

    public void wrongPin() {
        display.show(Consts.WRONG_PIN_MSG.toString());
    }

    public void deposit(int amount){
        input.deposit(amount);
        serverConnector.changeBalance(cardReader.getAddress(),amount);
        getBalance();

    }

    public Operation chooseOperation() {
        return display.getOperation();

    }

    public int getBalance(){
        Integer balance = serverConnector.getBalance(cardReader.getAddress());
        display.show("Current balance " + balance.toString());
        return balance;
    }

    public String getAccountName(){
        String name = serverConnector.getName(cardReader.getAddress());
        display.show(name);
        return name;
    }

}
