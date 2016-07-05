package atm.mainimpl;

import atm.services.Display;
import consts.Consts;
import consts.Operation;

public class DisplayMainImpl implements Display{
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
