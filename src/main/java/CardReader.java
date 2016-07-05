public interface CardReader {
    Card insertCard();
    boolean checkPin(String pin);
    int getCardAmount();


}
