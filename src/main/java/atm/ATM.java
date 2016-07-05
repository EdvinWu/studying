package atm;

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

    public void selectWithdrawal() {
    }

    public void selectDeposit(){

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
        display.show("Not enough money on the account");
    }

    public void wrongPin() {
        display.show("Wrong PIN");
    }

    public void deposit(int amount){
        input.deposit(amount);
        serverConnector.changeBalance(cardReader.getAdress(),amount);

    }

}
