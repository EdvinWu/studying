package atm.mainimpl;

import atm.services.Output;

public class OutputMainImpl implements Output {
    private boolean successful = false;

    @Override
    public void withdraw(int amount) {
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
