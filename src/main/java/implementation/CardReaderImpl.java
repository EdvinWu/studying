package implementation;

import atm.Card;
import atm.CardReader;

public class CardReaderImpl implements CardReader{
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public void insertCard() {
        card = new Card("somewhere@nowhere.com","0000");
    }

    @Override
    public boolean checkPin(String pin) {
        return pin.equals(card.getPin());
    }

    @Override
    public String getAdress() {
        return card.getAdress();
    }
}
