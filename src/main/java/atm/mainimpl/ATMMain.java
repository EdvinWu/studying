package atm.mainimpl;

import atm.ATM;
import atm.services.*;
import implementation.*;

public class ATMMain extends ATM {
    CardReader cardReader = new CardReaderImpl();
    Display display = new DisplayImpl();
    ServerConnector serverConnector = new ServerConnectorImpl();
    Output output = new OutputImpl();
    Input input = new InputImpl();

}
