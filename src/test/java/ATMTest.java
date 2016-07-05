import atm.*;
import atm.services.*;
import consts.Consts;
import consts.Operation;
import atm.implementation.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    CardReader cardReader = new CardReaderTestImpl();
    Display display = new DisplayTestImpl();
    ServerConnector serverConnector = new ServerConnectorTestImpl();
    Output output = new OutputImpl();
    Input input = new InputTestImpl();
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
    public void testGetBalance() throws Exception {
        assertEquals(atm.getBalance(), 200);
    }

    @Test
    public void testGetAccountName() throws Exception {
        assertEquals(atm.getAccountName(), Consts.NAME.toString());
    }

    @Test
    public void testNotEnoughError() throws Exception {
        atm.notEnoughError();
        assertEquals(((DisplayTestImpl)display).getMsg(), Consts.NOT_ENOUGH_AMOUNT.toString());
    }

    @Test
    public void testWrongPin() throws Exception {
        atm.wrongPin();
        assertEquals(((DisplayTestImpl)display).getMsg(), Consts.WRONG_PIN_MSG.toString());
    }

    @Test
    public void testWithdrawScenario() throws Exception {
        withdrawScenario(100, Consts.PIN.toString());

        assertTrue(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 100);
        assertEquals(((DisplayTestImpl) display).getMsg(), "Current balance 100");
    }


    @Test
    public void testWithdrawFailingAmountScenario() throws Exception {
        withdrawScenario(1000, Consts.PIN.toString());

        assertFalse(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayTestImpl) display).getMsg(), "Not enough money on the account");
    }

    @Test
    public void testWithdrawFailingPinScenario() throws Exception {
        withdrawScenario(200, "9999");

        assertFalse(((OutputImpl) output).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayTestImpl) display).getMsg(), "Wrong PIN");
    }

    @Test
    public void testDepositScenario() throws Exception {
        depositScenario(Consts.PIN.toString());

        assertTrue(((InputTestImpl) input).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 300);
        assertEquals(((DisplayTestImpl) display).getMsg(), "Current balance 300");
    }

    @Test
    public void testDepositFailingPinScenario() throws Exception {
        depositScenario("9999");

        assertFalse(((InputTestImpl) input).isSuccessful());
        assertEquals(serverConnector.getBalance(Consts.ADDRESS.toString()), 200);
        assertEquals(((DisplayTestImpl) display).getMsg(), "Wrong PIN");
    }

    private void withdrawScenario(int amount, String pin) {
        atm.insertCard();
        ((DisplayTestImpl)display).setOperation(Operation.WITHDRAW);


        ((CardReaderTestImpl)cardReader).getCard().setPin(pin);

        Operation op = atm.chooseOperation();
        if (op == Operation.WITHDRAW) {
            if (atm.checkPin()) {
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

    private void depositScenario(String pin) {
        atm.insertCard();
        ((DisplayTestImpl)display).setOperation(Operation.DEPOSIT);

        ((CardReaderTestImpl)cardReader).getCard().setPin(pin);
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
