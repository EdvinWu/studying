package atm;

import atm.implementation.*;
import atm.mainimpl.*;
import atm.services.*;
import com.google.inject.AbstractModule;
import com.google.inject.Module;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CardReader.class).to(CardReaderTestImpl.class);
        bind(Display.class).to(DisplayTestImpl.class);
        bind(Input.class).to(InputTestImpl.class);
        bind(Output.class).to(OutputTestImpl.class);
        bind(ServerConnector.class).to(ServerConnectorTestImpl.class);
    }
}
