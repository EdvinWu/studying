package atm.implementation;

import atm.services.Display;
import com.google.inject.Singleton;
import consts.Operation;
import consts.Consts;

import static org.junit.Assert.assertEquals;

@Singleton
public class DisplayTestImpl implements Display{
    private String msg = "";
    private Operation operation = Operation.WITHDRAW;

    public void setOperation(Operation op) {
        operation = op;
    }

    @Override
    public void show(String s) {
        assertEquals(s, Consts.NOT_ENOUGH_AMOUNT.toString());
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
