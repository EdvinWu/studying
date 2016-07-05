package implementation;

import atm.entity.Card;
import atm.services.CardReader;
import consts.Consts;

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
        card = new Card(Consts.PIN.toString(),Consts.ADDRESS.toString());
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
