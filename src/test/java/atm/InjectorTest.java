package atm;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class InjectorTest {
    @Test
    public void testCustomInjector() throws Exception{
        Injector injector = Guice.createInjector(new TestModule());
        ATM atm = injector.getInstance(ATM.class);

    }




}
