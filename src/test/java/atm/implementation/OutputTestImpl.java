package atm.implementation;

import atm.services.Output;
import com.google.inject.Singleton;

@Singleton
public class OutputTestImpl implements Output {
    private boolean successful = false;

    @Override
    public void withdraw(int amount) {
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
