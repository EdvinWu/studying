package atm.services;

import consts.Operation;

public interface Display {
    public void show(String s);

    public int getAmount();

    String getPin();

    Operation getOperation();
}
