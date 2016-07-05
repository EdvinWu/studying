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

    public boolean checkSum() {
        return selectAmount() <= serverConnector.getBalance(cardReader.getAdress());
    }

    public void withdraw() {
        output.withdraw(selectAmount());
        serverConnector.changeBalance(cardReader.getAdress(),-selectAmount());
    }

    public void notEnoughError() {
        display.show("Not enough money on the account");
    }

    public void wrongPin() {
        display.show("Wrong pin");
    }

    public void deposit(){
        input.deposit(selectAmount());
        serverConnector.changeBalance(cardReader.getAdress(),selectAmount());

    }

}
