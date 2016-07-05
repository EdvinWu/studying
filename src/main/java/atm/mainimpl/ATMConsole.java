package atm.mainimpl;

import atm.ATM;

public class ATMConsole extends ATM {
    public ATMConsole() {
        cardReader = new CardReaderConsoleImpl();
        display = new DisplayConsoleImpl();
        serverConnector = new ServerConnectorConsoleImpl();
        output = new OutputConsoleImpl();
        input = new InputConsoleImpl();
    }

}
