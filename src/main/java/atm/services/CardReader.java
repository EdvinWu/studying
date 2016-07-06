package atm.services;

public interface CardReader {
    void insertCard();
    boolean checkPin(String pin);
    String getAddress();


}
