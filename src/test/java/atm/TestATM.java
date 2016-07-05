package atm;

import atm.services.*;

public class TestATM extends ATM {
    public TestATM(CardReader cardReader, Display display, ServerConnector serverConnector, Output output, Input input) {
        this.cardReader = cardReader;
        this.display = display;
        this.serverConnector = serverConnector;
        this.output = output;
        this.input = input;
    }



}
