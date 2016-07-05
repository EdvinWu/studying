package implementation;

import atm.Output;

public class OutputImpl implements Output {
    private boolean successful = false;

    @Override
    public void withdraw(int amount) {
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
