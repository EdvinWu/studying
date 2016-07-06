import atm.ATM;
import atm.services.*;
import consts.Consts;
import consts.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ATMMockitoTest {


    public static final int MAX_BALANCE = 200;
    public static final int AMOUNT = 100;
    @InjectMocks
    ATM atm;

    @Mock
    Input input;
    @Mock
    Output output;
    @Mock
    Display display;
    @Mock
    ServerConnector serverConnector;
    @Mock
    CardReader cardReader;

    @Test
    public void testInsertCard() throws Exception {
        atm.insertCard();
        verify(cardReader).insertCard();
    }

    @Test
    public void testWithdrawScenario() throws Exception {
        when(display.getOperation()).thenReturn(Operation.WITHDRAW);
        when(display.getPin()).thenReturn(Consts.PIN.toString());
        when(cardReader.checkPin(Consts.PIN.toString())).thenReturn(true);
        when(cardReader.getAddress()).thenReturn(Consts.ADDRESS.toString());
        when(serverConnector.getBalance(Consts.ADDRESS.toString())).thenReturn(MAX_BALANCE);

        atm.insertCard();
        verify(cardReader).insertCard();

        Operation op = atm.chooseOperation();
        if (op == Operation.WITHDRAW) {
            verify(display).getOperation();

            if (atm.checkPin()) {
                verify(cardReader).checkPin(Consts.PIN.toString());

                if (atm.checkSum(AMOUNT)) {
                    verify(serverConnector).getBalance(Consts.ADDRESS.toString());

                    atm.withdraw(AMOUNT);
                    verify(output).withdraw(AMOUNT);
                    verify(serverConnector).changeBalance(Consts.ADDRESS.toString(), -AMOUNT);

                } else {
                    atm.notEnoughError();
                }
            } else {
                atm.wrongPin();
            }
        }

    }
}
