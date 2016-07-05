public class Card {
    private String pin;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPin() {

        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Card(String pin, int amount) {
        this.pin = pin;
        this.amount = amount;
    }
}
