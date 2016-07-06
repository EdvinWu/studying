package atm.implementation;

import atm.services.Input;
import com.google.inject.Singleton;

@Singleton
public class InputTestImpl implements Input {
    private boolean successful = false;

    @Override
    public void deposit(int amount) {
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
