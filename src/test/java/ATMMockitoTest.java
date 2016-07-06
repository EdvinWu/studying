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
        atm.insertCard();
        when(display.getOperation()).thenReturn(Operation.WITHDRAW);

        Operation op = atm.chooseOperation();
        if (op == Operation.WITHDRAW) {
            when(display.getPin()).thenReturn(Consts.PIN.toString());
            when(cardReader.checkPin(Consts.PIN.toString())).thenReturn(true);

            if (atm.checkPin()) {
                verify(cardReader).checkPin(Consts.PIN.toString());
                when(cardReader.getAdress()).thenReturn(Consts.ADDRESS.toString());
                when(serverConnector.getBalance(Consts.ADDRESS.toString())).thenReturn(200);
                if (atm.checkSum(100)) {
                    verify(serverConnector).getBalance(Consts.ADDRESS.toString());
                    atm.withdraw(100);
                    verify(output).withdraw(100);
                    verify(serverConnector).changeBalance(Consts.ADDRESS.toString(), -100);
                } else {
                    atm.notEnoughError();
                }
            } else {
                atm.wrongPin();
            }
        }

    }
}
