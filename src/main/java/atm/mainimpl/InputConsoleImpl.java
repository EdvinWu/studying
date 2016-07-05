package atm.mainimpl;

import atm.services.Input;

public class InputConsoleImpl implements Input {

    @Override
    public void deposit(int amount) {
        System.out.println("Received " + amount);
    }

}
