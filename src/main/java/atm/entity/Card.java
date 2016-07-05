package atm.entity;

public class Card {
    private String pin;
    private String adress;


    public String getPin() {

        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Card(String pin, String adress) {
        this.pin = pin;
        this.adress = adress;
    }
}
