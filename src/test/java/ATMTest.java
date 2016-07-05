import atm.*;
import implementation.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    CardReader cardReader = new CardReaderImpl();
    Display display = new DisplayImpl();
    ServerConnector serverConnector = new ServerConnectorImpl();
    Output output = new OutputImpl();
    Input input = new InputImpl();
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
        assertEquals(actual, 100);
    }

    @Test
    public void testCheckSum() throws Exception {
        assertTrue(atm.checkSum(atm.selectAmount()));
    }

    @Test
    public void testCheckSumFail() throws Exception {
        assertFalse(atm.checkSum(1000));
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

        assertTrue(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(""), 100);




    }

}
