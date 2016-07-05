package implementation;

import atm.Display;

public class DisplayImpl implements Display{
    @Override
    public void show(String s) {
        System.out.println(s);
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getPin() {
        return "0000";
    }
}
