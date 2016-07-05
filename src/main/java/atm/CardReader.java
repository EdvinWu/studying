package atm;

public interface CardReader {
    void insertCard();
    boolean checkPin(String pin);
    String getAdress();


}
