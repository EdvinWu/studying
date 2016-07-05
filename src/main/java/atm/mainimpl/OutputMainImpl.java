package atm.mainimpl;

import atm.services.Output;

public class OutputMainImpl implements Output {

    @Override
    public void withdraw(int amount) {
        System.out.println("Giving " + amount);
    }

}
