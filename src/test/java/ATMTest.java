import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    CardReader cardReader = createTestCardReader();
    Display display = createTestDisplay();
    ServerConnector serverConnector = createServerConnector();
    Output output = createOutput();
    Input input = createInput();
    ATM atm = new TestATM(cardReader, display, serverConnector, output, input);

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
        int actual = atm.selectAmount();
        assertEquals(actual, 0);
    }

    @Test
    public void testCheckSum() throws Exception {
        assertTrue(atm.checkSum(atm.selectAmount()));
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

    @Test
    public void testWithdrawScenario() throws Exception {
        atm.insertCard();
        if (atm.checkPin()) {
            int amount = atm.selectAmount();
            if (atm.checkSum(amount)) {
                atm.withdraw(amount);
            } else {
                atm.notEnoughError();
            }
        } else {
            atm.wrongPin();
        }


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

    public static ServerConnector createServerConnector() {
        return new ServerConnector() {
            int balance;

            @Override
            public int getBalance(String address) {
                return balance;
            }

            @Override
            public void changeBalance(String address, int diff) {
                balance += diff;
            }
        };
    }

    public static Output createOutput() {
        return new Output() {
            private boolean successful = false;

            @Override
            public void withdraw(int amount) {
                successful = true;
            }

            public boolean isSuccessful() {
                return successful;
            }
        };
    }

    public static Input createInput() {
        return new Input() {
            private boolean successful = false;

            @Override
            public void deposit(int amount) {
                successful = true;
            }

            public boolean isSuccessful() {
                return successful;
            }
        };
    }


}
