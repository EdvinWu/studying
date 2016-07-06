package atm;

import atm.mainimpl.*;
import atm.services.*;
import com.google.inject.AbstractModule;

public class ATMModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CardReader.class).to(CardReaderConsoleImpl.class);
        bind(Display.class).to(DisplayConsoleImpl.class);
        bind(Input.class).to(InputConsoleImpl.class);
        bind(Output.class).to(OutputConsoleImpl.class);
        bind(ServerConnector.class).to(ServerConnectorConsoleImpl.class);
    }
}
