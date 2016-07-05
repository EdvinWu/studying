import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    CardReader cardReader = createTestCardReader();
    Display display = createTestDisplay();
    ATM atm = new TestATM(cardReader, display);

    @Before
    public void prepareTests() {
        atm.insertCard();
    }

    @Test
    public void testInsertCard() throws Exception {
        assertEquals(cardReader.getAdress(), "somewhere@nowhere.com");
        assertTrue(cardReader.checkPin("0000"));
    }


    @Test
    public void testCheckPin() throws Exception {
        assertTrue(atm.checkPin());

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
            Card card;

            @Override
            public void insertCard() {
                card = new Card("0000", "somewhere@nowhere.com");
            }

            @Override
            public boolean checkPin(String pin) {
                return card.getPin().equals(pin);
            }

            @Override
            public String getAdress() {
                return card.getAdress();
            }


        };
    }

    public static Display createTestDisplay() {
        return new Display() {
            @Override
            public void show(String s) {

            }

            @Override
            public int getAmount() {
                return 0;
            }

            @Override
            public String getPin() {
                return "0000";
            }
        };
    }


}
