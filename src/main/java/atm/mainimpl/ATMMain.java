package atm.mainimpl;

import atm.ATM;
import atm.services.*;

public class ATMMain extends ATM {
    public ATMMain(CardReader cardReader, Display display, ServerConnector serverConnector, Output output, Input input) {
        this.cardReader = cardReader;
        this.display = display;
        this.serverConnector = serverConnector;
        this.output = output;
        this.input = input;
    }
}
