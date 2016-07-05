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
        assertEquals(cardReader.getAdress(), Consts.ADDRESS.toString());
        assertTrue(cardReader.checkPin(Consts.PIN.toString()));
    }


    @Test
    public void testCheckPin() throws Exception {
        assertTrue(atm.checkPin());

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
    public void testNotEnoughError() throws Exception {

    }

    @Test
    public void testWrongPin() throws Exception {

    }

    @Test
    public void testWithdrawScenario() throws Exception {
        withdrawScenario(false, false);

        assertTrue(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 100);
        assertEquals(((DisplayImpl) display).getMsg(), "");
    }


    @Test
    public void testWithdrawFailingAmountScenario() throws Exception {
        withdrawScenario(true, false);

        assertFalse(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayImpl) display).getMsg(), "Not enough money on the account");
    }

    @Test
    public void testWithdrawFailingPinScenario() throws Exception {
        withdrawScenario(false, true);

        assertFalse(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayImpl) display).getMsg(), "Wrong PIN");
    }

    @Test
    public void testDepositScenario() throws Exception {
        depositScenario(false);

        assertTrue(((InputImpl) input).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 300);
        assertEquals(((DisplayImpl) display).getMsg(), "");
    }

    @Test
    public void testDepositFailingPinScenario() throws Exception {
        depositScenario(true);

        assertFalse(((InputImpl) input).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayImpl) display).getMsg(), "Wrong PIN");
    }

    private void withdrawScenario(boolean failAmount, boolean failPin) {
        atm.insertCard();
        ((DisplayImpl)display).setOperation(Operation.WITHDRAW);

        if (failPin)
            ((CardReaderImpl)cardReader).getCard().setPin("9999");

        Operation op = atm.chooseOperation();
        if (op == Operation.WITHDRAW) {
            if (atm.checkPin()) {
                int amount = (failAmount ? 1000 : atm.selectAmount());
                if (atm.checkSum(amount)) {
                    atm.withdraw(amount);
                } else {
                    atm.notEnoughError();
                }
            } else {
                atm.wrongPin();
            }
        }
    }

    private void depositScenario(boolean failPin) {
        atm.insertCard();
        ((DisplayImpl)display).setOperation(Operation.DEPOSIT);

        if (failPin)
            ((CardReaderImpl)cardReader).getCard().setPin("9999");
        Operation op = atm.chooseOperation();
        if (op == Operation.DEPOSIT) {
            if (atm.checkPin()) {
                int amount = atm.selectAmount();
                atm.deposit(amount);

            } else {
                atm.wrongPin();
            }
        }
    }

}
