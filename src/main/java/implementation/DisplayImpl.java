package implementation;

import atm.Display;

public class DisplayImpl implements Display{
    private String msg = "";

    @Override
    public void show(String s) {
        msg = s;
    }

    @Override
    public int getAmount() {
        return 100;
    }

    @Override
    public String getPin() {
        return Consts.PIN.toString();
    }

    public String getMsg() {
        return msg;
    }
}
