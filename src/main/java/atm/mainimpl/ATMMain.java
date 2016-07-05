package atm.mainimpl;

import atm.ATM;
import implementation.*;

public class ATMMain extends ATM {
    public ATMMain() {
        cardReader = new CardReaderMainImpl();
        display = new DisplayMainImpl();
        serverConnector = new ServerConnectorMainImpl();
        output = new OutputMainImpl();
        input = new InputMainImpl();
    }

}
