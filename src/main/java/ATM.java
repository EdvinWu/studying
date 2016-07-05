public class ATM {
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

    public int selectAmount() {
        return display.getAmount();
    }

    public boolean checkSum() {
        return selectAmount() <= cardReader.getCardAmount();
    }

    public void withdraw() {
        output.withdraw(selectAmount());
    }

    public void notEnoughError() {
        display.show("Not enough money on the account");
    }

    public void wrongPin() {
        display.show("Wrong pin");
    }
}
