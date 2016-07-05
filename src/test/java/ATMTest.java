import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    CardReader cardReader = createTestCardReader();
    ATM atm = new TestATM(cardReader);

    @Test
    public void testInsertCard() throws Exception {
        atm.insertCard();
        assertEquals(cardReader.getCardAmount(), 0);
        assertTrue(cardReader.checkPin("0000"));

    }


    @Test
    public void testCheckPin() throws Exception {

    }

    @Test
    public void testSelectWithdrawal() throws Exception {

    }

    @Test
    public void testSelectAmount() throws Exception {

    }

    @Test
    public void testCheckSum() throws Exception {

    }

    @Test
    public void testWithdraw() throws Exception {

    }

    @Test
    public void testNotEnoughError() throws Exception {

    }

    @Test
    public void testWrongPin() throws Exception {

    }

    public static CardReader createTestCardReader() {
        return new CardReader() {
            @Override
            public Card insertCard() {
                return new Card("0000", 0);
            }

            @Override
            public boolean checkPin(String pin) {
                return true;
            }

            @Override
            public int getCardAmount() {
                return 0;
            }
        };
    }


}
