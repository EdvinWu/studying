package implementation;

import atm.Input;

public class InputImpl implements Input {
    private boolean successful = false;

    @Override
    public void deposit(int amount) {
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
