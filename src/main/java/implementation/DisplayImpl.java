package implementation;

import atm.services.Display;
import consts.Operation;
import consts.Consts;

public class DisplayImpl implements Display{
    private String msg = "";
    private Operation operation = Operation.WITHDRAW;

    public void setOperation(Operation op) {
        operation = op;
    }

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

    @Override
    public Operation getOperation() {
        return operation;
    }

    public String getMsg() {
        return msg;
    }
}
